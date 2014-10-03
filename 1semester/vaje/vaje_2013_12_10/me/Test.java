
public class Test {

    public static void main(String[] args) {
        Naslov[] naslovi = new Naslov[6];
        naslovi[0] = new Naslov("Sprednja 7", 1000, "Ljubljana");
        naslovi[1] = new Naslov("Zadnja 11",  2000, "Maribor");
        naslovi[2] = new Naslov("Zgornja 6",  3000, "Celje");
        naslovi[3] = new Naslov("Spodnja 9",  4000, "Kranj");
        naslovi[4] = new Naslov("Velika 10",  5000, "Nova Gorica");
        naslovi[5] = new Naslov("Mala 2",     6000, "Koper");

        Oseba anka   = new Oseba("Anka",   "Avbelj",   52, naslovi[5]);
        Oseba branko = new Oseba("Branko", "Brezovar", 58, naslovi[3]);
        Oseba cvetka = new Oseba("Cvetka", "Cajzek",   79, naslovi[4]);
        Oseba drago  = new Oseba("Drago",  "Debeljak", 48, naslovi[5]);
        Oseba ema    = new Oseba("Ema",    "Ertl",     31, naslovi[0]);
        Oseba franci = new Oseba("Franci", "Frelih",   28, naslovi[1]);
        Oseba gregor = new Oseba("Gregor", "Golob",    33, naslovi[0]);
        Oseba helga  = new Oseba("Helga",  "Hojnik",   56, naslovi[5]);
        Oseba iva    = new Oseba("Iva",    "Ihan",     25, naslovi[0]);
        Oseba janko  = new Oseba("Janko",  "Jelenc",   72, naslovi[2]);

        // Skupine prijateljev:
        // -- Anka, Branko, Drago, Helga
        // -- Cvetka, Janko
        // -- Ema, Gregor, Iva

        anka.nastaviPrijatelje(new Oseba[]{branko, drago, helga});
        branko.nastaviPrijatelje(new Oseba[]{anka, drago, helga});
        drago.nastaviPrijatelje(new Oseba[]{anka, branko, helga});
        helga.nastaviPrijatelje(new Oseba[]{anka, branko, drago});

        cvetka.nastaviPrijatelje(new Oseba[]{janko});
        janko.nastaviPrijatelje(new Oseba[]{cvetka});

        ema.nastaviPrijatelje(new Oseba[]{gregor, iva});
        gregor.nastaviPrijatelje(new Oseba[]{ema, iva});
        iva.nastaviPrijatelje(new Oseba[]{gregor, ema});

        franci.nastaviPrijatelje(new Oseba[]{});

        Oseba[] osebe = new Oseba[]{
            anka, branko, cvetka, drago, ema, franci, gregor, helga, iva, janko
        };

        System.out.println("Vse osebe in njihovi prijatelji:");
        izpisiOsebeInPrijatelje(osebe);
        System.out.println("----------------------------------------");

        System.out.println("Najstarejši Brankov prijatelj:");
        System.out.println(branko.najstarejsiPrijatelj().toString());
        System.out.println("----------------------------------------");

        System.out.println("Ankini prijatelji na istem naslovu:");
        anka.prijateljiNaIstemNaslovu();
        System.out.println("----------------------------------------");

        System.out.println("Gregorjevi prijatelji na istem naslovu:");
        gregor.prijateljiNaIstemNaslovu();
        System.out.println("----------------------------------------");

        System.out.println("Matrika prijateljstev:");
        boolean[][] matrika = Oseba.prijateljstva(osebe);
        for (int i = 0;  i < matrika.length;  i++) {
            for (int j = 0;  j < matrika[i].length;  j++) {
                System.out.print(matrika[i][j] ? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Za vsako osebo iz tabele `osebe' izpiše njene osnovne podatke 
     * (ime, priimek, starost in poštni naslov) in imena njenih prijateljev.
     */
    private static void izpisiOsebeInPrijatelje(Oseba[] osebe) {
        // ...
    }
}

