package models

import java.util.Date

case class LoginUser(
    userid:String, 
    userpw:String); 
    
case class Category(
    categoryid:String,
    categoryname:String, 
    categorysort:String); 
    
case class UserForRegist(
    registCategory:Int,
    userid:String, 
    userpw:String,
    username:String,
    usercategory:Option[Int],
    gender:String,
    email:String,
    lineid:String,
    telephone:String,
    birhtdate:Option[Date]
    ); 