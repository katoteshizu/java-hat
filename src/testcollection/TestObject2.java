package testcollection;

import java.util.HashSet;

public class TestObject2 {
    private String name;

    TestObject2() {

    }

    TestObject2(String name) {
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

        TestObject2 that = (TestObject2) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static void main(String[] args) {
        TestObject2 testObj1 = new TestObject2("lol");
        TestObject2 testObj2 = new TestObject2("lol");
        TestObject2 testObj3 = new TestObject2("222");

        HashSet<TestObject2> hashSetObj1 = new HashSet<TestObject2>();
        hashSetObj1.add(testObj1);

        System.out.println(hashSetObj1.contains(testObj1));
        System.out.println(hashSetObj1.contains(testObj2));
        System.out.println(hashSetObj1.contains(testObj3));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());
        System.out.println(testObj3.hashCode());

        System.out.println(testObj1.equals(testObj3));


    }
}
