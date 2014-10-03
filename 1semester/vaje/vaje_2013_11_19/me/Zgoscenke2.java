
/*
Na voljo imamo n 700-megabajtnih CD-jev, na katere bi radi shranili svoje
ključne datoteke. Nobena datoteka ni večja od 700 MB.  Vsako datoteko shranimo
na tisti CD, na katerem je trenutno največ prostora.

Napišite program, ki najprej prebere število n, nato pa zaporedoma bere
velikosti datotek (v MB).  Za vsako datoteko naj se izpiše, na kateri CD se
shrani in koliko MB podatkov je zapisanih na tistem CD-ju.  Program se
zaključi, ko zmanjka CD-jev ali ko uporabnik vnese 0. Primer:

Število praznih CD-jev: 3

Velikost datoteke (v MB): 300
Datoteka se shrani na CD št. 1
[300, 0, 0]

Velikost datoteke (v MB): 200
Datoteka se shrani na CD št. 2
[300, 200, 0]

Velikost datoteke (v MB): 500
Datoteka se shrani na CD št. 3
[300, 200, 500]

Velikost datoteke (v MB): 400
Datoteka se shrani na CD št. 2
[300, 600, 500]

Velikost datoteke (v MB): 400
Datoteka se shrani na CD št. 1
[700, 600, 500]

Velikost datoteke (v MB): 150
Datoteka se shrani na CD št. 3
[700, 600, 650]

Velikost datoteke (v MB): 200
Datoteke ni mogoče shraniti na noben CD.
*/

import java.util.Scanner;
import java.util.Arrays;   // za uporabo metode Arrays.toString
// ali enostavno: import java.util.*;

public class Zgoscenke2 {

    public static final int KAPACITETA = 700;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesite število praznih CD-jev: ");
        int n = sc.nextInt();
        int[] zasedenostcdjev = new int[n];
        while (n > 0) {
          System.out.print("Velikost datoteke (v MB): ");
          int shrani = sc.nextInt();
          System.out.println();
          int indeks = najvecProstora(zasedenostcdjev, n);

          if (zasedenostcdjev[indeks] + shrani <= KAPACITETA) { 
            zasedenostcdjev[indeks] += shrani;
            System.out.println("Datoteka se shrani na CD st. " + indeks + ".");
          } else {
            System.out.println("Datoteke ni mogoče shraniti na noben CD");
            System.exit(1);

          }
          
          
        }

        // ...
    }
    public static int najvecProstora(int[] cd, int n) {
      int min = KAPACITETA;
      int indeks = -1;
      for (int i = 0;i <= n ; i++) {
        if (cd[i] == 0) {
          return i + 1;
        }
        if (cd[i] < min) {
          min = cd[i];
          indeks = i + 1;
        } 
      }
      return indeks;
      
    }
}

