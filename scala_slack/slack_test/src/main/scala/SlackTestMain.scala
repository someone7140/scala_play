import akka.actor.ActorSystem
import scala.util.{ Success, Failure }
import scala.concurrent.ExecutionContext.Implicits.global
import slack.api.SlackApiClient

object Main extends App {
  implicit val system = ActorSystem("slack")
  val token = "<Tokenを入力>"
  val client = SlackApiClient(token)
  // ユーザ一覧を取得するサンプル
  client.listUsers().onComplete {
    case Success(users) =>
      users.foreach(u =>
        println(s"${u.id}：${u.name}")
      )
    case Failure(t) => println(s"${t.getMessage()}")
  }
  // チャンネル一覧を取得するサンプル
  client.listChannels().onComplete {
    case Success(channels) =>
      channels.foreach(c =>
        println(s"${c.id}：${c.name}")
      )
    case Failure(t) => println(s"${t.getMessage()}")
  }
  // チャネルIDと送信ユーザを指定してメッセージを送るサンプル

}