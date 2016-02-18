package copyonwritelist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 13.01.2016.
 */
public class CopyOnWriteDemo {

    public static void main(String args[]) {

        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();

        threadSafeList.add("Java");
        threadSafeList.add("J2EE");
        threadSafeList.add("Collection");

        Iterator<String> failSafeIterator = threadSafeList.iterator();

        while (failSafeIterator.hasNext()) {
            System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
//            failSafeIterator.remove();
        }
    }
}
