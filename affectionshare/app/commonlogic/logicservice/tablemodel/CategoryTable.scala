package commonlogic.logicservice.tablemodel

import scalikejdbc._
import java.time.ZonedDateTime
import java.util.Date

// Categoryテーブルのクラス
case class CategoryTable(categoryid: Option[Long], categoryname: String, lastupdate: ZonedDateTime, categorysort: String)
                           
object CategoryTable extends SQLSyntaxSupport[CategoryTable] {

   override val schemaName: Option[String] = None
   override val tableName: String = "POST_CATEGORY"

   def apply(category: ResultName[CategoryTable])(rs: WrappedResultSet): CategoryTable = {
     CategoryTable( rs.longOpt(category.categoryid), rs.string(category.categoryname) ,  rs.zonedDateTime(category.lastupdate) ,  rs.string(category.categorysort) )
   }
   
}



