import java.io.*;
import java.util.*;
public class firstRepeatingInt {
    public static int solution(int[] arr){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr){
            int count = map.containsKey(i) ? map.get(i):0;
            map.put(i, count + 1);
            }

        for (int i: arr){
            if (map.get(i) == 1){
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException{

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String s = br.readLine();
        // int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        // List<Integer> list= new ArrayList<>();
        // Scanner sc = new Scanner(System.in);
        // while(sc.hasNextInt()){
        //     list.add(sc.nextInt());
        // }
        // System.out.println(solution(list.stream().mapToInt(Integer::intValue).toArray()));

        System.out.println(solution(new int[]{2,3,4,5,5,2}));
        System.out.println(solution(new int[]{3,2,3,4,5,5,2}));
        System.out.println(solution(new int[]{2,3,3,4,4,5,5,2}));


    }
}
