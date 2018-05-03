package framework.route;

import framework.annotation.Mapping;
import framework.data.Method;
import org.reflections.Reflections;
import play.api.mvc.AbstractController;

import java.util.Set;

public class RouteFileGenerator {

    public RouteFileGenerator(){
        Reflections reflections = new Reflections();
        Set<Class<? extends AbstractController>> allClasses = reflections.getSubTypesOf(AbstractController.class);
        for(Class<? extends AbstractController> controller : allClasses){
            for(java.lang.reflect.Method method :controller.getMethods()){
                if(method.isAnnotationPresent(Mapping.class)){
                    Mapping mapping = method.getAnnotation(Mapping.class);
                    Class<?> requestClass = mapping.request();
                    Class<?> responseClass = mapping.response();
                    Method requestMethod = mapping.method();
                    String url = mapping.url();
                    System.err.println(requestMethod.toString() + "\t"+url+"\t"+controller.getName()+"."+method.getName());

                }
            }
        }
    }

    public static void main(String[] args){
        new RouteFileGenerator();
    }
}
