#include <stdio.h>
#include <string.h>

void swap(void *a, void *b, size_t size) {
    char temp[size];

    memcpy(temp, a, size);
    memcpy(a, b, size);
    memcpy(b, temp, size);
}

int compareInt(const void *a, const void *b) {
    int x = *(int *)a;
    int y = *(int *)b;

    return x - y;
}

void heapify(void *arr, int n, int i, size_t size,
             int (*compare)(const void *, const void *)) {

    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    char *array = (char *)arr;

    if (left < n &&
        compare(array + left * size,
                array + largest * size) > 0) {

        largest = left;
    }

    if (right < n &&
        compare(array + right * size,
                array + largest * size) > 0) {

        largest = right;
    }

    if (largest != i) {

        swap(array + i * size, array + largest * size, size);

        heapify(arr, n, largest, size, compare);
    }
}

void heapSort(void *arr, int n, size_t size,
              int (*compare)(const void *, const void *)) {

    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i, size, compare);
    }

    for (int i = n - 1; i > 0; i--) {

        swap((char *)arr, (char *)arr + i * size, size);

        heapify(arr, i, 0, size, compare);
    }
}

int main() {

    int arr[] = {40, 10, 30, 50, 20};

    int n = sizeof(arr) / sizeof(arr[0]);

    heapSort(arr, n, sizeof(int), compareInt);

    printf("Sorted array: ");

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}