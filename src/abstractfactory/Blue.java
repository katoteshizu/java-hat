package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
