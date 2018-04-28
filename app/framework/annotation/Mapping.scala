package framework.annotation

import java.lang.annotation.{ElementType, Retention, RetentionPolicy, Target}

import data.Data
import framework.data.Method

import scala.annotation.StaticAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target(Array{ElementType.METHOD})
case class Mapping(req: Class[_] , resp: Class[_], method: Method ) extends StaticAnnotation{

}
