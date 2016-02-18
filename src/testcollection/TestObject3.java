package testcollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12.01.2016.
 */
public class TestObject3 {
    private String name;

    TestObject3() {

    }

    TestObject3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestObject3 testObj1 = new TestObject3("lol");
        TestObject3 testObj2 = new TestObject3("lol");

        ArrayList<TestObject3> arrListObj1 = new ArrayList<TestObject3>();
        arrListObj1.add(testObj1);

        System.out.println(arrListObj1.contains(testObj1));
        System.out.println(arrListObj1.contains(testObj2));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());

        System.out.println(testObj1.equals(testObj2));


    }
}
