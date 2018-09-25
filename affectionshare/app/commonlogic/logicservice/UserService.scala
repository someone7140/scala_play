package commonlogic.logicservice

import scalikejdbc._
import java.time.ZonedDateTime
import java.util.Date
import commonlogic.logicservice.tablemodel.LoginUserTable
import commonlogic.util.AffectionDateUtil

object UserService {
  // ユーザ区分・管理者
  val ADMIN_USER:Int = 1
  // ユーザ区分・通常
  val COMMON_USER:Int = 2
  // ユーザ区分・利用停止
  val STOP_USER:Int = 9

  // ユーザ区分・管理者
  val ADMIN_USER_NAME:String = "管理者"
  // ユーザ区分・通常
  val COMMON_USER_NAME:String = "通常"
  // ユーザ区分・利用停止
  val STOP_USER_NAME:String = "利用停止"
  
  // 性別区分・男
  val GENDER_MALE:String = "M"
  // 性別区分・女
  val GENDER_FEMALE:String = "F"

  // 性別区分・男
  val GENDER_MALE_NAME:String = "男"
  // 性別区分・女
  val GENDER_FEMALE_NAME:String = "女"
  
  // 指定されたLoginUserTableを返す。
  def getUserIdObject(inputUserId:String):LoginUserTable = {
    // 空白チェック
    if(inputUserId.isEmpty()){
      null
    // ユーザIDで存在しているか
    }else{
      val l = LoginUserTable.syntax("l")
      var loginUserGet:Option[LoginUserTable] = null
      DB.readOnly { implicit session =>
        loginUserGet = withSQL {
             select
               .from(LoginUserTable as l)
               .where.eq(l.userid, inputUserId)
           }.map(LoginUserTable(l.resultName)).single.apply()
      }
      if(loginUserGet == None){
        null
      }else{
        loginUserGet.get
      }
    }
  }
  
  // 指定されたUserIdの最終ログイン日時を更新する
  def updateLastLogin(inputUserId:String)= {
    DB.localTx { implicit session =>
      withSQL {
        update(LoginUserTable).set(
          LoginUserTable.column.lastlogin -> ZonedDateTime.now
        ).where.eq(LoginUserTable.column.userid, inputUserId)
      }.update.apply()
      
    }
  }
  
  // ユーザの一覧を取得
  def getUserList():List[LoginUserTable]= {
    DB.localTx { implicit session =>
      val l = LoginUserTable.syntax("l")
      var userListGet:List[LoginUserTable] = null
      DB.readOnly { implicit session =>
        userListGet = withSQL {
             select
               .from(LoginUserTable as l)
           }.map(LoginUserTable(l.resultName)).list.apply()
      }
      if(userListGet == None){
        null
      }else{
        userListGet
      }
    }
  }
  
  // ユーザの変更
  def updateUser(useridInput:String , userpwInput:String , usernameInput:String, usercategoryInput:Option[Int] , genderInput:String
                ,emailInput:String , lineidInput:String , telephoneInput:String, birhtdateInput:Option[Date]):Boolean= {
    // userid空白チェック
    if( useridInput.isEmpty() ){
       false
    }else{
       // userpw空白チェック
       if( !userpwInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.userpw -> userpwInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // username空白チェック
       if( !userpwInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.userpw -> userpwInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // usercategoryInput空白チェック
       usercategoryInput match {
         case Some(usercategory) =>
           DB.localTx { implicit s =>
             val column = LoginUserTable.column
             withSQL {
               update(LoginUserTable).set(
                 column.usercategory -> usercategory
               )
              .where.eq(column.userid, useridInput)
             }.update.apply()
           }
         case None =>
           // 何もしない
       }
       // 性別空白チェック
       if( !genderInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.gender -> genderInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // email空白チェック
       if( !emailInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.email -> emailInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // lineid空白チェック
       if( !lineidInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.lineid -> lineidInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // 電話番号空白チェック
       if( !telephoneInput.isEmpty() ){
         DB.localTx { implicit s =>
           val column = LoginUserTable.column
           withSQL {
             update(LoginUserTable).set(
               column.telephone -> telephoneInput
             )
           .where.eq(column.userid, useridInput)
          }.update.apply()
         }
       }
       // 生年月日空白チェック
       birhtdateInput match {
         case Some(birhtdateInput) =>
           DB.localTx { implicit s =>
             val column = LoginUserTable.column
             withSQL {
               update(LoginUserTable).set(
                 column.birhtdate -> birhtdateInput
               )
              .where.eq(column.userid, useridInput)
             }.update.apply()
           }
         case None =>
           // 何もしない
       }
       
       true
    }
  }
  
    // ユーザの追加
  def insertUser(useridInput:String , userpwInput:String , usernameInput:String, usercategoryInput:Option[Int] , genderInput:String
                ,emailInput:String , lineidInput:String , telephoneInput:String, birhtdateInput:Option[Date]):Boolean= {
    var usercategoryForInsert = COMMON_USER
    // 日付の初期設定
    var birhtdateForInsert = AffectionDateUtil.getInitDate()
    
    // ユーザ区分の設定
    usercategoryInput match {
      case Some(usercategory) =>
        usercategoryForInsert = usercategory
       case None =>
         // 何もしない
    }

    // 誕生日の設定
    birhtdateInput match {
      case Some(birhtdateInput) =>
        birhtdateForInsert = birhtdateInput
       case None =>
         // 何もしない
    }
    // insert
    DB.localTx { implicit s =>
         val column = LoginUserTable.column
         withSQL {
            insert.into(LoginUserTable)
           .columns(column.userid, column.userpw, column.username, column.usercategory,
                    column.lastlogin, column.gender, column.email, column.lineid,
                    column.telephone, column.birhtdate
                    )
           .values(useridInput, userpwInput, usernameInput, usercategoryForInsert,
                   AffectionDateUtil.getInitZonedDateTime() , genderInput, emailInput, lineidInput, 
                   telephoneInput , birhtdateForInsert
                  )
         }.update.apply()
    }
    
    // 登録チェック
    if(getUserIdObject(useridInput) != null){
      true
    }else{
      false
    }
   
  }
  
}

