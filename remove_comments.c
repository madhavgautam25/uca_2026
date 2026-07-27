#include <stdio.h>

int main() {
    int c, next;
    int inString = 0;
    int inChar = 0;

    while ((c = getchar()) != EOF) {

        if (inString) {
            putchar(c);

            if (c == '\\') {
                if ((c = getchar()) != EOF)
                    putchar(c);
            } else if (c == '"') {
                inString = 0;
            }
        }

        else if (inChar) {
            putchar(c);

            if (c == '\\') {
                if ((c = getchar()) != EOF)
                    putchar(c);
            } else if (c == '\'') {
                inChar = 0;
            }
        }

        else {
            if (c == '"') {
                inString = 1;
                putchar(c);
            }

            else if (c == '\'') {
                inChar = 1;
                putchar(c);
            }

            else if (c == '/') {

                next = getchar();

                if (next == '/') {
                    while ((c = getchar()) != EOF && c != '\n');
                    if (c == '\n')
                        putchar('\n');
                }

                else if (next == '*') {
                    int prev = 0;

                    while ((c = getchar()) != EOF) {
                        if (prev == '*' && c == '/')
                            break;
                        prev = c;
                    }
                }

                else {
                    putchar('/');
                    if (next != EOF)
                        ungetc(next, stdin);
                }
            }

            else {
                putchar(c);
            }
        }
    }

    return 0;
}