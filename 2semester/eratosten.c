#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    int n;
    int c;
    n = 0;
    do
    {
        c = getchar();
        if (c >= '0' && c <= '9') {
            n = 10*n + (c - '0');
        }
    } while (c != '\n');

    int i;
    int k;
    unsigned char a;
    long b = 1; //The lowest bit is set
    for(long i = 0; i < n; i++)
    {
         a |= b; //Set the bit
          b <<= 1; //Go to the next bit
    }

    for (int i=2; i<n; i++) {
        if (tabela[i] == true) {
            printf("%d\n", i);
            for (int k=2; k*i <= n; k++) {
                tabela[i*k] = false;
            }
        }
    }
    return 0;

}
