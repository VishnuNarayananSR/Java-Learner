abstract class Student {
    public abstract String result(String MarksOfStudent);

    public static float gradeCalc(String str) {
        float gpa;
        float mark = Float.parseFloat(str);
        if (mark >= 75)
            gpa = 9 + (mark - 75) / 25;
        else if (mark >= 60)
            gpa = 8 + (mark - 60) / 14;
        else if (mark >= 50)
            gpa = 7 + (mark - 50) / 9;
        else if (mark >= 40)
            gpa = 6 + (mark - 40) / 9;
        else
            gpa = 0;
        return Float.parseFloat(String.format("%1.1f", gpa));
    }
}

class Aided extends Student {
    public String result(String allMarks) {

        String[] set = allMarks.split("\\|");
        int sum = 0, credit = 0;
        String arr[] = set[0].split(",");
        for (String sub : arr) {
            String[] creditSplit = sub.split(" ");
            credit += 5;
            sum += gradeCalc(creditSplit[0]) * Float.parseFloat(creditSplit[1]);
        }
        String[] ncc = set[1].split(",");
        sum += Float.parseFloat(ncc[0]) * gradeCalc(ncc[1])
                * Float.parseFloat(ncc[2]);

        if (!ncc[0].equals("0"))
            credit += 5;
        float cgpa = sum / credit;
        String[] sports = set[2].split(",");
        sum += Float.parseFloat(sports[0]) * gradeCalc(sports[1])
                * Float.parseFloat(sports[2]);
        if (!sports[0].equals("0"))
            credit += 5;
        return String.format("%.2f", cgpa);
    }
}

class SelfFinance extends Student {
    public String result(String allMarks) {

        String[] set = allMarks.split("\\|");
        float sum = 0, credit = 0;
        String arr[] = set[0].split(",");
        for (String sub : arr) {
            String[] creditSplit = sub.split(" ");
            credit += 5;
            sum += gradeCalc(creditSplit[0]) * Float.parseFloat(creditSplit[1]);
        }
        String[] ncc = set[1].split(",");

        sum += Float.parseFloat(ncc[0]) * gradeCalc(ncc[1])
                * Float.parseFloat(ncc[2]);
        if (!ncc[0].equals("0"))
            credit += 5;
        float cgpa = sum / credit;
        return String.format("%.2f", cgpa);
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Aided ad = new Aided();
        SelfFinance sf = new SelfFinance();
        System.out.println(ad.result("100 5,100 5,100 5|1,100,5|0,100,5"));
        System.out.println(sf.result("100 5,100 5,100 5|1,100,5"));
        System.out.println(sf.result("100 5,100 5,53 5,76 3|0,100,5"));

    }
}