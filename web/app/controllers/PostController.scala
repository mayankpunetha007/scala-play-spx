package controllers

import javax.inject.{Inject, Singleton}
import framework.annotation.Mapping
import framework.data.Method
import play.api.mvc._

@Singleton
class PostController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  @Mapping(request = classOf[NewPostRequest], response = classOf[NewPostResponse], method = Method.POST, url = "/post ")
  def newPost = Action { request =>
    val json = request.body.asJson.get
    Ok("Hellp")
  }

  def getPosts() = play.mvc.Results.TODO

  def delete() = play.mvc.Results.TODO

  def location() = play.mvc.Results.TODO
}
