package singleton.registory;

import java.util.HashMap;
import org.apache.log4j.Logger;
public class RegistryBasedSingleton {
   public static RegistryBasedSingleton REGISTRY = new RegistryBasedSingleton();
   private static HashMap map = new HashMap();
   private static Logger logger = Logger.getRootLogger();
   protected RegistryBasedSingleton() {
      // Exists to defeat instantiation
   }
   public static synchronized Object getInstance(String classname) {
      Object singleton = map.get(classname);
      if(singleton != null) {
         return singleton;
      }
      try {
         singleton = Class.forName(classname).newInstance();
         logger.info("created singleton: " + singleton);
      }
      catch(ClassNotFoundException cnf) {
         logger.fatal("Couldn't find class " + classname);    
      }
      catch(InstantiationException ie) {
         logger.fatal("Couldn't instantiate an object of type " + 
                       classname);    
      }
      catch(IllegalAccessException ia) {
         logger.fatal("Couldn't access class " + classname);    
      }
      map.put(classname, singleton);
      return singleton;
   }
}