package useCase

import com.google.api.client.auth.oauth2.{BearerToken, Credential}
import com.typesafe.config.ConfigFactory
import com.google.api.client.auth.oauth2.ClientParametersAuthentication
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.oauth2.Oauth2
import play.api.mvc.Results.Unauthorized
import play.api.mvc.{AnyContent, Request, Result}
import model.domain.AuthUser

object AuthUserUseCase {

  val config = ConfigFactory.load()

  def authByGoogleAuthCode(authCode: String): Option[AuthUser] = {
    val clientId = config.getString("google.clientId")
    val secret = config.getString("google.secret")
    // authCodeからtokenを取得
    val req = new GoogleAuthorizationCodeTokenRequest(
      new NetHttpTransport(),
      GsonFactory.getDefaultInstance(),
      "https://oauth2.googleapis.com/token",
      clientId,
      secret,
      authCode,
      "postmessage"
    )
    req.setGrantType("authorization_code")
    val tokenResponse = req.execute()
    // tokenからアカウント情報を取得
    val credential = new Credential.Builder(BearerToken.authorizationHeaderAccessMethod())
      .setTransport(new NetHttpTransport())
      .setJsonFactory(GsonFactory.getDefaultInstance())
      .setClientAuthentication(new ClientParametersAuthentication(clientId, secret))
      .setTokenServerUrl(new GenericUrl(
        config.getString("backendUrl")
      ))
      .build()
      .setFromTokenResponse(tokenResponse)
    val oauth2 =
      new Oauth2.Builder(new NetHttpTransport(), new GsonFactory(), credential)
        .setApplicationName("Oauth2")
        .build()
    val userInfo = oauth2.userinfo().get().execute()
    AuthUser.updateDBByGoogleUser(userInfo)
  }

  def withUser[T](block: AuthUser => Result)(implicit request: Request[AnyContent]): Result = {

    val authTokenOpt = request.headers.get("Authorization")
    authTokenOpt
      .flatMap(token => {
        AuthUser.getAuthUserFromToken(token)
      })
      .map(block)
      .getOrElse(Unauthorized)
  }
}
