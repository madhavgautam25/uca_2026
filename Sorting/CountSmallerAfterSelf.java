import java.util.*;

public class CountSmallerAfterSelf {

    static int[] answer;

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static void mergeSort(Pair[] arr, int low, int high) {

        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    static void merge(Pair[] arr, int low, int mid, int high) {

        Pair[] temp = new Pair[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        int smaller = 0;

        while (i <= mid && j <= high) {

            if (arr[j].value < arr[i].value) {

                temp[k++] = arr[j++];
                smaller++;

            } else {

                answer[arr[i].index] += smaller;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {

            answer[arr[i].index] += smaller;
            temp[k++] = arr[i++];
        }

        while (j <= high) {

            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[low + p] = temp[p];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        int n = list.size();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }

        Pair[] arr = new Pair[n];

        answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
        
    }
}