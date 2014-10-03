#include <stdio.h>
#include <stdlib.h>
int **polje;
int *vrsta1;
int *vrsta2;
int zacetek, konec, x, y;

void dodaj(int i, int j);
int odstrani1();
int odstrani2();

int main(int argc, char *argv[]) {
    int i, j, xQuene, yQuene, xSosed, ySosed;
    scanf("%d %d", &x, &y);

    polje = (int **)calloc(x , sizeof(int*));
    for(i = 0; i < x; i++) {
        polje[i] = (int*)calloc(y, sizeof(int));
    }

    while (scanf("%d %d", &i, &j) != EOF) {
        polje[i][j] = -1;
    }
    polje[0][0] = 0;
    polje[x-1][y-1] = 0;

    vrsta1 = (int *)calloc(x*y , sizeof(int*));
    vrsta2 = (int *)calloc(x*y , sizeof(int*));
    zacetek = -1;
    konec = 0; 
    while (zacetek < konec) {
        xQuene = odstrani1();
        yQuene = odstrani2();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++){
                xSosed = xQuene+(i%2)*(-1+2*(j%2));
                ySosed = yQuene+(i%2-1)*(-1+2*(j%2));
                if (xSosed >= 0 && ySosed >= 0 && xSosed < x && ySosed < y) {
                    if (polje[xQuene][yQuene] + 1 <  polje[xSosed][ySosed] || polje[xSosed][ySosed] == 0) {
                        dodaj(xSosed,ySosed);
                        polje[xSosed][ySosed] = polje[xQuene][yQuene] + 1;
                        /* printf("%d %d\n", xSosed, ySosed); */
                    }
               }
           

            }
        }

    }
    /* for (i = 0; i < x; i++) { */
    /*     for (j = 0; j < y; j++) { */
    /*         printf(" %2d", polje[i][j]); */
    /*     } */
    /*     putchar('\n'); */
    /* } */
    
    printf("%d\n", polje[x-1][y-1] == 0 ? -1 : polje[x-1][y-1]);
    
    for(i = 0; i < x; i++) {
        free(polje[i]);
    }

    free(polje);
    free(vrsta1);
    free(vrsta2);
    
    return 0;
}
void dodaj(int i, int j) {
    konec++;
    vrsta2[konec] = j;
    vrsta1[konec] = i;
}
int odstrani1() {
    zacetek++;
    return vrsta1[zacetek];
}
int odstrani2() {
    return vrsta2[zacetek];
}
