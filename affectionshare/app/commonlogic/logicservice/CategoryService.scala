package commonlogic.logicservice

import scalikejdbc._
import java.time.ZonedDateTime
import java.util.Date
import commonlogic.logicservice.tablemodel.CategoryTable
import scala.util.Try

object CategoryService {
  
  // カテゴリーの一覧を返す
  def getCategoryList():List[CategoryTable] = {
    val c = CategoryTable.syntax("c")
    var categoryList:List[CategoryTable] = null
    DB.readOnly { implicit session =>
      categoryList = withSQL {
             select
               .from(CategoryTable as c)
               .orderBy(c.categorysort).asc
           }.map(CategoryTable(c.resultName)).list.apply()
    }
    categoryList;
  }
  
  // 指定された名前でCategoryTableを返す。
  def getCategoryByName(inputCategoryName:String):CategoryTable = {
    // 空白チェック
    if(inputCategoryName.isEmpty()){
      null
    // 存在しているか
    }else{
      val c = CategoryTable.syntax("c")
      var categoryGet:Option[CategoryTable] = null
      DB.readOnly { implicit session =>
        categoryGet = withSQL {
             select
               .from(CategoryTable as c)
               .where.eq(c.categoryname, inputCategoryName)
           }.map(CategoryTable(c.resultName)).single.apply()
      }
      if(categoryGet == None){
        null
      }else{
        categoryGet.get
      }
    }
  }
  
  // 指定されたIDでCategoryTableを返す。
  def getCategoryById(inputCategoryId:String):CategoryTable = {
    // 空白チェック
    if(inputCategoryId.isEmpty()){
      null
    // 存在しているか
    }else{
      val c = CategoryTable.syntax("c")
      var categoryGet:Option[CategoryTable] = null
      // IDを型変換
      var categryidForEq = Try{inputCategoryId.toLong}.toOption
      DB.readOnly { implicit session =>
        categoryGet = withSQL {
             select
               .from(CategoryTable as c)
               .where.eq(c.categoryid, categryidForEq)
           }.map(CategoryTable(c.resultName)).single.apply()
      }
      if(categoryGet == None){
        null
      }else{
        categoryGet.get
      }
    }
  }
  
  // 指定されたソートでCategoryTableを返す。
  def getCategoryBySort(inputCategorySort:String):CategoryTable = {
    // 空白チェック
    if(inputCategorySort.isEmpty()){
      null
    // 存在しているか
    }else{
      val c = CategoryTable.syntax("c")
      var categoryGet:Option[CategoryTable] = null
      DB.readOnly { implicit session =>
        categoryGet = withSQL {
             select
               .from(CategoryTable as c)
               .where.eq(c.categorysort, inputCategorySort)
           }.map(CategoryTable(c.resultName)).single.apply()
      }
      if(categoryGet == None){
        null
      }else{
        categoryGet.get
      }
    }
  }
  
  // カテゴリーを新規追加してTable返却
  def insertCategory(inputCategoryName:String , inputCategorySort:String):CategoryTable = {
    // 空白チェック
    if(inputCategoryName.isEmpty() || inputCategorySort.isEmpty()){
       null
    }else{
       DB.localTx { implicit s =>
         val column = CategoryTable.column
         withSQL {
            insert.into(CategoryTable)
           .columns(column.categoryname, column.lastupdate, column.categorysort)
           .values(inputCategoryName, ZonedDateTime.now, inputCategorySort)
         }.update.apply()
       }
       // 名前をキーにカテゴリーテーブルを返す
       getCategoryByName(inputCategoryName)
    }
  
  }
  
  // 指定されたIDでカテゴリーを更新
  def updateCategory(inputCategoryId:String , inputCategoryName:String , inputCategorySort:String):CategoryTable = {
    // 空白チェック
    if(inputCategoryName.isEmpty() || inputCategorySort.isEmpty()){
       null
    }else{
       // IDを型変換
       var categryidForEq = Try{inputCategoryId.toLong}.toOption
       DB.localTx { implicit s =>
         val column = CategoryTable.column
         withSQL {
            update(CategoryTable).set(
              column.categoryname -> inputCategoryName ,
              column.lastupdate -> ZonedDateTime.now ,
              column.categorysort -> inputCategorySort
            )
           .where.eq(column.categoryid, categryidForEq)
         }.update.apply()
       }
       // IDをキーにカテゴリーテーブルを返す
       getCategoryById(inputCategoryId)
    }
  
  }
  
  // 指定されたIDでカテゴリーを削除
  def deleteCategory(inputCategoryId:String):Boolean = {
    // 空白チェック
    if(inputCategoryId.isEmpty()){
       false
    }else{
       // IDを型変換
       var categryidForEq = Try{inputCategoryId.toLong}.toOption
       DB.localTx { implicit s =>
         val column = CategoryTable.column
         withSQL {
            delete.from(CategoryTable)
              .where.eq(column.categoryid, categryidForEq)
         }.update.apply()
       }
       true
    }
  
  }
}

