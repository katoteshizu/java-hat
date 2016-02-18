package abstractfactory;

/**
 * Created by Administrator on 30.12.2015.
 * Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }

        String shapeSwitch = shapeType.toUpperCase();

        switch (shapeSwitch){
            case "CIRCLE" : return new Circle();
            case "RECTANGLE" : return new Rectangle();
            case "SQUARE" : return new Square();
            default: return null;
        }
    }
}
