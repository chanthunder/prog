#include <stdio.h>
#include <stdlib.h>

unsigned int power2(int potence) { return 1 << potence; }

struct item {
    unsigned int teza;
    unsigned int vrednost;
};

struct ulong {
    unsigned long teza;
    unsigned long vrednost;
};

int cmp(const void * a, const void * b) {
    unsigned int c = ((const struct ulong*)a)->teza - ((const struct ulong*)b)->teza;
    if (c != 0) { return c; }
    return ((const struct ulong*)b)->vrednost - ((const struct ulong*)a)->vrednost;
}
int cmp_value(const void * a, const void * b) {
    unsigned int c = ((const struct ulong*)b)->vrednost - ((const struct ulong*)a)->vrednost;
    if (c != 0) { return c; }
    return ((const struct ulong*)a)->teza - ((const struct ulong*)b)->teza;
}

unsigned long vrednost_nahrbtnika(unsigned long nahrbtnik, struct item * elementi, int len) {
   unsigned long vrednost;
   for (int i = 0; i < len; ++i) {
       if (nahrbtnik & 0x1) {
           vrednost += elementi[i].vrednost;
       }
       nahrbtnik = nahrbtnik >> 1;
   }
   return vrednost;
}

unsigned long teza_nahrbtnika(unsigned long nahrbtnik, struct item * elementi, int len) {
   unsigned long vrednost;
   for (int i = 0; i < len; ++i) {
       if (nahrbtnik & 0x1) {
           vrednost += elementi[i].teza;
      }
      nahrbtnik = nahrbtnik >> 1;
   }
   return vrednost;
}
unsigned long eliminiraj_dominirane(struct item* sortirani_nahrbtniki, unsigned long max) {
    unsigned long vrednost = sortirani_nahrbtniki[0].vrednost;
    int i, j = 1;
    for (i = 1; i < max; ++i)
    {
        if (vrednost <= sortirani_nahrbtniki[i].vrednost)
        {
            sortirani_nahrbtniki[j].vrednost = sortirani_nahrbtniki[i].vrednost;
            sortirani_nahrbtniki[j].teza = sortirani_nahrbtniki[i].teza;
            vrednost = sortirani_nahrbtniki[j].vrednost;
            j = i;
        }
    }
    return j + 1;

}
void naredi_sortirane_nahrbtnike(struct item* items, int len, struct ulong** sortirani_nahrbtniki, int * len_sortirani_nahrbtniki) {
   unsigned long max = 1 << len;
   struct item * nahrbtniki = malloc(sizeof(struct ulong) * max);
   for (unsigned long i = 0; i < max; ++i) {
       nahrbtniki[i].vrednost = vrednost_nahrbtnika(i, items, len);
       nahrbtniki[i].teza = teza_nahrbtnika(i, items, len);
   }
   // psevdokoda
   qsort(nahrbtniki, max, sizeof(struct item), cmp);
   max = eliminiraj_dominirane(nahrbtniki, max);
   qsort(nahrbtniki, max, sizeof(struct item), cmp_value);
   *sortirani_nahrbtniki = nahrbtniki;
   *len_sortirani_nahrbtniki = max;
}

unsigned long mitm(struct item* A, int a_len, struct sortirani_nahrbtniki* B, int b_len) {
    return 0;
}

int knapsack(struct item * elementi, unsigned int W, int len) {
    int i, lenA = len - len/2;
    struct ulong k = {0, 0};
    struct ulong * podmnoziceA = malloc(sizeof(struct ulong) * power2(lenA));
    struct ulong * podmnoziceB = malloc(sizeof(struct ulong) * power2(len/2));
    if (podmnoziceA == NULL || podmnoziceB == NULL) { printf("%s\n", "Out of memory"); exit(1); }
    free(podmnoziceA);
    free(podmnoziceB);
    return 0;
}

int main(int argc, char *argv[]) {
    unsigned int x, y;
    unsigned int W;
    int buffer = 40;
    struct item * podatki = malloc(sizeof(struct item) * buffer);
    int len = 0;
    scanf("%u", &W);
    while(scanf("%u %u", &x, &y) != EOF) {
        podatki[len].teza = x;
        podatki[len].vrednost = y;
        len++;
    }
    knapsack(podatki, W, len);
    free(podatki);
    return 0;
}
