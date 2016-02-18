package testcollection;

import java.util.ArrayList;

/**
 * Created by Administrator on 12.01.2016.
 */
public class TestObject4 {
    private String name;

    TestObject4() {

    }

    TestObject4(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject4 that = (TestObject4) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static void main(String[] args) {
        TestObject4 testObj1 = new TestObject4("lol");
        TestObject4 testObj2 = new TestObject4("lol");
        TestObject4 testObj3 = new TestObject4("222");

        ArrayList<TestObject4> arrListObj1 = new ArrayList<TestObject4>();
        arrListObj1.add(testObj1);

        System.out.println(arrListObj1.contains(testObj1));
        System.out.println(arrListObj1.contains(testObj2));
        System.out.println(arrListObj1.contains(testObj3));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());
        System.out.println(testObj3.hashCode());

        System.out.println(testObj1.equals(testObj3));


    }
}