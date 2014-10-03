#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

void podmnozice(struct item * elementi, int len, struct ulong * podmno, int * lenP, struct ulong k, unsigned int W) {
    if (len == 0) { 
        podmno[*lenP].teza = k.teza;
        podmno[*lenP].vrednost = k.vrednost;
        ++(*lenP);
        return;
    }
    podmnozice(elementi, len - 1, podmno, lenP, k, W);
    k.teza +=  elementi[len - 1].teza;
    if (k.teza <= W) {
        k.vrednost += elementi[len - 1].vrednost;
        podmnozice(elementi, len - 1, podmno, lenP, k, W);
    }
}

int binary_search(struct ulong * a, struct ulong b, int start, int end, unsigned int W) {
    if (start > end) { return end; }
    int mid = start + ((end - start)/2);
    if (start == end) { return start; }
    if(a[mid].teza + b.teza > W) {
        binary_search(a, b, start, mid - 1, W);
    } else if (a[mid].teza + b.teza == W) {
        return mid;
    } else {
        binary_search(a, b, mid + 1, end, W);
    }
}
int knapsack(struct item * elementi, unsigned int W, int len) {
    int i = len - len/2;
    struct ulong k = {0, 0};
    struct ulong * podmnoziceA = malloc(sizeof(struct ulong) * power2(i));
    struct ulong * podmnoziceB = malloc(sizeof(struct ulong) * power2(len/2));
    if (podmnoziceA == NULL || podmnoziceB == NULL) { printf("%s\n", "Out of memory"); exit(1); }
    int lenP1 = 0;
    int lenP2 = 0;
    podmnozice(elementi, i, podmnoziceA, &lenP1, k, W);
    podmnozice(elementi + i, len/2, podmnoziceB, &lenP2, k, W);
    qsort(podmnoziceB, lenP2, sizeof(struct ulong), cmp);
    unsigned int vrednost = podmnoziceB[0].vrednost;
    int j = 1;
    for (i = 1; i <= lenP2; ++i)
    {
        /* if (!(vrednost > podmnoziceB[i].vrednost || (vrednost == podmnoziceB[i].vrednost && teza < podmnoziceB[i].teza))) */
        if (vrednost <= podmnoziceB[i].vrednost)
        {
            podmnoziceB[j].vrednost = podmnoziceB[i].vrednost;
            podmnoziceB[j].teza = podmnoziceB[i].teza;
            vrednost = podmnoziceB[j].vrednost;
            j++;
        }
    }
    /* j--; */
    /* for (i = 0; i <= j; ++i) */
    /* { */
    /*         printf("%lu %lu\n", podmnoziceB[i].teza, podmnoziceB[i].vrednost); */
    /* } */
    /* putchar('\n'); */
    k.vrednost = 0;
    for (i = 0; i < lenP1; ++i)
    {
        /* printf("%lu %lu\n", podmnoziceA[i].teza, podmnoziceA[i].vrednost); */
        lenP2 = binary_search(podmnoziceB, podmnoziceA[i], 0, j, W);
        if (podmnoziceA[i].teza + podmnoziceB[lenP2].teza <= W && podmnoziceA[i].vrednost + podmnoziceB[lenP2].vrednost > k.vrednost)
        {
            k.vrednost = podmnoziceA[i].vrednost + podmnoziceB[lenP2].vrednost;
        }
    }
    printf("%lu\n", k.vrednost);
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
