import java.util.Scanner;

public class SumEvenFibonacciBrute {

    public static int sumEven(int n) {

        int a = 1;
        int b = 1;
        int sum = 0;

        while (a <= n) {

            if (a % 2 == 0)
                sum += a;

            int c = a + b;
            a = b;
            b = c;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumEven(n));
        
    }
}