package threadexit;

import java.io.*;

/**
 * Authored by Administrator on 14.02.2016 22:21.
 */
public class ReadThread implements Runnable {
    private File source;
    private Data data;
    private StatusObject statusObject;

    InputStream inStream = null;

    public ReadThread(File source, Data data, StatusObject statusObject) {
        this.source = source;
        this.data = data;
        this.statusObject = statusObject;
        statusObject.push();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        System.out.println("read file: " + source);
        try {
            inStream = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = data.getBuffer();
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                data.setBuffer(buffer);
                data.setEof(length);
                data.full();
//                System.out.println(name + " read a portion");
                data.waitForWriting();
            }
            data.setEof(-1);
            data.full();
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
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}