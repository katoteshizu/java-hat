package testreplace;

/**
 * Created by Administrator on 25.01.2016.
 */
public class TestReplace {

    public static void main(String[] args) throws Exception{

        System.out.println(new SystemNameConverter("\\\\Ololo\\lfoo\\lbar\\lbaz\\demo.txt").call());
    }
}
