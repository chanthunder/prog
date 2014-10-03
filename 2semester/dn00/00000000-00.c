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
     /* veliki Y ce je vpisano stevilo prastevilo, veliki N ce ni */
    int prastevilo;
    prastevilo = 1;
    if (n < 2) {
        prastevilo = 0;
    }
    int i;
    // lahko bi uporabili tudi koren iz n, vendar bi mogli includati math knjiznico
    for (i = 2; i <= (int)sqrt(n); i++) {
        if (n % i == 0) {
            prastevilo = 0;
            break;
        }
    }
    if (prastevilo == 1) {
        printf("%c", 'Y');
    } else {
        printf("%c", 'N');
    }
    return 0;

}
