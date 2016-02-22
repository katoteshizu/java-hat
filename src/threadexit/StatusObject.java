package threadexit;

/**
 * Authored by Administrator on 21.02.2016 21:30.
 */
public class StatusObject {
    private int count = 0;
    private boolean ready = false;

    public synchronized boolean isReady() {
        return ready;
    }

    public synchronized void push() {
        count++;
        System.out.println("pushed: " + count);
        if (count > 0) {
            ready = false;
            notifyAll();
        }
    }

    public synchronized void pop() {
        count--;
        System.out.println("poped: " + count);
        if (count == 0) {
            ready = true;
            notifyAll();
        }
    }

    public synchronized void waitForExit() throws InterruptedException {
        while (ready) {
            wait();
        }
    }

}
