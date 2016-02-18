package threadslocks;

import java.io.File;

/**
 * Authored by Administrator on 14.02.2016 21:03.
 */
public class CopyThreadsLocks {

    public static void main(String[] args) {
        DataBuffer dataBuffer = new DataBuffer(new byte[1024]);
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);


        ReadThreadLock readThreadLock = new ReadThreadLock(inFile, dataBuffer);
        new Thread(readThreadLock, "reader").start();

        WriteTreadLock writeTreadLock = new WriteTreadLock(outFile, dataBuffer);
        new Thread(writeTreadLock, "writer").start();
    }
}