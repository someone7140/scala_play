package model.db

import org.joda.time.DateTime
import play.api.libs.json.JodaReads.DefaultJodaDateTimeReads
import play.api.libs.json.JodaWrites.JodaDateTimeWrites
import play.api.libs.json._
import play.api.libs.functional.syntax._

object UserCollection {

  implicit val userCollectionFormat = (
    (__ \ "_id").format[String] ~
      (__ \ "name").format[String] ~
      (__ \ "google_id").formatNullable[String] ~
      (__ \ "auth_date").formatNullable[DateTime]
    )(UserCollection.apply, unlift(UserCollection.unapply))

}

case class UserCollection(id: String = "",
                          name: String = "",
                          googleId: Option[String] = None,
                          authDate: Option[DateTime] = None)

