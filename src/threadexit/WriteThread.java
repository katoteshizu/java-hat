package threadexit;

import java.io.*;

/**
 * Authored by Administrator on 14.02.2016 22:04.
 */
class WriteTread implements Runnable {
    private Data data;
    private File dest;

    public WriteTread(File dest, Data data) {
        this.data = data;
        this.dest = dest;
    }

    OutputStream osStream = null;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            osStream = new FileOutputStream(dest);
            byte[] buffer;
            while (data.isEof() > 0) {
                data.waitForReading();
                if (data.isEof() > 0) {
                    buffer = data.getBuffer();
                    osStream.write(buffer, 0, data.isEof());
                    System.out.println(name + "write");
                    data.empty();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        System.out.println("Ending write" + name);
    }

    private void close() {
        try {
            osStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
