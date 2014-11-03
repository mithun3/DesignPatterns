package singleton.classic;

public class ClassicSingleton {
	   private static ClassicSingleton instance = null;
	   
	   /**
	    * ClassicSingleton implements a protected constructor so clients cannot instantiate ClassicSingleton instances.
	    */
	   private ClassicSingleton() {}
	   
	   
	   /**
	    * This singleton design pattern follows Lazy Instantiation.
	    * i.e singleton instance is not created until the getInstance() method is called for the first time. 
	    * @return instance
	    */
	   public static ClassicSingleton getInstance() {
	      if(instance == null) {
	         instance = new ClassicSingleton();
	      }
	      return instance;
	   }
	}