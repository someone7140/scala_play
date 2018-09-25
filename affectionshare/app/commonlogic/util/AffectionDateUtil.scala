package commonlogic.util

import java.util.Date
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.ZoneId

object AffectionDateUtil {
  
  val INIT_DATE_STRING = "1900-01-01 00:00:00"
  
  // 初期日付を取得
  def getInitDate():Date = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    sdf.parse(INIT_DATE_STRING)
  }
  
  // 初期の.ZonedDateTimeを取得
  def getInitZonedDateTime():ZonedDateTime = {
    ZonedDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneId.of("Asia/Tokyo"))
  }
  
}

