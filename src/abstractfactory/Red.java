package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
