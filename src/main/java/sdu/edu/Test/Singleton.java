package sdu.edu.Test;
import java.io.*;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class  Singleton implements Serializable {


    private Singleton(){}
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }

    public Object readResolve(){
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        File file = new File("tempFile");
        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(file));
        obs.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton s2 = (Singleton) ois.readObject();
        System.out.println(s1 == s2);
    }

}