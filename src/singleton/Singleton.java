package singleton;

/**
 * Created by Administrator on 30.12.2015.
 */
public class Singleton {

    private int singletonCounter;

    private static Singleton instance = null;

    public static Singleton getInstance() {

        if (instance == null) {

            instance = new Singleton();

            System.out.println("Creating Singleton");
        }

        return instance;
    }

    public void sayMoo() {
        singletonCounter++;
        System.out.println("Singleton says: " + singletonCounter + " 'Moo!'");
    }
}
