package threadexit;

/**
 * Created by Work on 2/19/2016.
 */
public class ExitThread implements Runnable {
    @Override
    public void run() {
        System.out.println("We will exit now.");
        System.exit(0);
    }
}
