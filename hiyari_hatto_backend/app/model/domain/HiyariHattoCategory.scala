package model.domain

import org.joda.time.DateTime
import repository.HiyariHattoCategoryRepository

object HiyariHattoCategory {

  def createCategory(name: String, userId: String): Option[HiyariHattoCategory] = {
    val categoryCollectionOpt = HiyariHattoCategoryRepository.insertCategory(name, userId)
    categoryCollectionOpt.collect(category => HiyariHattoCategory(
      id = category.id,
      name = category.name,
      registerUserId = category.registerUserId,
      registerDateTime = category.registerDate
    ))
  }

  def updateCategory(id: String, name: String, userId: String): Option[HiyariHattoCategory] = {
    val categoryCollectionOpt = HiyariHattoCategoryRepository.updateCategory(id, name, userId)
    categoryCollectionOpt.collect(category => HiyariHattoCategory(
      id = category.id,
      name = category.name,
      registerUserId = category.registerUserId,
      registerDateTime = category.registerDate
    ))
  }

  def deleteCategory(id: String, userId: String): Boolean = {
    HiyariHattoCategoryRepository.deleteCategory(id, userId)
  }

  def getCategoryList(userId: String): Seq[HiyariHattoCategory] = {
    HiyariHattoCategoryRepository.getCategoryList(userId).map(col => {
      HiyariHattoCategory(
        col.id, col.name, col.registerUserId, col.registerDate
      )
    })
  }
}

case class HiyariHattoCategory(id: String = "",
                               name: String = "",
                               registerUserId: String = "",
                               registerDateTime: DateTime = DateTime.now())
