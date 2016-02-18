package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
