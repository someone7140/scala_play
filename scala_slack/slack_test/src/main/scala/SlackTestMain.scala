import akka.actor.ActorSystem
import scala.util.{ Success, Failure }
import scala.concurrent.ExecutionContext.Implicits.global
import slack.api.SlackApiClient

object Main extends App {
  implicit val system = ActorSystem("slack")
  val token = "ここに取得したtokenを設定"
  val client = SlackApiClient(token)

  // ユーザ一覧を取得するサンプル
  client.listUsers().onComplete {
    case Success(users) =>
      users.foreach(u =>
        println(s"${u.id}：${u.name}")
      )
    case Failure(t) => println(s"error:${t.getMessage()}")
  }

  // チャンネル一覧を取得するサンプル
  client.listChannels().onComplete {
    case Success(channels) =>
      channels.foreach(c =>
        println(s"${c.id}：${c.name}")
      )
    case Failure(t) => println(s"error:${t.getMessage()}")
  }

  // チャネルIDまたは送信先のユーザIDを指定してtestメッセージを送るサンプル（送信者はToken発行ユーザ）
  client.postChatMessage(channelId = "ここにIDを設定", text = "test", asUser = Some(true)).onComplete {
    case Success(_) =>
      println("Success")
    case Failure(t) =>
      println(s"error:${t.getMessage()}")
  }

}
