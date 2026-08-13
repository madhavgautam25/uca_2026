package HeapSort;

import java.util.*;

public class HeapSort {

    static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest element is not the root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(int[] arr) {

        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Delete maximum element one by one
        for (int i = n - 1; i > 0; i--) {

            // Move maximum element to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore heap
            heapify(arr, i, 0);
        }
    }

    // Create random array
    static int[] randomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    // Create ascending array
    static int[] ascendingArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    // Create descending array
    static int[] descendingArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }

        return arr;
    }

    // Measure execution time
    static long getTime(int[] arr) {

        long start = System.nanoTime();

        heapSort(arr);

        long end = System.nanoTime();

        return end - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000, 50000};

        System.out.println("Input Size\tRandom\tAscending\tDescending");

        for (int n : sizes) {

            long randomTime = getTime(randomArray(n));
            long ascendingTime = getTime(ascendingArray(n));
            long descendingTime = getTime(descendingArray(n));

            System.out.println(
                n + "\t\t" +
                randomTime / 1_000_000.0 + " ms\t" +
                ascendingTime / 1_000_000.0 + " ms\t" +
                descendingTime / 1_000_000.0 + " ms"
            );
        }
    }
}