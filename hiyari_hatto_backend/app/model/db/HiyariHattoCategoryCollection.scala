package model.db

import org.joda.time.DateTime
import play.api.libs.json.JodaReads.DefaultJodaDateTimeReads
import play.api.libs.json.JodaWrites.JodaDateTimeWrites
import play.api.libs.json._
import play.api.libs.functional.syntax._

object HiyariHattoCategoryCollection {

  implicit val hiyariHattoCategoryCollectionFormat = (
    (__ \ "_id").format[String] ~
      (__ \ "name").format[String] ~
      (__ \ "register_user_id").format[String] ~
      (__ \ "register_date").format[DateTime]
    ) (HiyariHattoCategoryCollection.apply, unlift(HiyariHattoCategoryCollection.unapply))

}

case class HiyariHattoCategoryCollection(id: String = "",
                                         name: String = "",
                                         registerUserId: String = "",
                                         registerDate: DateTime = DateTime.now())

