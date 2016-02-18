package abstractfactory;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 30.12.2015.
 */
public class RunAbstractFactory implements Callable<Void> {

    @Override
    public Void call() throws Exception {

        //get a AbstractFactory object
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //pass information to AbstractFactory to get the type of object it needs
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");

        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color color1 = colorFactory.getColor("RED");

        color1.fill();

        Color color2 = colorFactory.getColor("Green");

        color2.fill();

        Color color3 = colorFactory.getColor("BLUE");

        color3.fill();

        return null;
    }
}
