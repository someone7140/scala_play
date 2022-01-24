package model.domain

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.{BlobId, BlobInfo, StorageOptions}
import com.typesafe.config.ConfigFactory
import org.apache.commons.io.FilenameUtils
import play.api.libs.json.Json

import java.io.File
import java.nio.file.{Files, Paths}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

object HiyariHattoReferenceFile {

  implicit val jsonWrites = Json.writes[HiyariHattoReferenceFile]
  implicit val jsonReads = Json.reads[HiyariHattoReferenceFile]

  val config = ConfigFactory.load()

  // ファイルをGCSにアップロードしてクラスを取得
  def uploadFileToGcsFuture(uploadFile: File, fileName: String, title: String, env: play.api.Environment)(implicit ec: ExecutionContext): Future[Try[HiyariHattoReferenceFile]] = {
    Future {
      Try {
        val resource = env.resourceAsStream("gcsKey.json")
        val credentials = GoogleCredentials
          .fromStream(resource.get)
          .createScoped("https://www.googleapis.com/auth/cloud-platform")
        val fileId = java.util.UUID.randomUUID.toString
        val storage = StorageOptions.newBuilder
          .setCredentials(credentials)
          .setProjectId(config.getString("gcs.projectId")).build.getService()

        val ext = FilenameUtils.getExtension(fileName)
        val filePath = config.getString("gcs.hiyariHattoRefer.folder") + fileId + (if (!ext.isEmpty) "." + ext else "")
        val blobId = BlobId.of(config.getString("gcs.bucket"), filePath)
        val blobInfo = BlobInfo.newBuilder(blobId).build
        val blobFile = storage.create(blobInfo, Files.readAllBytes(Paths.get(uploadFile.getPath())))
        val url = blobFile.getMediaLink()
        HiyariHattoReferenceFile(fileId, title, url)
      }
    }
  }
}

case class HiyariHattoReferenceFile(id: String = "",
                                    title: String,
                                    fileUrl: String)
