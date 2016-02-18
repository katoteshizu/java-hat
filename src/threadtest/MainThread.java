package threadtest;

/**
 * Authored by Administrator on 11.02.2016 10:13.
 */
public class MainThread {
    public static void main(String[] args) throws Exception {

        System.out.println("Start main");
        MainThread mainThread = new MainThread();
        Task target = mainThread.startThread();
        Thread.sleep(5);
        target.setStopFlag(true);
        System.out.println("End main");

    }

    public Task startThread() {

        Task target = new Task();
        Thread nThread = new Thread(target);
//        nThread.setDaemon(true);
        nThread.start();
        return target;
    }

    class Task implements Runnable {

        boolean stopFlag = false;

        public synchronized boolean isStopFlag() {
            return stopFlag;
        }

        public synchronized void setStopFlag(boolean stopFlag) {
            this.stopFlag = stopFlag;
        }


        public void run() {
            try {
                for (int i = 100; i > 0 && !stopFlag; i--) {
                    System.out.println("thread " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread stopped");
        }


    }
}