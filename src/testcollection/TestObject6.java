package testcollection;

import java.util.HashMap;

/**
 * Created by Administrator on 12.01.2016.
 */
public class TestObject6 {
    private String name;
    private String surname;

    TestObject6() {

    }

    TestObject6(String name, String surname) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject6 that = (TestObject6) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return surname != null ? surname.equals(that.surname) : that.surname == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        TestObject6 testObj1 = new TestObject6("John", "Doe");
        TestObject6 testObj2 = new TestObject6("John", "Doe");
        TestObject6 testObj3 = new TestObject6("Dick", "Dr.");

        HashMap<TestObject6, String> hashMapObj1 = new HashMap<TestObject6, String>();
        hashMapObj1.put(testObj1, testObj1.getSurname());

        System.out.println(hashMapObj1.containsKey(testObj1));
        System.out.println(hashMapObj1.containsKey(testObj2));
        System.out.println(hashMapObj1.containsKey(testObj3));

        System.out.println(testObj1.hashCode());
        System.out.println(testObj2.hashCode());
        System.out.println(testObj3.hashCode());

        System.out.println(testObj1.equals(testObj2));


    }


}