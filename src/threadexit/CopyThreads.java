package threadexit;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Authored by Administrator on 14.02.2016 21:03.
 */
public class CopyThreads {

    private static final List<CopyTask> copyList;

    static {
        copyList = new LinkedList<>();
        copyList.add(new CopyTask("d:\\TEMP\\in0.txt", "d:\\TEMP\\out0.txt"));
        copyList.add(new CopyTask("d:\\TEMP\\in1.txt", "d:\\TEMP\\out1.txt"));
        copyList.add(new CopyTask("d:\\TEMP\\in2.txt", "d:\\TEMP\\out2.txt"));
        copyList.add(new CopyTask("d:\\TEMP\\in3.txt", "d:\\TEMP\\out3.txt"));
        copyList.add(new CopyTask("d:\\TEMP\\in4.txt", "d:\\TEMP\\out4.txt"));
        copyList.add(new CopyTask("d:\\TEMP\\in5.txt", "d:\\TEMP\\out5.txt"));

    }

    public static void main(String[] args) {

        int i = 0;
        StatusObject statusObject = new StatusObject();

        for (CopyTask copyTask : copyList) {

            Data data = new Data(new byte[1024]);
            File inFile = new File(copyTask.inputFile);
            File outFile = new File(copyTask.outputFile);

            ReadThread readThread = new ReadThread(inFile, data, statusObject);
            new Thread(readThread, "reader " + i).start();

            WriteTread writeTread = new WriteTread(outFile, data, statusObject);
            new Thread(writeTread, "writer " + i).start();
            i++;
        }

        ExitThread exitThread = new ExitThread(statusObject);
        new Thread(exitThread, "Exit thread").start();
    }
}