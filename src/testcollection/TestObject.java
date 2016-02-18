package testcollection;

import java.util.HashSet;

/**
 * Created by Administrator on 12.01.2016.
 */
public class TestObject {
    private String name;

    TestObject() {

    }

    TestObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestObject testObj1 = new TestObject("lol");
        TestObject testObj2 = new TestObject("lol");

        HashSet<TestObject> hashSetObj1 = new HashSet<TestObject>();
        hashSetObj1.add(testObj1);

        System.out.println(hashSetObj1.contains(testObj1));
        System.out.println(hashSetObj1.contains(testObj2));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());

        System.out.println(testObj1.equals(testObj2));


    }
}

