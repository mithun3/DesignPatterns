package singleton.reflection;

import java.util.HashMap;
import org.apache.log4j.Logger;
public class ReflectiveSinglton {
   private static HashMap map = new HashMap();
   private static Logger logger = Logger.getRootLogger();
   private ReflectiveSinglton() {
      // Exists only to thwart instantiation
   }
   public static synchronized ReflectiveSinglton getInstance(String classname) {
	   ReflectiveSinglton singleton = (ReflectiveSinglton)map.get(classname);
      if(singleton != null) {
         logger.info("got singleton from map: " + singleton);
         return singleton;
      }
      try {
         singleton = (ReflectiveSinglton)Class.forName(classname).newInstance();
      }
      catch(ClassNotFoundException cnf) {
         logger.fatal("Couldn't find class " + classname);    
      }
      catch(InstantiationException ie) {
         logger.fatal("Couldn't instantiate an object of type " + classname);    
      }
      catch(IllegalAccessException ia) {
         logger.fatal("Couldn't access class " + classname);    
      }
      map.put(classname, singleton);
      logger.info("created singleton: " + singleton);
      return singleton;
   }
}