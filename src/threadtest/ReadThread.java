package threadtest;

import java.io.*;

/**
 * Authored by Administrator on 14.02.2016 22:21.
 */
public class ReadThread implements Runnable {
    private File source;
    private Data data;

    InputStream inStream = null;

    public ReadThread(File source, Data data) {
        this.source = source;
        this.data = data;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            inStream = new FileInputStream(source);

            byte[] buffer = data.getBuffer();
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                data.setBuffer(buffer);
                data.setEof(length);
                data.full();
                System.out.println("read");
                data.waitForWriting();
            }
            data.setEof(-1);
            data.full();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        System.out.println("Ending read");
    }

    private void close() {
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}