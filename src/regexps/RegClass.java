package regexps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 04.02.2016.
 */
public class RegClass {

    public static void main(String args[]){


        String regex = "[a-z]+\\-[a-z]+";
        String regex1 = "([a-z]+)\\-([a-z]+)";

        String regexp2 = "(\\w)(\\s+)([\\.,])";
        String regexp3 = "(?i)(<title.*?>)(.+?)(</title>)";

        findExp(regex, "aa-bb");
        findExp(regex, "DDaa-AbbGG");
        findExpGroup(regex1, "aa-bb");
        findExpGroup(regex1, "DDaa-AbbGG");

        removeWhiteSpaces(regexp2, "Ya , ba . Da-ba , do-oooo , boom");
        extractBodyBetweenTags(regexp3, "<title>Negative look ahead provides the possibility to exclude a pattern. With this you can say that a string should not be followed by another string.</title>");
    }

    private static void findExp(String regex, String input) {
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(input);

        boolean x = m.find();
        if (x) {
            int start = m.start();
            int end = m.end();
            String result = input.substring(start, end);
            System.out.println("Found: " + result);
        } else {
            System.out.println("Not found");
        }
    }

    private static void findExpGroup(String regex, String input) {
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(input);

        boolean x = m.find();
        if (x) {
            int start = m.start(1);
            int end = m.end(1);
            String result = input.substring(start, end);
            System.out.println("Found: " + result);
        } else {
            System.out.println("Not found");
        }
    }

    private static void removeWhiteSpaces(String pattern, String INPUT){
        System.out.println(INPUT.replaceAll(pattern, "$1$3"));
    }

    private static void extractBodyBetweenTags(String pattern, String INPUT){
        System.out.println(INPUT.replaceAll(pattern, "$2"));
    }
}
