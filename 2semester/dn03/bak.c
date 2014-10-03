#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int **polje;
int **visited;

int premiki(int x, int y, int i, int j) {
    if (i == x && j == y) {
        return polje[i][j];
    } else if (visited[i][j] == 0) {
        if (i+1 < x && visited[i+1][j] == 0) {
            if (polje[i+1][j] == 0 || polje[i+1][j] > polje[i][j] + 1) {
                polje[i+1][j] = polje[i][j] + 1;
                premiki(x, y, i+1, j);
            }
            visited[i+1][j] = 1;
        }
        if (j+1 < y && visited[i][j+1] == 0) {
            if (polje[i][j+1] == 0 || polje[i][j+1] > polje[i][j] + 1) {
                polje[i][j+1] = polje[i][j] + 1;
                premiki(x, y, i, j+1);
            }
            visited[i][j+1] = 1;
        }
        if (i-1 >= 0 && visited[i-1][j] == 0) {
            if (polje[i-1][j] == 0 || polje[i-1][j] > polje[i][j] + 1) {
                polje[i-1][j] = polje[i][j] + 1;
                premiki(x, y, i-1, j);
            }
            visited[i-1][j] = 1;
        }
        if (j-1 >= 0 && visited[i][j-1] == 0) {
            if (polje[i][j-1] == 0 || polje[i][j-1] > polje[i][j] + 1) {
                polje[i][j-1] = polje[i][j] + 1;
                premiki(x, y, i, j-1);
            }
            visited[i][j-1] = 1;
        }
        return polje[i][j];
    } else {
        return -1;
    }
}
int main(int argc, char *argv[]) {
    int i, j, k, x, y, razdalja = -1;
    scanf("%d %d", &x, &y);
    // allocate the 2d array
    polje = (int **)calloc(x , sizeof(int*));
    visited = (int **)calloc(x , sizeof(int*));
    for(i = 0; i < x; i++) {
        polje[i] = (int*)calloc(y, sizeof(int));
        visited[i] = (int*)calloc(y, sizeof(int));
    }
    while (scanf("%d %d", &i, &j) != EOF) {
        polje[i][j] = -1;
        visited[i][j] = -1;
    }
    visited[0][0] = 0;
    visited[x][y] = 0;
    /* for (i = 0; i < x; i++) { */
    /*     for (j = 0; j < y; j++) { */
    /*         // v koncu ali zacetku je lahko mina pa nas to ne zanima */
    /*         if (polje[i][j] != -1 || (i == x && j == y) || (i == 0 && j == 0)) { */
    /*             if (i+1 < x)  */
    /*                 polje[i+1][j] = (polje[i][j] + 1 > polje[i+1][j] && polje[i+1][j] < 0) ? polje[i+1][j] : polje[i][j] + 1; */
    /*             if (j+1 < y)  */
    /*                 polje[i][j+1] = (polje[i][j] + 1 > polje[i][j+1] && polje[i][j+1] < 0) ? polje[i][j+1] : polje[i][j] + 1; */
    /*             if (i-1 > 0)  */
    /*                 polje[i-1][j] = (polje[i][j] + 1 > polje[i-1][j] && polje[i-1][j] < 0) ? polje[i-1][j] : polje[i][j] + 1; */
    /*             if (j-1 > 0)  */
    /*                 polje[i][j-1] = (polje[i][j] + 1 > polje[i][j-1] && polje[i][j-1] < 0) ? polje[i][j-1] : polje[i][j] + 1; */
    /*         } */
    /*     } */
    /* } */
    premiki(x, y, 0, 0);
    
    for (i = 0; i < x; i++) {
        for (j = 0; j < y; j++) {
            printf(" %2d", polje[i][j]);
        }
        putchar('\n');
    }
    // destroy the 2d array
    for(i = 0; i < x; i++) {
        free(polje[i]);
        free(polje);
    }
    return 0;
}
