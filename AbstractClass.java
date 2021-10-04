import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

abstract class Student{
    public abstract String result(String MarksOfStudent);
}

class Aided extends Student{
    public String result(String allMarks){

        String[] set = allMarks.split("\\|");
        int sum = 0, credit = 0;
        String arr[] = set[0].split(",");
          for(String sub: arr){
              String[] creditSplit =sub.split(" ");
              credit += Integer.parseInt(creditSplit[1]);
              sum += Integer.parseInt(creditSplit[0]) * Integer.parseInt(creditSplit[1]);
          }
        sum += Arrays.stream(set[1].split(","))
        .mapToInt(Integer::parseInt)
        .reduce(1, (a, b) -> a * b);
        credit += Integer.parseInt(set[1].split(",")[2]);
        sum += Arrays.stream(set[2].split(","))
        .mapToInt(Integer::parseInt)
        .reduce(1, (a, b) -> a * b);
        credit += Integer.parseInt(set[2].split(",")[2]);
        System.out.println(credit + " " + sum);

        float cgpa = sum/credit;
        return Float.toString(cgpa);
    }
}

class SelfFinance extends Student{
    public String result(String allMarks){

        String[] set = allMarks.split("\\|");
        int sum = 0, credit = 0;
        String arr[] = set[0].split(",");
          for(String sub: arr){
              String[] creditSplit =sub.split(" ");
              credit += Integer.parseInt(creditSplit[1]);
              sum += Integer.parseInt(creditSplit[0]) * Integer.parseInt(creditSplit[1]);
          }
        sum += Arrays.stream(set[1].split(","))
        .mapToInt(Integer::parseInt)
        .reduce(1, (a, b) -> a * b);
        credit += Integer.parseInt(set[1].split(",")[2]);
        float cgpa = sum/credit;
        System.out.println(credit + " " + sum);
        return Float.toString(cgpa);
    } 
}

public class AbstractClass{
    public static void main(String[] args) {
        Aided ad = new Aided();
        SelfFinance sf = new SelfFinance();
        System.out.println(ad.result("100 5,100 5,100 5|1,100,5|1,100,5"));
        System.out.println(sf.result("100 5,100 5,100 5|1,100,5|1,100,5"));
    }
}