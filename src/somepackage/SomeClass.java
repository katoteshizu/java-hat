package somepackage;

/**
 * Created by Administrator on 05.01.2016.
 */
public class SomeClass {
    public SomeClass(){
        System.out.println("This is constructor...");
        System.out.println(this);
    }
    public SomeClass(int i){
        System.out.println("This is second constructor...");
        System.out.println("Class " + i);
    }
}
