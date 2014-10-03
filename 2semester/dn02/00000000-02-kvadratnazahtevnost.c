#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) {
    int dolzina, i, j, max, iMax, dMax, pz, pzi;
    scanf("%d", &dolzina);
    int cifre[dolzina];
    for (i = 0; i < dolzina; i++) {
        scanf("%d", &(cifre[i]));
    }
    iMax = 0;
    dMax = 1;
    max = cifre[0];
    for (i = 0; i < dolzina; i++) {
        if (cifre[i] > max) {
            max = cifre[i];
            iMax = i;
            dMax = 1;
        }
        pz = cifre[i];
        pzi = 1;
        for (j = i+1; j < dolzina; j++) {
                pz += cifre[j];
                pzi++;
                if (pz > max) {
                    max = pz;
                    iMax = i;
                    dMax = pzi;
                }
        }
    }
    printf("%d %d %d\n", iMax, dMax, max);
    return 0;
}
