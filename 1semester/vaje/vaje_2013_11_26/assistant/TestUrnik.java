
public class TestUrnik {

    private static final int URA_ODPRTJA = 7;
    private static final int URA_ZAPRTJA = 22;
    private static final int ST_DNI = 5;

    private static final int URA_ZACETKA_STREZBE = 12;
    private static final int URA_KONCA_STREZBE = 14;

    private static final String[] PREDMETI = {
        "Analiza", "Diskretne", "Fizika", "Programiranje", "Vezja"
    };

    public static void main(String[] args) {
        Urnik urnik = new Urnik(URA_ODPRTJA, URA_ZAPRTJA, ST_DNI, PREDMETI);
        izpisiVse(urnik);

        while (true) {
            System.out.print("Vnesite termin: ");
            int[] vnos = BranjePodatkov.preberi1i();
            if (vnos.length == 1 && vnos[0] == -1) {
                break;
            }

            if (!preveriVnos(vnos)) {
                System.out.println("Neveljaven vnos!");
                System.out.println();

            } else if (urnik.dodajTermin(vnos)) {
                izpisiVse(urnik);

            } else {
                System.out.println("Termina zaradi prekrivanja ni mogoče dodati.");
                System.out.println();
            }
        }
    }

    private static boolean preveriVnos(int[] vnos) {
        return (vnos.length == 4 &&
                vnos[0] >= 1 && vnos[0] <= PREDMETI.length &&
                vnos[1] >= 1 && vnos[1] <= ST_DNI &&
                vnos[2] >= URA_ODPRTJA && vnos[2] < URA_ZAPRTJA &&
                vnos[3] >= 1 && vnos[2] + vnos[3] <= URA_ZAPRTJA);
    }

    private static void izpisiVse(Urnik urnik) {
        urnik.izpisi();
        urnik.izpisiObremenitevPoPredmetih();
        urnik.izpisiCasZaKosilo(URA_ZACETKA_STREZBE, URA_KONCA_STREZBE);
        urnik.izpisiVrzeli();
    }
}

