//author: sushen


import java.util.Scanner;

class Task1 extends Thread {
    static int a, beg;

    public void run() {
        int k = Task1.beg;
        int c = 0;
        while (c < Task1.a) {
            Solution.threadArray[Integer.parseInt(Solution.i)] = k;
            int j = Integer.parseInt(Solution.i);
            j++;
            c++;
            k++;
            Solution.i = j + "";
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

        }

    }
}

class Task2 extends Thread {
    static int a = 0, beg = 0;

    public void run() {
        int k = Task2.beg;
        int c = 0;
        while (c < Task2.a) {
            Solution.threadArray[Integer.parseInt(Solution.i)] = k;
            int j = Integer.parseInt(Solution.i);
            j++;
            c++;
            k++;
            Solution.i = j + "";
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

        }
    }

}

class Task3 extends Thread {
    static int a = 0, beg = 0;

    public void run() {

        for (int i = Task3.beg; i < Task3.a + Task3.beg; i++) {
            Solution.threadArray[i] = i;
        }

    }

}

public class Multithreading {
    public static final int[] threadArray = new int[300];
    public static volatile String i = 0 + "";

    public boolean test() throws InterruptedException {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        int first = Task1.a + Task2.a;
        int containsSecondThread = Task1.a;
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for (int i = 0; i < first; i++) {
            oneAndTwo += threadArray[i] + " ";
        }
        for (int i = 0; i < containsSecondThread; i++) {
            sizeOfTask1 += threadArray[i] + " ";
        }
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for (int i = begOfTask3; i < threadArray.length; i++) {
            checkingString += i + " ";
        }
        String task3String = "";
        for (int j = begOfTask3; j < threadArray.length; j++) {
            task3String += threadArray[j] + " ";
        }
        if ((!oneAndTwo.contains(begOfTask3 + "") && sizeOfTask1.contains(Task2.beg + ""))
                && task3String.equals(checkingString)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int one = sc.nextInt();
        Task1.a = one;
        Task1.beg = 0;
        int two = sc.nextInt();
        Task2.a = two;
        Task2.beg = one;
        int three = sc.nextInt();
        Task3.a = three;
        Task3.beg = one + two;
        System.out.print(solution.test());
    }
}