package useCase

import model.api.hiyariHatto.HiyariHattoCategoryCreateRequest
import model.domain.{AuthUser, HiyariHattoCategory}

object HiyariHattoUseCase {

  def createHiyariHattoCategory(request: HiyariHattoCategoryCreateRequest, user: AuthUser): Option[String] = {
    HiyariHattoCategory.createCategory(request.name, user.id).collect(category =>
      category.id
    )
  }

  def updateHiyariHattoCategory(id: String, name: String, userId: String): Option[HiyariHattoCategory] = {
    HiyariHattoCategory.updateCategory(id, name, userId)
  }

  def deleteHiyariHattoCategory(id: String, userId: String): Boolean = {
    HiyariHattoCategory.deleteCategory(id, userId)
  }

  def listHiyariHattoCategory(userId: String): Seq[HiyariHattoCategory] = {
    HiyariHattoCategory.getCategoryList(userId)
  }
}
