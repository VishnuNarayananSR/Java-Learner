import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ipMatcher {
    public static void main(String[] args){
        String regex = "((0|1)?\\d{1,2}|2([0-4]\\d|5[0-5]))";
        regex += "\\." + regex + "\\." + regex + "\\." + regex;
        String ips = "168.192.18.1\n"
        + "13.13.13.112\n"
        + "VUUT.12.12\n"
        + "111.111.11.111\n"
        + "1.1.1.1.1.1.1\n"
        + ".....\n"
        + "1...1..1..1\n"
        + "0.0.0.0\n"
        + "255.0.255.0\n"
        + "266.266.266.266\n"
        + "00000.000000.0000000.00001\n"
        + "0023.0012.0012.0034\n";

        Pattern patternObject = Pattern.compile(regex); 
        Matcher matcherObject = patternObject.matcher(ips);

        for (String x : ips.split("\n")) {
            System.out.println(x+ " : " + x.matches(regex));
        }

        while(matcherObject.find()){
            System.out.println("Full match:" + matcherObject.group(0));
            // System.out.prinln();

            // for (int i = 0; i < matcherObject.groupCount(); i++) {
            //     System.out.println(matcherObject.group(i));
            // }
        }


    }
}
