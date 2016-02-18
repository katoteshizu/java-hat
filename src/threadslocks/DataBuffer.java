package threadslocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Authored by Administrator on 14.02.2016 22:02.
 */
public class DataBuffer {
    private byte[] buffer;
    private boolean full = false;
    private int eof;

    private final Lock lock = new ReentrantLock();

    public int isEof() {
        return eof;
    }

    public void setEof(int eof) {
        lock.lock();
        try {
            this.eof = eof;
            full = true;
        } finally {
            lock.unlock();
        }

    }

    public void full() {
        full = true; // ready to write
        notifyAll();
    }

    public void empty() {
        full = false; // ready to read
        notifyAll();
    }

    public void waitForWriting() throws InterruptedException {
        while (full)
            wait();
    }

    public void waitForReading() throws InterruptedException {
        while (!full)
            wait();
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        lock.lock();
        try {
            this.buffer = buffer;
            full = true;
            System.out.println("Setting buffer by thread"+Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public DataBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}