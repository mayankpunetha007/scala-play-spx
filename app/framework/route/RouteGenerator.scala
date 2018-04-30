package framework.route


import java.lang.annotation.Annotation

import framework.annotation.Mapping

import scala.language.postfixOps
import org.reflections.Reflections
import play.api.mvc.AbstractController

import scala.collection.JavaConverters._



object RouteGenerator  {

  def init() = {
    val  reflection = new Reflections("")
    for(clazz <- reflection.getSubTypesOf(classOf[AbstractController]).asScala){
      for (method <- clazz.getDeclaredMethods){
        val ann  = method.getAnnotations().filter(_.getClass() == classOf[Mapping] )
        if(ann.length >0 ){
          val mapping = ann(0)
          Console print mapping.asInstanceOf[Mapping].method
          Console print mapping.asInstanceOf[Mapping].resp
          Console print mapping.asInstanceOf[Mapping].req
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val x = RouteGenerator
    x.init()
  }

}
