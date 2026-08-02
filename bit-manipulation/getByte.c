#include <stdio.h>

int getByte(int x, int n) {

    return (x >> (n << 3)) & 0xFF;
}

int main() {
    
    int x, n;

    printf("Enter x (in hexadecimal): ");
    scanf("%x", &x);

    printf("Enter byte number (0-3): ");
    scanf("%d", &n);

    printf("Extracted Byte = 0x%X\n", getByte(x, n));

    return 0;
}