package singleton.serializable;

import java.io.*;
import org.apache.log4j.Logger;
import junit.framework.Assert;
import junit.framework.TestCase;
public class SerializableSingletonTest extends TestCase {
   private SerializableSingleton sone = null, stwo = null;
   private static Logger logger = Logger.getRootLogger();
   public SerializableSingletonTest(String name) {
      super(name);
   }
   public void setUp() {
      sone = SerializableSingleton.INSTANCE;
      stwo = SerializableSingleton.INSTANCE;
   }
   public void testSerialize() {
      logger.info("testing singleton serialization...");
      writeSingleton();
      SerializableSingleton s1 = readSingleton();
      SerializableSingleton s2 = readSingleton();
      Assert.assertEquals(true, s1 == s2);
   }
   private void writeSingleton() {
      try {
         FileOutputStream fos = new FileOutputStream("serializedSingleton");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         SerializableSingleton s = SerializableSingleton.INSTANCE;
         oos.writeObject(SerializableSingleton.INSTANCE);
         oos.flush();
      }
      catch(NotSerializableException se) {
         logger.fatal("Not Serializable Exception: " + se.getMessage());
      }
      catch(IOException iox) {
         logger.fatal("IO Exception: " + iox.getMessage());
      }
   }
   private SerializableSingleton readSingleton() {
      SerializableSingleton s = null;
      try {
         FileInputStream fis = new FileInputStream("serializedSingleton");
         ObjectInputStream ois = new ObjectInputStream(fis);
         s = (SerializableSingleton)ois.readObject();
      }
      catch(ClassNotFoundException cnf) {
         logger.fatal("Class Not Found Exception: " + cnf.getMessage());
      }
      catch(NotSerializableException se) {
         logger.fatal("Not Serializable Exception: " + se.getMessage());
      }
      catch(IOException iox) {
         logger.fatal("IO Exception: " + iox.getMessage());
      }
      return s;
   }
   public void testUnique() {
      logger.info("testing singleton uniqueness...");
      SerializableSingleton another = new SerializableSingleton();
      logger.info("checking singletons for equality");
      Assert.assertEquals(true, sone == stwo);
   }
}