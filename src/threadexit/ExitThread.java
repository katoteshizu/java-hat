package threadexit;

/**
 * Created by Work on 2/19/2016.
 */
public class ExitThread implements Runnable {
private StatusObject statusObject;
    public ExitThread(StatusObject statusObject) {
        this.statusObject = statusObject;
    }

    @Override
    public void run() {
        while (!statusObject.isReady()){
            try {
                statusObject.waitForExit();
                System.out.println("Waiting for exit...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("We will exit now.");
        System.exit(666);
    }
}
