package model.domain

import com.google.api.services.oauth2.model.Userinfo
import com.typesafe.config.ConfigFactory

import java.time.Clock
import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}
import play.api.libs.json.Json
import repository.GoogleUserRepository

object AuthUser {
  val config = ConfigFactory.load()

  implicit val jsonWrites = Json.writes[AuthUser]
  implicit val jsonReads = Json.reads[AuthUser]

  // tokenからユーザ情報を取得
  def getAuthUserFromToken(token: String): Option[AuthUser] = {
    val secret = config.getString("jwt.secret")
    if (!Jwt.isValid(token, secret, Seq(JwtAlgorithm.HS256))) {
      return None
    }
    val decodedJwt = Jwt.decode(token, secret, Seq(JwtAlgorithm.HS256))
    decodedJwt.toOption.flatMap(claim => {
      Json.parse(claim.content).validate[AuthUser].asOpt
    })
  }

  // googleUserInfoでDBを更新
  def updateDBByGoogleUser(googleUserInfo: Userinfo): Option[AuthUser] = {
    // すでに登録されているか
    val userFromDb = GoogleUserRepository.findUserByGoogleId(googleUserInfo.getId)
    userFromDb.fold({
      // 未登録の場合は新規登録
      val userCollectionOpt = GoogleUserRepository.insertUserByGoogleId(
        name = googleUserInfo.getName,
        googleId = googleUserInfo.getId
      )
      userCollectionOpt.collect(c => AuthUser(
        id = c.id,
        name = c.name,
        authMethod = "google"
      ))
    })(u => {
      // 登録済みの場合は名前と認証日を更新
      val userCollectionOpt = GoogleUserRepository.updateUserNameAndAuthDate(
        id = u.id,
        name = googleUserInfo.getName,
        googleId = googleUserInfo.getId
      )
      userCollectionOpt.collect(_ => AuthUser(
        id = u.id,
        name = googleUserInfo.getName(),
        authMethod = "google"
      ))
    })
  }
}

case class AuthUser(id: String = "",
                    name: String = "",
                    authMethod: String = "",
                   ) {
  val config = ConfigFactory.load()
  implicit val clock: Clock = Clock.systemUTC

  def getToken(): String = {
    val claim = Json.toJson(this)
    // 期限は3ヶ月
    Jwt.encode(
      JwtClaim(s"$claim").expiresIn(7776000),
      config.getString("jwt.secret"),
      JwtAlgorithm.HS256)
  }
}
