
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

		// zasedenosti posameznih CD-jev (na začetku so vse enake 0)
        int[] zasedenosti = new int[n];
		
		while (true) {
			System.out.println();
			System.out.print("Vnesite velikost datoteke (v MB): ");
			int velDat = sc.nextInt();
			if (velDat <= 0) {
				break;
			}
			
			// poišči indeks najmanj zasedenega (tj. ciljnega) CD-ja
			int iCiljniCD = najmanjZasedenCD(zasedenosti);
			
			// poglej, ali lahko datoteko shraniš na ciljni CD
			if (zasedenosti[iCiljniCD] + velDat <= KAPACITETA) {
				// shrani datoteko na ciljni CD
				System.out.printf("Datoteka se shrani na CD št. %d%n", iCiljniCD + 1);
				zasedenosti[iCiljniCD] += velDat;
				System.out.println(Arrays.toString(zasedenosti));  // izpiše tabelo zasedenosti
				
			} else {
				// datoteke ni mogoče shraniti na ciljni CD; zaključi izvajanje programa
				System.out.println("Datoteke ni mogoče shraniti na noben CD.");
				break;
			}
		}
    }
	
	// Vrne indeks najmanjšega elementa v tabeli <zasedenosti>.
	private static int najmanjZasedenCD(int[] zasedenosti) {
		int iMin = 0;
		for (int i = 1;  i < zasedenosti.length;  i++) {
			if (zasedenosti[i] < zasedenosti[iMin]) {
				iMin = i;
			}
		}
		return iMin;
	}
}
