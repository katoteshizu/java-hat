package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {

        if(color == null){
            return null;
        }

        String colorSwitch = color.toUpperCase();

        switch (colorSwitch){
            case "RED" : return new Red();
            case "GREEN" : return new Green();
            case "BLUE" : return new Blue();
            default: return null;
        }
    }

    @Override
    Shape getShape(String shapeType) {
        return null;
    }
}
