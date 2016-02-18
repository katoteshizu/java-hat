package threadslocks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Authored by Administrator on 14.02.2016 22:21.
 */
public class ReadThreadLock implements Runnable {
    private File source;
    private DataBuffer dataBuffer;

    InputStream inStream = null;

    public ReadThreadLock(File source, DataBuffer dataBuffer) {
        this.source = source;
        this.dataBuffer = dataBuffer;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            inStream = new FileInputStream(source);

            byte[] buffer = dataBuffer.getBuffer();
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                dataBuffer.setBuffer(buffer);
                dataBuffer.setEof(length);
//                dataBuffer.full();
                System.out.println("read");
                dataBuffer.waitForWriting();
            }
            dataBuffer.setEof(-1);
//            dataBuffer.full();
        } catch (IOException | InterruptedException e) {
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