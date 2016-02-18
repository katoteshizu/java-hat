package testcollection;

import java.util.HashMap;

/**
 * Created by Administrator on 12.01.2016.
 */
public class TestObject5 {
    private String name;
    private String surname;

    TestObject5() {

    }

    TestObject5(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestObject5 testObj1 = new TestObject5("John", "Doe");
        TestObject5 testObj2 = new TestObject5("John", "Doe");

        HashMap<TestObject5, String> hashMapObj1 = new HashMap<TestObject5, String>();
        hashMapObj1.put(testObj1, testObj1.getSurname());

        System.out.println(hashMapObj1.containsKey(testObj1));
        System.out.println(hashMapObj1.containsKey(testObj2));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());

        System.out.println(testObj1.equals(testObj2));


    }


}
