package model.domain

import org.joda.time.DateTime

import java.io.File
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

case class HiyariHattoPost(id: String = "",
                           title: String = "",
                           categoryIds: Seq[String] = Seq.empty,
                           occurDateTime: DateTime,
                           referenceUrls: Seq[ReferenceUrl] = Seq.empty,
                           referenceImages: Seq[ReferenceImage] = Seq.empty)
