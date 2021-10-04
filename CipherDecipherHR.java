import java.util.regex.*;

class CipherDecipher{

    public String ciphering(String normal){
        int n = normal.length();
        StringBuilder sb = new StringBuilder(n);
        for (char ch : normal.toCharArray()) {
            if(Character.isLowerCase(ch)) sb.append(Character.toUpperCase(ch));
            else if(Character.isUpperCase(ch))sb.append(Character.toLowerCase(ch));
            else sb.append('*');
        }
        sb = sb.reverse();
        String result = "";
        for (int i = 0; i < n; i++) {
            if((i + 1) % 2 == 0) result+= (int)sb.charAt(i);
            else result+= sb.charAt(i);
        }
        return result + 3;
    }
    public String asciiStrToChar(String ascii){
        return Character.toString((char)Integer.parseInt(ascii));
    }
    public String deciphering(String ciphered){
        int n = ciphered.length() - 1;
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(ciphered.substring(0, n));
        String result = "";
        while(m.find()){
            result = m.replaceFirst(asciiStrToChar(m.group(0)));
            m = p.matcher(result);
        }
        StringBuilder sb =  new StringBuilder(result);
        sb.reverse();
        result = "";
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(Character.isLowerCase(ch)) result+= Character.toUpperCase(ch);
            else if(Character.isUpperCase(ch)) result+= Character.toLowerCase(ch);
            else if(ch == '*') result += " ";
            else result+= ch;
        }
        return result;
    }
}

public class CipherDecipherHR {
    
    public static void main(String[] args){
        String normal="Welcome to hackerrank";
        String ciphered="?85O89*69R65*87O104*33I1043";
        
        CipherDecipher cipherOrDecipher = new CipherDecipher();
        System.out.println(cipherOrDecipher.ciphering(normal));
        System.out.println(cipherOrDecipher.deciphering(ciphered));
    }
    
}
