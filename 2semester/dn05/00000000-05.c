#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
void shuffle(char **array, int * y, size_t n);
void pquicksort(char ** x, int * y, int zacetek, int konec);
void quicksort(char ** x, int * y, int i);

int main(int argc, char *argv[]) {
    int a, b, i;
    int stevec = 0;
    int vrstica = 1;
    char c;
    char * s; 
    char ** besede;
    int * vrstice;

    scanf("%d %d", &a, &b);
    besede = malloc(sizeof(char*) * b);
    vrstice = malloc(sizeof(int) * b);
    s = malloc(sizeof(char) * (a+1));
    while (scanf("%s%c", s, &c) != EOF) {
        besede[stevec] = malloc(sizeof(char) * (strlen(s)+1));
        strcpy(besede[stevec], s);
        vrstice[stevec] = vrstica;
        stevec++;
        if (c == '\n') {
            vrstica++;
        }

    }
    quicksort(besede, vrstice, stevec);
    s = besede[0]; 
    printf("%s", s);
    for (i = 0; i < stevec; i++) {
        if (strcmp(s, besede[i]) != 0) {
            printf("\n%s", besede[i]);
            s = besede[i];
        }
        printf(" %d", vrstice[i]);
    }
    putchar('\n');
    for (i = 0; i < b; i++) {
        free(besede[i]);
    }
    free(besede);
    free(vrstice);
    return 0;
}

void pquicksort(char ** x, int * y, int zacetek, int konec) {
    int i, j, pivot, m;
    char *temp;
    if (zacetek < konec) {
        pivot = zacetek;
        i = zacetek;
        j = konec;

        while (i < j) {
            while ((strcmp(x[i], x[pivot]) < 0 || (strcmp(x[i], x[pivot]) == 0 && y[i] <= y[pivot])) && i < konec) {
                i++;
            }
            while(strcmp(x[j], x[pivot]) > 0 || (strcmp(x[j], x[pivot]) == 0 && y[j] > y[pivot])) {
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
void quicksort(char **x, int * y, int i){
    shuffle(x, y, (size_t)i);
    pquicksort(x, y, 0, i-1);
}

void shuffle(char **array, int * y, size_t n)
{
    char * t;
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
