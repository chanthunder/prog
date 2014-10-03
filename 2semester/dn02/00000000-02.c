#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) {
    /* dolzina je dolzina zaporedja */
    /* trenutno je stevilo, ki smo ga nazadnje prebrali */
    /* maksimum je absolutni maksimum */
    /* lokalni_max je lokalni maksimum */
    /* locili smo spremenljivke, ki jih kasneje nastavimo in tiste, ki jih takoj */
    int dolzina, i, trenutno, maksimum, lokalni_max;
    /* iStart je absolutni indeks zacetka maksimuma */
    /* iEnd je absolutni indeks konca maksimuma */
    /* lokStart je indeks zacetka lokalnega maksimuma */
    int iStart = 0, iEnd = 0, lokStart = 0;
    /* preberemo dolzino zaporedja */
    scanf("%d", &dolzina);

    for (i = 0; i < dolzina; i++) {
        /* preberemo ito stevilo zaporedja */
        scanf("%d", &trenutno);
        /* trenutno = rand()%2000-1000; */
        /* ce smo prvic v for zanki je lokalni in navadni maksimum enak prebranemu stevilu */
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
