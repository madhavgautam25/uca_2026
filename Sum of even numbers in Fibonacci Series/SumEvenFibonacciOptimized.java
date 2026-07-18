import java.util.Scanner;
public class SumEvenFibonacciOptimized {

    public static long sumEven(long n) {

        if (n < 2)
            return 0;

        long sum = 0;

        long a = 2;
        long b = 8;

        while (a <= n) {

            sum += a;

            long c = 4 * b + a;

            a = b;
            b = c;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(sumEven(n));
    }
}