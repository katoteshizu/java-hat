package threadslocks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Authored by Administrator on 14.02.2016 22:04.
 */
class WriteTreadLock implements Runnable {
    private DataBuffer dataBuffer;
    private File dest;

    public WriteTreadLock(File dest, DataBuffer dataBuffer) {
        this.dataBuffer = dataBuffer;
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
            while (dataBuffer.isEof() > 0) {
                dataBuffer.waitForReading();
                if (dataBuffer.isEof() > 0) {
                    buffer = dataBuffer.getBuffer();
                    osStream.write(buffer, 0, dataBuffer.isEof());
                    System.out.println("write");
                    dataBuffer.empty();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        System.out.println("Ending write");
    }

    private void close() {
        try {
            osStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
