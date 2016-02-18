package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 * Step 2
 * Create concrete classes implementing the same interface.
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
