package useCase

import model.domain.HiyariHattoReferenceFile
import play.api.libs.Files
import play.api.mvc.MultipartFormData

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object GoogleCloudStorageUseCase {
  implicit val ec = ExecutionContext.global

  // 複数ファイルをGCSにアップロードする
  def uploadFilesToGcs(
                        files: Seq[MultipartFormData.FilePart[Files.TemporaryFile]],
                        referenceImageTitles: Seq[String],
                        env: play.api.Environment): Either[Throwable, Seq[HiyariHattoReferenceFile]] = {
    val futureSeq = Future.sequence(files.zipWithIndex.map(f => {
      HiyariHattoReferenceFile.uploadFileToGcsFuture(
        f._1.ref.path.toFile,
        f._1.filename,
        referenceImageTitles(f._2),
        env
      )
    }))

    var exceptionSeq = Seq.empty[Throwable]
    var hiyariHattoReferenceImages = Seq.empty[HiyariHattoReferenceFile]
    val result = Await.ready(futureSeq, Duration.Inf).value.get
    result.collect(resSeq => resSeq.foreach(r => {
      r match {
        case Success(image) => hiyariHattoReferenceImages :+= image
        case Failure(ex) => exceptionSeq :+= ex
      }
    }))

    if (exceptionSeq.isEmpty) {
      Right(hiyariHattoReferenceImages)
    } else {
      Left(exceptionSeq.head)
    }
  }

}
