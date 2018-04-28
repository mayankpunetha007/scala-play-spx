package framework.route

import play.libs._
import play.mvc.Controller

object RouteGenerator {

  def  RouteGenerator(app:App) ={
      ClassPath.getTypes(app, "controllers")
  }

}
