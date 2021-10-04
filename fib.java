
public class fib {

    public static void printFibSeries(int n){
        int a = 0 , b = 1, c;
        for (int i = 0; i <  n; i++){

            System.out.print(a + " ");
            c = a;
            a = b;
            b = c + b;
        }
    }

    public static void main(String[] args){

        printFibSeries(10);

    }
}
