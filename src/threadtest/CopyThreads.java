package threadtest;

import java.io.*;

/**
 * Authored by Administrator on 14.02.2016 21:03.
 */
public class CopyThreads {

    public static void main(String[] args) {
        Data data = new Data(new byte[1024]);
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);


        ReadThread readThread = new ReadThread(inFile, data);
        new Thread(readThread, "reader").start();

        WriteTread writeTread = new WriteTread(outFile, data);
        new Thread(writeTread, "writer").start();
    }
}