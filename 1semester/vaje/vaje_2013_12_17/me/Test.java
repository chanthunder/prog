
import java.util.*;

public class Test {

    private static final Oseba[] OSEBE = {
        new Oseba("Ana", "Azman", "Spodnja 1, 1000 Ljubljana"),
        new Oseba("Boris", "Bezjak", "Zgornja 2, 2000 Maribor"),
        new Oseba("Cvetka", "Cajzek", "Leva 3, 3000 Celje"),
        new Oseba("Drago", "Debeljak", "Desna 4, 4000 Kranj"),
        new Oseba("Eva", "Erjavec", "Sprednja 5, 5000 Nova Gorica"),
        new Oseba("Franci", "Fink", "Zadnja 6, 6000 Koper"),
    };
	
    private static void napolni(Posiljka[] t) {
        Random random = new Random();

        for (int i = 0;  i < t.length;  i++) {
            Oseba naslovnik = OSEBE[random.nextInt(OSEBE.length)];
            String vsebina = String.format("To je vsebina posiljke %d.", i+1);
            int razdalja = random.nextInt(400) + 50;

            double kocka = random.nextDouble();
            if (kocka > 0.7) {
                t[i] = new Pismo(naslovnik, vsebina, razdalja);

            } else if (kocka > 0.3) {
                Oseba posiljatelj = OSEBE[random.nextInt(OSEBE.length)];
                t[i] = new PriporocenoPismo(naslovnik, vsebina, razdalja, posiljatelj);

            } else {
                vsebina += String.format("  Pozdravljen, %s!", naslovnik.toString());
                t[i] = new Telegram(naslovnik, vsebina);
            }
        }
    }



    private static void izpisiVse(Posiljka[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.printf("[%d. posiljka]:%n", (i + 1));
            System.out.print(t[i]);
			// System.out.print(t[i].toString());
            System.out.printf("Cena: %.2f EUR%n%n", t[i].cena());
        }
    }

    private static int najdrazjaPosiljka(Posiljka[] t) {
        int iMax = 0;
        for (int i = 1;  i < t.length;  i++) {
            if (t[i].cena() > t[iMax].cena()) {
                iMax = i;
            }
        }
        return iMax;
    }
	
	private static void pisma(Posiljka[] t) {
		
	}
	
    public static void main(String[] args) {

        Posiljka[] posiljke = new Posiljka[10];
        napolni(posiljke);

        System.out.println("-----------------------------------");
        System.out.println(" Vse posiljke: ");
        System.out.println("-----------------------------------");
        izpisiVse(posiljke);

        System.out.println("-----------------------------------");
        System.out.println(" Najdrazja posiljka: ");
        System.out.println("-----------------------------------");
        int iNaj = najdrazjaPosiljka(posiljke);
        System.out.printf("[ %d. posiljka ]%n", iNaj + 1);
        System.out.println(posiljke[iNaj]);

        System.out.println("-----------------------------------");
        System.out.println(" Pisma: ");
        System.out.println("-----------------------------------");
        pisma(posiljke);
    }
}

