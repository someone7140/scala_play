package model.domain

import org.joda.time.DateTime
import repository.HiyariHattoPostRepository

object HiyariHattoPost {

  def createPost(title: String,
                 detail: Option[String],
                 userId: String,
                 categoryIds: Seq[String],
                 occurDateTime: Option[DateTime],
                 referenceUrls: Seq[HiyariHattoReferenceUrl],
                 referenceFiles: Seq[HiyariHattoReferenceFile]): Option[HiyariHattoPost] = {
    HiyariHattoPostRepository.insertPost(
      title, detail, userId, categoryIds, occurDateTime, referenceUrls, referenceFiles
    ).collect(_.transferToDomainModel())
  }

  def getPostList(userId: String): Seq[HiyariHattoPost] = {
    HiyariHattoPostRepository.getPostList(userId).collect(_.transferToDomainModel())
  }

}
case class HiyariHattoPost(id: String = "",
                           title: String = "",
                           detail: Option[String] = None,
                           userId: String,
                           categoryIds: Seq[String] = Seq.empty,
                           occurDateTime: Option[DateTime] = None,
                           referenceUrls: Seq[HiyariHattoReferenceUrl] = Seq.empty,
                           referenceFiles: Seq[HiyariHattoReferenceFile] = Seq.empty)
