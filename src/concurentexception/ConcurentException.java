package concurentexception;

import java.util.ArrayList;

/**
 * Created by Administrator on 14.01.2016.
 */
public class ConcurentException {
    public static void main(String[] args){
        ArrayList<String> arrList = new ArrayList<String>();

        arrList.add("1111");
        arrList.add("2222");
        arrList.add("3333");

        for (String s : arrList) {
            arrList.remove("3333");
        }
    }
}
