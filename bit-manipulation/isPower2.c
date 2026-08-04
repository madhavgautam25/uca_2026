#include <stdio.h>

int isPower2(int x) {

    return !!x & !(x >> 31) & !((x + ~0) & x);
}

int main() {
    
    int x;

    printf("Enter a number: ");
    scanf("%d", &x);

    if (isPower2(x))
        printf("%d is a power of 2.\n", x);
    else
        printf("%d is not a power of 2.\n", x);

    return 0;
}