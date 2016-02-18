package enumerato;

import java.awt.*;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 05.01.2016.
 */
public class EnumerateRunner implements Callable<Void> {
    @Override
    public Void call() throws Exception {
        Enumerato current;
        current = Enumerato.FPMI;

        switch (current) {
            case GEO:
                System.out.println(current);
                break;
            case MMF:
                System.out.println(current);
                break;
            default:
                System.out.println("Outside case: " + current);
        }

        double x = 2, y = 3;
        EnumShape[] arr = EnumShape.values();
        for (EnumShape sh : arr)
            System.out.printf("%10s = %5.2f%n", sh, sh.square(x, y));

        EnumDean edn = EnumDean.valueOf("FPMI");
        System.out.print(edn.ordinal());
        System.out.println(" : " + edn + " : " + edn.getName());

        return null;
    }


}
