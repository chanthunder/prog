// [Zgoscenke]

// Na voljo imamo n 700-megabajtnih CD-jev, na katere bi radi shranili svoje ključne datoteke. 
// Nobena datoteka ni večja od 700 MB.  CD-je polnimo po vrsti: če na trenutnem CD-ju ni 
// prostora za zapis dane datoteke, datoteko shranimo na naslednji CD.  Na predhodne CD-je se 
// nikoli ne vračamo.

// Napišite program, ki najprej prebere število n, nato pa zaporedoma bere velikosti datotek 
// (v MB).  Za vsako datoteko naj se izpiše, na kateri CD se shrani in koliko MB podatkov je 
// zapisanih na tistem CD-ju.  Program se zaključi, ko zmanjka CD-jev ali ko uporabnik 
// vnese 0. Primer:

// Število praznih CD-jev: 3

// Velikost datoteke (v MB): 300
// Datoteka se shrani na CD št. 1, ki trenutno vsebuje 300 MB podatkov.

// Velikost datoteke (v MB): 200
// Datoteka se shrani na CD št. 1, ki trenutno vsebuje 500 MB podatkov.

// Velikost datoteke (v MB): 250
// Datoteka se shrani na CD št. 2, ki trenutno vsebuje 250 MB podatkov.

// Velikost datoteke (v MB): 100
// Datoteka se shrani na CD št. 2, ki trenutno vsebuje 350 MB podatkov.

// Velikost datoteke (v MB): 300
// Datoteka se shrani na CD št. 2, ki trenutno vsebuje 650 MB podatkov.

// Velikost datoteke (v MB): 400
// Datoteka se shrani na CD št. 3, ki trenutno vsebuje 400 MB podatkov.

// Velikost datoteke (v MB): 500
// CD-jev je zmanjkalo!


public class Zgoscenke {

    public static void main(String[] args) {
        System.out.println("Stevilo praznih CD-jev: ");
        int n = BranjePodatkov.preberiInt();
				int i = 1;
				int size = 700;
				int currentsize = size;
				int vsebuje = 0;
				while (n > 0) {
					System.out.println("Velikost datoteke: ");
					int mb = BranjePodatkov.preberiInt();
					if (mb > size) {
						System.out.println("Prevelika datoteka");
						break;
					}	
					if (mb >= currentsize) {
						n = n - 1;
						if (n == 0) {
							break;
						}	
						i = i + 1;
						currentsize = size;
					}
						currentsize = currentsize - mb;
						vsebuje = size - currentsize;
						System.out.println("Datoteka se shrani na CD st " + i + ", ki trenutno vsebuje " + vsebuje + " MB podatkov");





				}
				if (n == 0) {
					System.out.println("CD-jev je zmanjkalo!");
					System.exit(1);
				}

		// ...
        
    }
}
