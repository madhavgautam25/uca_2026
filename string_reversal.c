#include <stdio.h>

void reverse_string(char str[]) {
    int i, j = 0;

    while (str[j] != '\0')
        j++;

    j--;

    for (i = 0; i < j; i++, j--) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

int main() {
    char str[] = "Data Structures";

    reverse_string(str);

    printf("%s", str);

    return 0;
}