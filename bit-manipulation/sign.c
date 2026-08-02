#include <stdio.h>

int sign(int x) {

    return (x >> 31) | (!!x);
}

int main() {

    int x;
    scanf("%d", &x);

    printf("sign(%d) = %d\n", x, sign(x));

    return 0;
}