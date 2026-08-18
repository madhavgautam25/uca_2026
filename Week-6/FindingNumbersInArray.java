import java.util.*;

public class FindingNumbersInArray {

    public static int findNumberRepeatingFourTimes(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int num : arr) {
            int newOnes = (ones ^ num) & ~twos;
            int newTwos = (twos ^ num) & ~newOnes;

            ones = newOnes;
            twos = newTwos;
        }

        return ones;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = findNumberRepeatingFourTimes(arr);

        System.out.println("Number repeating 4 times: " + answer);

        sc.close();
    }
}