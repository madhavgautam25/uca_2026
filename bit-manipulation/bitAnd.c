#include<stdio.h>

int bitAnd(int x, int y) {
    return ~(~x | ~y);
}

int main() {

    int x,y;
    scanf("%d", &x);
    scanf("%d", &y);

    printf("bitAnd(%d, %d) = %d\n", x, y, bitAnd(x, y));

    return 0;
}