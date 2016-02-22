package threadexit;

import java.io.*;

/**
 * Authored by Administrator on 14.02.2016 22:04.
 */
class WriteTread implements Runnable {
    private Data data;
    private File dest;
    private StatusObject statusObject;

    public WriteTread(File dest, Data data, StatusObject statusObject) {
        this.data = data;
        this.dest = dest;
        this.statusObject = statusObject;
        statusObject.push();
    }

    OutputStream osStream = null;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Starting " + name);
//        boolean wasWrite = false;
        try {
            osStream = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buffer;
            System.out.println(name + " EOS: " + data.isEof());
            while (data.isEof() > 0) {
//                wasWrite = true;
                data.waitForReading();
                if (data.isEof() > 0) {
                    buffer = data.getBuffer();
                    osStream.write(buffer, 0, data.isEof());
//                    System.out.println(name + " write a portion");
                    data.empty();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
            statusObject.pop();

        }
        System.out.println("Ending " + name);
    }

    private void close() {
        try {
            osStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
