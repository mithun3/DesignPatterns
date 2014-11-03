package singleton.serializable;

import org.apache.log4j.Logger;
public class SerializableSingleton implements java.io.Serializable {
   public static SerializableSingleton INSTANCE = new SerializableSingleton();
   protected SerializableSingleton() {
      // Exists only to thwart instantiation.
   }
      private Object readResolve() {
            return INSTANCE;
      }
}