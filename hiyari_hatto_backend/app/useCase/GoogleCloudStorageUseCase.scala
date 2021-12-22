package useCase

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.StorageOptions
import com.typesafe.config.ConfigFactory

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

object GoogleCloudStorageUseCase {

  implicit val ec = ExecutionContext.global
  val config = ConfigFactory.load()

  // ファイルをGCSにアップロードする
  def uploadFileToGcsFuture(imageFile: File, uploadFilePath: String)(implicit ec: ExecutionContext): Future[Try[String]] = {
    Future {
      Try {
        val storage = StorageOptions.newBuilder.setProjectId(config.getString("gcs.projectId")).build.getService()
        val blobId = BlobId.of(config.getString("gcs.bucket"), uploadFilePath)
        val blobInfo = BlobInfo.newBuilder(blobId).build
        val blobFile = storage.create(blobInfo, Files.readAllBytes(Paths.get(imageFile.getPath())))
        blobFile.getMediaLink()
      }
    }
  }

}
