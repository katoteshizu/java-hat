package threadtest;

/**
 * Authored by Administrator on 14.02.2016 22:02.
 */
public class Data{
    private byte[] buffer;
    private boolean full = false;
    private int eof;

    public synchronized int isEof() {
        return eof;
    }

    public synchronized void setEof(int eof) {
        this.eof = eof;
    }

    public synchronized void full(){
        full = true; // ready to write
        notifyAll();
    }

    public synchronized void empty(){
        full = false; // ready to read
        notifyAll();
    }

    public synchronized void waitForWriting() throws InterruptedException {
        while (full)
            wait();
    }

    public synchronized void waitForReading() throws InterruptedException{
        while (!full)
            wait();
    }

    public synchronized byte[] getBuffer() {
        return buffer;
    }

    public synchronized void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public Data(byte[] buffer) {
        this.buffer = buffer;
    }
}