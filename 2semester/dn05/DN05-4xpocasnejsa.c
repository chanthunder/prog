#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
int main(int argc, char *argv[]) {
    int a, b, i, j;
    int pogoj = 0;
    int stevecBesed = 0;
    int vrstica = 1;
    char c;
    char * s; 
    char ** besede;
    int ** besedeLokacija;
    int * k;

    scanf("%d %d", &a, &b);
    besede = malloc(sizeof(char*) * b);
    besedeLokacija = calloc(b, sizeof(int*));
    for (i = 0; i < b; i++) {
        besedeLokacija[i] = calloc(b, sizeof(int));
    }
    s = malloc(sizeof(char) * (a+1));
    while (scanf("%s%c", s, &c) != EOF) {
        for (i = 0; i < stevecBesed; i++) {
            if (strcmp(besede[i], s) == 0) {
                for (j = 0; j < b; j++) {
                    if (besedeLokacija[i][j] == 0) {
                        besedeLokacija[i][j] = vrstica;
                        break;
                    }
                }
                pogoj = 1;
                break;
            }
        }
        if (!pogoj) {
            besede[stevecBesed] = malloc(sizeof(char) * (strlen(s)+1));
            strcpy(besede[stevecBesed], s);
            besedeLokacija[stevecBesed][0] = vrstica;
            stevecBesed++;
        }
        if (c == '\n') {
            vrstica++;
        }
        pogoj = 0;

    }
    for (i = 0; i < stevecBesed - 1; i++) {
        for (j = 0; j < stevecBesed - i - 1; j++) {
            if (strcmp(besede[j], besede[j+1]) > 0) {
                s = besede[j];
                besede[j] = besede[j+1];
                besede[j+1] = s;
                k = besedeLokacija[j];
                besedeLokacija[j] = besedeLokacija[j+1];
                besedeLokacija[j+1] = k;
            }
        }
    }
    for (i = 0; i < stevecBesed; i++) {
        printf("%s", besede[i]);
        for (j = 0; j < stevecBesed; j++) {
            if (besedeLokacija[i][j] != 0) {
                printf(" %d", besedeLokacija[i][j]);
            } else {
                break;
            }
        }
        putchar('\n');
    }
    return 0;
}
