import java.io.*;
import java.util.*;

public class firstUniqChar{

    public static int solution(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char i:s.toCharArray()){
            int count = map.containsKey(i) ? map.get(i):0;
            map.put(i, count + 1);
        }
        for(char i:s.toCharArray()){
            if (map.get(i) == 1){
                System.out.println("found");
                return s.indexOf(i);
            }
        }
        return -1;
    
    }
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

}