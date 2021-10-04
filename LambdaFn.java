import java.util.*;
import java.util.stream.Collectors;

public class LambdaFn {
  public static boolean isNarcissistic(String x) {
    int digitCount = x.length();
    long n = Long.parseLong(x);
    long tmp = n, sum = 0;
    while (tmp > 0) {
      sum += Math.pow(tmp % 10, digitCount);
      tmp /= 10;
    }
    return sum == n;
  }

  public List<Long> functionalProgramming(List<String> listOfIntegers) {
    List<Long> outputList = listOfIntegers.stream().filter(x -> isNarcissistic(x)).map(Long::parseLong)
        .collect(Collectors.toList());
    return outputList;
  }

  public static void main(String[] args) {
    String[] arr = new String[] { "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312",
        "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328",
        "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344",
        "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360",
        "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371", "372", "373", "374", "375", "376",
        "377", "378", "379", "380", "381", "382", "383", "384", "385", "386", "387", "388", "389", "390", "391", "392",
        "393", "394", "395", "396", "397", "398", "399", "400" };
    LambdaFn ob = new LambdaFn();
    System.out.println(ob.functionalProgramming(Arrays.asList(arr)));
  }

}