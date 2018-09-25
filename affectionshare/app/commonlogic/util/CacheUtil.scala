package commonlogic.util

import commonlogic.logicservice.tablemodel.LoginUserTable
import play.api.cache._
import scala.concurrent.duration._


object CacheUtil {
  
  // セッションのcacheにユーザをセット（キーがString）
  def setSessionUser(cache: SyncCacheApi , loginUserTable:LoginUserTable , sessionkey:String) = {
    //CacheにUserをセット（30分）
    cache.set(sessionkey, loginUserTable , 30.minutes)
  }
  
  // セッションのcacheにユーザをセット（キーがOption）
  def setSessionUser(cache: SyncCacheApi , loginUserTable:LoginUserTable , sessionkey:Option[String]) = {
    sessionkey match{
      case Some(key) =>
       //CacheにUserをセット（30分）
       cache.set(key, loginUserTable , 30.minutes)
      case None =>
        // 何もしない
    }
  }
  
  // セッションのcacheを削除
  def deleteSessionUser(cache: SyncCacheApi, sessionkey:Option[String])= {
    sessionkey match{
      case Some(key) =>
        //Cacheを削除
        cache.remove(key)
      case None =>
        // 何もしない
    }

  }
  
  // セッションのcacheを取得
  def getSessionUser( cache: SyncCacheApi , sessionkey:Option[String] ):Option[LoginUserTable]= {
    sessionkey match{
      case Some(key) =>
        // キャッシュからユーザオブジェクトを返す
        return cache.get[LoginUserTable](key)
      case None =>
        // Noneを返す
        return None
    }
    
  }
  
}

