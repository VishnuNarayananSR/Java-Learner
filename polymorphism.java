import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Parent{
    static int startElement, endElement;
    public String filter(){
        return null;
    }
}
class ChildOne extends Parent{
    @Override
    public String filter(){
        String res = "";
        for (int i = startElement; i < endElement; i++) {
            if (i == 1 || i == 0)
                continue;
            int flag = 1;
 
            for (int j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
 
            if (flag == 1)
                res+= i + " ";
        }
        return res;
        }
}

class ChildTwo extends Parent{
       public static int isHappyNumber(int num){  
        int rem = 0, sum = 0;  
          
        while(num > 0){  
            rem = num%10;  
            sum = sum + (rem*rem);  
            num = num/10;  
        }  
        return sum;  
    }  
    @Override
    public String filter() {
        String res = "";
        for(int i = startElement; i < endElement; i++){  
            int result = i;   
            while(result != 1 && result != 4){  
                result = isHappyNumber(result);  
            }  
              
            if(result == 1)  
                res += i +" ";  
        }  
        return res;
    }
}
public class polymorphism {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        Parent p = new Parent();
        ChildOne one = new ChildOne();
        ChildTwo two = new ChildTwo();
        Parent.startElement = sc.nextInt();
        Parent.endElement = sc.nextInt();
        System.out.println(one.filter());
        System.out.println(two.filter());
        
        
    }
}