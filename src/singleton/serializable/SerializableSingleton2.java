package singleton.serializable;
import java.io.Serializable;

public class SerializableSingleton2 implements Serializable{
 
    private static final long serialVersionUID = -7604766932017737115L;
 
    private SerializableSingleton2(){}
     
    private static class SingletonHelper{
        private static final SerializableSingleton2 instance = new SerializableSingleton2();
    }
     
    public static SerializableSingleton2 getInstance(){
        return SingletonHelper.instance;
    }
     
}