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

	private static final int KAPACITETA = 700;

    public static void main(String[] args) {
        System.out.print("Stevilo praznih CD-jev: ");
        int n = BranjePodatkov.preberiInt();

        int stevilkaCDja = 1;
        int zasedenostCDja = 0;

        while (stevilkaCDja <= n) {
            System.out.print("Velikost datoteke (v MB): ");
            int velDat = BranjePodatkov.preberiInt();
            if (velDat == 0) {
                break;
            }

            if (zasedenostCDja + velDat <= KAPACITETA) {
                zasedenostCDja += velDat;
            } else {
                stevilkaCDja++;
                zasedenostCDja = velDat;
            }
            if (stevilkaCDja <= n) {
                System.out.printf("Datoteka se shrani na CD st. %d, " +
                                  "ki trenutno vsebuje %d MB podatkov.%n",
                                  stevilkaCDja, zasedenostCDja);
            } else {
                System.out.println("CD-jev je zmanjkalo!");
            }
            System.out.println();
        }
    }
}
