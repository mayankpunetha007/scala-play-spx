package controllers

import javax.inject.{Inject, Singleton}

import framework.annotation.Mapping
import framework.data.Method
import play.api.mvc._

@Singleton
class PostController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  @Mapping(classOf[NewPostRequest], classOf[NewPostResponse], Method.POST)
  def newPost = Action { request =>
    val json = request.body.asJson.get
    Ok(views.html.index("Your new application is ready."))
  }

}
