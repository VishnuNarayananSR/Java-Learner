
@FunctionalInterface
interface StringReverse{
    String rev(String s);
}

public class functionalInterface {
    public static void main(String[] args){

        StringReverse obj = (str) -> {
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        };

        System.out.println(obj.rev("Hai"));
        
    }

    
}
