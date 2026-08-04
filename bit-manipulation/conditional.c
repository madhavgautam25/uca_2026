#include <stdio.h>

int conditional(int x, int y, int z) {

    int mask = ~(!!x) + 1;
    return (y & mask) | (z & ~mask);
}

int main() {
    
    int x, y, z;

    printf("Enter x: ");
    scanf("%d", &x);

    printf("Enter y: ");
    scanf("%d", &y);

    printf("Enter z: ");
    scanf("%d", &z);

    printf("Result = %d\n", conditional(x, y, z));

    return 0;
}