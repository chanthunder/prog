#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) {
    int dolzina, i, trenutno, maksimum, lokalni_max;
    int iStart = 0, iEnd = 0, lokStart = 0;
    scanf("%d", &dolzina);

    for (i = 0; i < dolzina; i++) {
        /* scanf("%d", &trenutno); */
        trenutno = rand()%2000-1000;
        if (i == 0) {
            maksimum = trenutno;
            lokalni_max = trenutno;
        } else {
            if (lokalni_max + trenutno > trenutno) {
                lokalni_max += trenutno;
            } else {
                lokStart = i;
                lokalni_max = trenutno;
            }
        }
        if (lokalni_max > maksimum) {
            maksimum = lokalni_max;
            iStart = lokStart;
            iEnd = i;
        }
    }
    printf("%d %d %d\n", iStart, iEnd - iStart + 1, maksimum);
    return 0;
}
