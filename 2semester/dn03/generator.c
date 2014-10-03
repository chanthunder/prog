#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
/**
 * Program, ki ustvari nakljuèni labirint.
 * 
 * @return int
 */
int main(int argc, char *argv[])
{
    // Parametri za koordinate
    int y;
    int x;
    
    // Preberi koordinate in jih preveri
    if (scanf("%d %d\n", &y, &x) == false || (0 < y && y <= 1000000) == false || (0 < x && x <= 1000000) == false) {
        // Izhod iz programa
        return 1;
    }
    
    // Izpii velikost labirinta
    printf("%d %d\n", y, x);
    
    // Sprehod èez koordinate
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            // Generiraj tevilo, èe nismo na zaèetku ali koncu
            if (false == (i == 0 && j == 0) && (i == y - 1 && j == x - 1) == false) {
                // Ustvari nakljuèno tevilo
                int random = rand() % 100;
                
                // Nastavimo mino, èe je random v intervalu verjetnosti
                if (random < 20) {
                    // Izpii trenutne koordinate
                    printf("%d %d\n", i, j);
                }
            }
        }
    }
    return 0;
}
