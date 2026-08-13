import java.util.*;

public class RunningMedian {

    static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void insert(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public static float getMedian() {

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0f;
        }

        return left.peek();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();

            insert(num);

            System.out.println("Median = " + getMedian());
        }

        sc.close();
    }
}
