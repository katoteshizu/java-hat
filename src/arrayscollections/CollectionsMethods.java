package arrayscollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 13.01.2016.
 */
public class CollectionsMethods {
    public static void main(String[] args){

        arrayAsList();

        arrayBinSearch();

        arrayCopyOf();

        collDisjoint();

        collFrequency();

        collReverse();
    }

    private static void collReverse() {

        ArrayList arrlst = new ArrayList();

        arrlst.add("A");
        arrlst.add("B");
        arrlst.add("C");
        arrlst.add("D");
        arrlst.add("E");

        System.out.println("\nCollections.reverse\n");

        System.out.println("The initial list is :"+arrlst);

        Collections.reverse(arrlst);

        System.out.println("The Reverse List is :"+arrlst);
    }

    private static void collFrequency() {

        List arrlist = new ArrayList();

        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        arrlist.add("C");
        arrlist.add("C");

        int freq = Collections.frequency(arrlist, "C");

        System.out.println("\nCollections.frequency\n");

        System.out.println("Frequency of 'C' is: "+freq);
    }

    private static void collDisjoint() {

        List<String> lst1 = new ArrayList<String>(5);
        List<String> lst2 = new ArrayList<String>(10);

        lst1.add("Java");
        lst1.add("is");
        lst1.add("best");

        lst2.add("C++");
        lst2.add("is not");
        lst2.add("older");

        boolean isCommon = Collections.disjoint(lst1, lst2);

        System.out.println("\nCollections.disjoint\n");

        System.out.println("No commom elements: "+isCommon);
    }

    private static void arrayAsList(){

        String arrOfStrings[] = new String[]{"ccc", "aaa", "bbb", "zzz", "xxx", "ooo"};

        List listObj1 = Arrays.asList(arrOfStrings);

        System.out.println("\nArrays.asList\n");

        System.out.println(listObj1);

    }

    private static void arrayBinSearch(){
        byte byteArray[] = {4, 16,  8, 15, 42, 23 };

        Arrays.sort(byteArray);

        System.out.println("\nArrays.binarySearch\n");

        System.out.println("The sorted byte array is:");
        for (byte number : byteArray) {
            System.out.println("Number = " + number);
        }

        byte searchVal = 15;

        int retVal = Arrays.binarySearch(byteArray, searchVal);

        System.out.println("The index for 15 is: " + retVal);
    }

    private static void arrayCopyOf(){

        byte[] arr1 = new byte[] {5, 62, 15};

        System.out.println("\nArrays.copyOf\n");

        System.out.println("Printing 1st array:");

        for (int i = 0; i < arr1.length; i++)
        {
            System.out.println(arr1[i]);
        }

        byte[] arr2 = Arrays.copyOf(arr1, 5);

        System.out.println("Printing 2nd array:");

        for (int i = 0; i < arr2.length; i++)
        {
            System.out.println(arr2[i]);
        }

    }
}
