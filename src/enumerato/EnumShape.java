package enumerato;

/**
 * Created by Administrator on 05.01.2016.
 */
public enum EnumShape {
    RECTANGLE, TRIANGLE, CIRCLE;
    public double square(double x, double y){
        switch (this)
        {
            case RECTANGLE:
                return x * y;
            case TRIANGLE:
                return x * y / 2;
            case CIRCLE:
                return Math.pow(x, 2) * Math.PI;
        }
        throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
    }
}
