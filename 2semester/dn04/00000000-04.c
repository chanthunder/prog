#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
void shuffle(int * array, int * y, size_t n);
void quicksort(int * x, int * y, int i);
void pquicksort(int * x, int * y, int zacetek, int konec);

void sosedi(int * x, int * y, int * sosX, int * sosY, int m) {
    int i, j, k;
    for (i = 0; i < m; i++) {
            for (j = -1; j <= 1; j++) {
                for (k = -1; k <= 1; k++) {
                     if (j != 0 || k != 0) {
                         sosX[8*i + ((3*(k+1) + j + 5)%9)] = x[i] + j;
                         sosY[8*i + ((3*(k+1) + j + 5)%9)] = y[i] + k;
                     }
                }
            }
    }
}
int jeZiva(int a, int b, int * x, int * y, int start, int size) {
    int i;
    for (i = start; i < size; i++) {
        if (a == x[i] && b == y[i]) {
            return 1;
        }
    }
    return 0;

}
int main(int argc, char *argv[]) {
    int *celicex;
    int *celicey;
    int *sosedix;
    int *sosediy;
    int *nextgenx;
    int *nextgeny;
    int i, g, n, zive, pogoj, prejsnaX, prejsnaY, stevec;
    scanf("%d", &g);
    scanf("%d", &n);
    int max = n*(g+1)/2 < 1000 ? n*(g+1)/2 : 1000;
    zive = 0;
    pogoj = 0;
    celicex = malloc(max * sizeof(int));
    celicey = malloc(max * sizeof(int));
    sosedix = calloc((8*max), sizeof(int));
    sosediy = calloc((8*max), sizeof(int));
    nextgenx = calloc(max, sizeof(int));
    nextgeny = calloc(max, sizeof(int));
    for (i = 0; i < n; i++) {
        scanf("%d %d", &celicex[i], &celicey[i]);
    }
    quicksort(celicex, celicey, n);
    while (pogoj < g) {
        sosedi(celicex, celicey, sosedix, sosediy, n);
        quicksort(sosedix, sosediy, 8*n);
        prejsnaX = sosedix[0];
        prejsnaY = sosediy[0];
        stevec = 0;
        for (i = 0; i < 8*n; i++) {
            if (prejsnaX != sosedix[i] || prejsnaY != sosediy[i]) {
                if (stevec == 3 || (stevec == 2 && jeZiva(prejsnaX, prejsnaY, celicex, celicey, zive/2, n))) {
                    nextgenx[zive] = prejsnaX;
                    nextgeny[zive] = prejsnaY;
                    zive++;
                }
                prejsnaX = sosedix[i];
                prejsnaY = sosediy[i];
                stevec = 0;
            }
            stevec++;
        }
        n = zive;
        if (n == 0) {
            break;
        }
        zive = 0;
        memcpy(celicex, nextgenx, n * sizeof(int));
        memcpy(celicey, nextgeny, n * sizeof(int));
        pogoj++;
    }
    if (n != 0) {
        int sMin, sMax, vMin, vMax;
        sMin = celicex[0];
        vMin = INT_MAX;
        sMax = celicex[n-1];
        vMax = INT_MIN;
        for (i = 0; i < n; i++) {
            vMin=celicey[i] < vMin ? celicey[i] : vMin;
            vMax=celicey[i] > vMax ? celicey[i] : vMax;
        }
        printf("%d %d %d %d %d\n", n, sMin, sMax, vMin, vMax);
    } else {
        printf("%d\n", n);
    }

    free(celicex);
    free(celicey);
    free(nextgenx);
    free(nextgeny);
    free(sosedix);
    free(sosediy);
    
    return 0;
}

void pquicksort(int * x, int * y, int zacetek, int konec) {
    int i, j, pivot, m, temp;
    if (zacetek < konec) {
        pivot = zacetek;
        i = zacetek;
        j = konec;

        while (i < j) {
            while ((x[i] < x[pivot] || (x[i] == x[pivot] && y[i] <= y[pivot])) && i < konec) {
                i++;
            }
            while(x[j] > x[pivot] || (x[j] == x[pivot] && y[j] > y[pivot])) {
                j--;
            }
            if(i<j) {
                temp=x[i];
                x[i]=x[j];
                x[j]=temp;
                m=y[i];
                y[i]=y[j];
                y[j]=m;
            } else {
                temp=x[pivot];
                x[pivot]=x[j];
                x[j]=temp;
                m=y[pivot];
                y[pivot]=y[j];
                y[j]=m;
            }
        }
        pquicksort(x, y, zacetek, j-1);
        pquicksort(x, y, j+1, konec);
    }
}
void quicksort(int * x, int * y, int i) {
    shuffle(x, y, (size_t)i);
    pquicksort(x, y, 0, i-1);
}

void shuffle(int * array, int * y, size_t n)
{
    int t;
    int m;
    if (n > 1) {
        size_t i;
        for (i = 0; i < n - 1; i++) {
            size_t j = i + rand() / (RAND_MAX / (n - i) + 1);
            t = array[j];
            array[j] = array[i];
            array[i] = t;
            m=y[j];
            y[j]=y[i];
            y[i]=m;
        }
    }
}
