package comparato;

import java.util.*;

/**
 * Created by Administrator on 13.01.2016.
 */
public class RunComparato {
    public static void main(String[] args) {
        testNonComparable();
    }

    static void testNonComparable() {

        NotComparato obj1 = new NotComparato();
        NotComparato obj2 = new NotComparato();

        obj1.setName("1");
        obj2.setName("2");

        ArrayList<NotComparato> arrList1 = new ArrayList<NotComparato>();
        TreeSet<NotComparato> trSet = new TreeSet<NotComparato>(new Comparator<NotComparato>() {
            @Override
            public int compare(NotComparato o1, NotComparato o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        arrList1.add(obj2);
        arrList1.add(obj1);

        trSet.add(obj2);
        trSet.add(obj1);

        Collections.sort(arrList1, new Comparator<NotComparato>() {
            @Override
            public int compare(NotComparato o1, NotComparato o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("TreeSet:");

        for (Iterator iterator = trSet.iterator(); iterator.hasNext(); ) {
            NotComparato next = (NotComparato) iterator.next();
            System.out.println("Element: " + next.getName());
        }
        System.out.println("\nArrayList:");

        for (Iterator iterator = arrList1.iterator(); iterator.hasNext(); ) {
            NotComparato next = (NotComparato) iterator.next();
            System.out.println("Element: " + next.getName());

        }
    }



    static void testComparable() {
        Comparato obj1 = new Comparato();
        Comparato obj2 = new Comparato();

        obj1.setName("1");
        obj2.setName("2");

        ArrayList<Comparato> arrList1 = new ArrayList<Comparato>();
        TreeSet<Comparato> trSet = new TreeSet<Comparato>();

        arrList1.add(obj2);
        arrList1.add(obj1);

        trSet.add(obj2);
        trSet.add(obj1);

        Collections.sort(arrList1);

        System.out.println("TreeSet:");

        for (Iterator iterator = trSet.iterator(); iterator.hasNext(); ) {
            Comparato next = (Comparato) iterator.next();
            System.out.println("Element: " + next.getName());
        }
        System.out.println("\nArrayList:");

        for (Iterator iterator = arrList1.iterator(); iterator.hasNext(); ) {
            Comparato next = (Comparato) iterator.next();
            System.out.println("Element: " + next.getName());

        }
    }
}

