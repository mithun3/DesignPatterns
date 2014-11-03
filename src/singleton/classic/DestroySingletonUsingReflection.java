package singleton.classic;

import java.lang.reflect.Constructor;


public class DestroySingletonUsingReflection {
 
    public static void main(String[] args) {
    	ClassicSingleton instanceOne = ClassicSingleton.getInstance();
    	ClassicSingleton instanceTwo = null;
        try {
            Constructor[] constructors = ClassicSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (ClassicSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
 
}