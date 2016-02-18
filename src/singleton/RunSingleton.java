package singleton;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 30.12.2015.
 */
public class RunSingleton implements Callable<Void> {

    @Override
    public Void call() throws Exception {

        System.out.println("Getting singleton...");
        Singleton singleOne = Singleton.getInstance();
        System.out.println("...got singleton: " + singleOne);

        System.out.println("Getting singleton...");
        Singleton singleTwo = Singleton.getInstance();
        System.out.println("...got singleton: " + singleTwo);

        singleOne.sayMoo();
        singleTwo.sayMoo();

        return null;
    }
}
