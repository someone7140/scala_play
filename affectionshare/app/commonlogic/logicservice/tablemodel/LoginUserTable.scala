package commonlogic.logicservice.tablemodel

import scalikejdbc._
import java.time.ZonedDateTime
import java.util.Date

// LoginUserテーブルのクラス
case class LoginUserTable(userid: String, userpw: String, username:String ,
                           usercategory:Int, lastlogin: ZonedDateTime, gender:String,
                           email:String, lineid:String, telephone:String, birhtdate:Date)
                           
object LoginUserTable extends SQLSyntaxSupport[LoginUserTable] {

   override val schemaName: Option[String] = None
   override val tableName: String = "LOGIN_USER"

   def apply(loginuser: ResultName[LoginUserTable])(rs: WrappedResultSet): LoginUserTable = {
     LoginUserTable(rs.string(loginuser.userid), rs.string(loginuser.userpw) , rs.string(loginuser.username), 
                    rs.int(loginuser.usercategory), rs.zonedDateTime(loginuser.lastlogin), rs.string(loginuser.gender),
                    rs.string(loginuser.email), rs.string(loginuser.lineid), rs.string(loginuser.telephone)
                    , rs.date(loginuser.birhtdate)
                   )
   }
   
}


