#include <stdio.h>
#include <stdlib.h>

int countPairs(int arr[], int low, int mid, int high) {
    int count = 0;
    int j = mid + 1;

    for (int i = low; i <= mid; i++) {
        while (j <= high && (long long)arr[i] > 2LL * arr[j]) {
            j++;
        }
        count += (j - (mid + 1));
    }

    return count;
}

void merge(int arr[], int low, int mid, int high) {
    int n = high - low + 1;
    int *temp = (int *)malloc(n * sizeof(int));

    int left = low;
    int right = mid + 1;
    int k = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right])
            temp[k++] = arr[left++];
        else
            temp[k++] = arr[right++];
    }

    while (left <= mid)
        temp[k++] = arr[left++];

    while (right <= high)
        temp[k++] = arr[right++];

    for (int i = 0; i < n; i++)
        arr[low + i] = temp[i];

    free(temp);
}

int mergeSort(int arr[], int low, int high) {
    if (low >= high)
        return 0;

    int mid = low + (high - low) / 2;

    int count = 0;

    count += mergeSort(arr, low, mid);
    count += mergeSort(arr, mid + 1, high);

    count += countPairs(arr, low, mid, high);

    merge(arr, low, mid, high);

    return count;
}

int reversePairs(int arr[], int n) {
    return mergeSort(arr, 0, n - 1);
}

int main() {
    int n;

    scanf("%d", &n);

    int *arr = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("%d\n", reversePairs(arr, n));

    free(arr);

    return 0;
}