#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    int i;
    int c;
    int tl;
    tl = 0;
    do
    {
        c = getchar();
        if (c >= '0' && c <= '9') {
                tl = tl * 10 + (c - '0');
        }
    } while (c != ' ');
    int stevila[tl];
    for (i = 0; i < tl; i++) {
        stevila[i] = 0;
    }
    i = 0;
    do
    {
        c = getchar();
        if (c >= '0' && c <= '9') {
            stevila[i] = stevila[i] * 10 + (c - '0');
        } else if (c == ' ') {
            i++;
        } 
    } while (c != '\n');
    for (i = 0; i < tl; i++) {
        if (stevila[i] % 2 != 1) {
            int j;
            for (j = i; j < tl; j++) {
                if (stevila[j] % 2 != 1 && stevila[j] < stevila[i]) {
                    int buffer;
                    buffer = stevila[i];
                    stevila[i] = stevila[j];
                    stevila[j] = buffer;
                }
            }
        }
    }
    for (i = 0; i < tl; i++) {
        printf("%d ", stevila[i]);
        
    }
    putchar('\n');
    return 0;

}
