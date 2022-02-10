package useCase

import model.api.hiyariHatto.{HiyariHattoCategoryCreateRequest, HiyariHattoReferenceFileForUpdate}
import model.domain.{AuthUser, HiyariHattoCategory, HiyariHattoPost, HiyariHattoReferenceFile, HiyariHattoReferenceUrl}
import org.joda.time.DateTime
import play.api.libs.Files
import play.api.mvc.MultipartFormData

object HiyariHattoUseCase {

  def createHiyariHattoCategory(request: HiyariHattoCategoryCreateRequest, user: AuthUser): Option[String] = {
    HiyariHattoCategory.createCategory(request.name, user.id).collect(category =>
      category.id
    )
  }

  def updateHiyariHattoCategory(id: String, name: String, userId: String): Option[HiyariHattoCategory] = {
    HiyariHattoCategory.updateCategory(id, name, userId)
  }

  def deleteHiyariHattoCategory(id: String, userId: String): Boolean = {
    HiyariHattoCategory.deleteCategory(id, userId)
  }

  def listHiyariHattoCategory(userId: String): Seq[HiyariHattoCategory] = {
    HiyariHattoCategory.getCategoryList(userId)
  }

  def createHiyariHattoPost(title: String,
                            detail: Option[String],
                            userId: String,
                            categoryIds: Seq[String],
                            occurDateTime: Option[DateTime],
                            referenceUrls: Seq[HiyariHattoReferenceUrl],
                            referenceImages: Seq[HiyariHattoReferenceFile]
                           ): Option[HiyariHattoPost] = {
    HiyariHattoPost.createPost(
      title, detail, userId, categoryIds, occurDateTime, referenceUrls, referenceImages
    )
  }


  def updateHiyariHattoPost(registeredPost: HiyariHattoPost,
                            title: String,
                            detail: Option[String],
                            categoryIds: Seq[String],
                            occurDateTime: Option[DateTime],
                            requestReferenceUrls: Seq[HiyariHattoReferenceUrl],
                            requestReferenceFiles: Seq[HiyariHattoReferenceFileForUpdate],
                            uploadFiles: Seq[MultipartFormData.FilePart[Files.TemporaryFile]],
                            userId: String,
                            env: play.api.Environment
                           ): Option[HiyariHattoPost] = {
    // 削除対象画像を抽出して画像削除
    registeredPost.referenceFiles.collect { case file
      if !requestReferenceFiles.contains(file.id) || requestReferenceFiles.exists(rFile =>
        rFile.fileUpdateFlag.isDefined && rFile.id.fold(false)(id => file.id == id)) =>
      file.deleteFileFromGcs(env)
    }
    // fileオブジェクトの画像差し替え
    val uploadTargetFiles = registeredPost.referenceFiles.filter(file => {
      requestReferenceFiles.exists(rFile =>
        rFile.fileUpdateFlag.isDefined && rFile.id.fold(false)(id => file.id == id)
      )
    })
    val uploadResult = GoogleCloudStorageUseCase.uploadFilesToGcs(
      uploadFiles.slice(0, uploadTargetFiles.length), uploadTargetFiles, env
    )
    // 新規のfileアップロード
    val newFileUploadTargetFiles = requestReferenceFiles.collect { case file if file.id.isEmpty =>
      HiyariHattoReferenceFile(title = file.title)
    }
    val newUploadResult = GoogleCloudStorageUseCase.uploadFilesToGcs(
      uploadFiles.slice(uploadTargetFiles.length, uploadFiles.length), newFileUploadTargetFiles, env
    )
    if (uploadResult.isLeft || newUploadResult.isLeft) {
      None
    } else {
      val uploadReferenceFiles = uploadResult.getOrElse(Seq.empty[HiyariHattoReferenceFile])
      HiyariHattoPost.updatePost(
        registeredPost.id,
        title,
        detail,
        userId,
        categoryIds,
        occurDateTime,
        requestReferenceUrls,
        requestReferenceFiles.collect { case reqFile if registeredPost.referenceFiles.exists(refFile =>
          reqFile.id == refFile.id
        ) => {
          val refFile = registeredPost.referenceFiles.find(f => f.id == reqFile.id.getOrElse("")).get
          val uploadFileOpt = uploadReferenceFiles.find(f => f.id == reqFile.id.getOrElse(""))
          if (uploadFileOpt.isEmpty) {
            HiyariHattoReferenceFile(
              reqFile.id.getOrElse(""), reqFile.title, refFile.fileUrl
            )
          } else {
            HiyariHattoReferenceFile(
              reqFile.id.getOrElse(""), reqFile.title, uploadFileOpt.get.fileUrl
            )
          }
        }
        } ++ newUploadResult.getOrElse(Seq.empty[HiyariHattoReferenceFile])
      )
    }
  }

  def deleteHiyariHattoPost(id: String, userId: String, env: play.api.Environment): Boolean = {
    val post = HiyariHattoPost.getPostListById(id, userId)
    post.fold(true)(p => {
      p.referenceFiles.foreach(file => {
        file.deleteFileFromGcs(env)
      })
      HiyariHattoPost.deletePost(id, userId)
    })
  }

  def listHiyariHattoPost(userId: String): Seq[HiyariHattoPost] = {
    HiyariHattoPost.getPostList(userId)
  }
}
