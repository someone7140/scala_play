package model.domain

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.{BlobId, BlobInfo, Storage, StorageOptions}
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
  def uploadFileToGcsFuture(uploadFile: File, fileName: String, refereceFile: HiyariHattoReferenceFile, env: play.api.Environment)(implicit ec: ExecutionContext): Future[Try[HiyariHattoReferenceFile]] = {
    Future {
      Try {
        val fileId = if (refereceFile.id.isEmpty) java.util.UUID.randomUUID.toString else refereceFile.id
        val storage = getStorageObject(env)

        val ext = FilenameUtils.getExtension(fileName)
        val blobId = getBlobId(fileId + (if (!ext.isEmpty) "." + ext else ""))
        val blobInfo = BlobInfo.newBuilder(blobId).build
        val blobFile = storage.create(blobInfo, Files.readAllBytes(Paths.get(uploadFile.getPath())))
        val url = blobFile.getMediaLink()
        HiyariHattoReferenceFile(fileId, refereceFile.title, url)
      }
    }
  }

  def getStorageObject(env: play.api.Environment): Storage = {
    val resource = env.resourceAsStream("gcsKey.json")
    val credentials = GoogleCredentials
      .fromStream(resource.get)
      .createScoped("https://www.googleapis.com/auth/cloud-platform")
    StorageOptions.newBuilder
      .setCredentials(credentials)
      .setProjectId(config.getString("gcs.projectId")).build.getService()
  }

  def getBlobId(fileName: String): BlobId = {
    val filePath = config.getString("gcs.hiyariHattoRefer.folder") + fileName
    BlobId.of(config.getString("gcs.bucket"), filePath)
  }
}

case class HiyariHattoReferenceFile(id: String = "",
                                    title: String = "",
                                    fileUrl: String = "") {

  import model.domain.HiyariHattoReferenceFile.{getBlobId, getStorageObject}

  // GCSからファイルを削除
  def deleteFileFromGcs(env: play.api.Environment): Boolean = {
    val storage = getStorageObject(env)
    val blobId = getBlobId(getFileNameFormUrl())
    storage.delete(blobId)
  }

  // URLからファイル名を取得
  def getFileNameFormUrl(): String = {
    fileUrl.substring(fileUrl.lastIndexOf("%2F") + 3, fileUrl.lastIndexOf("?"))
  }
}
