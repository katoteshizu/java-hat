package by.vector;

import java.util.Vector;

/**
 * Created by Administrator on 12.01.2016.
 */

public class VectorDemo {
    public static void main(String[] args) {

        Vector<Integer> vec = new Vector<Integer>(4);


        vec.add(4);
        vec.add(3);
        vec.add(2);
        vec.add(1);

        vec.add(2, 10);

        vec.addElement(42);
        vec.addElement(66);
        vec.addElement(13);

        vec.insertElementAt(133, 1);

        System.out.println("Added numbers are : ");
        for (Integer number : vec) {
            System.out.println("Index :"+vec.indexOf(number) +" Number: " + number);
        }

        System.out.println("Capacity of the vector is :"+vec.capacity());

        System.out.println("Checking the existence of number 2 : "+vec.contains(2));

        System.out.println("Element at 1st position : "+vec.elementAt(1));

        System.out.println("The vector is: "+vec);

        vec.clear();

        vec.removeAllElements();

        vec.trimToSize();

        System.out.println("Capacity of the vector after clear is :"+vec.capacity());
        System.out.println("Size of the vector after clear is :"+vec.size());

        System.out.println("The vector is empty: "+vec.isEmpty());

        System.out.println("The vector is: "+vec);


    }

}