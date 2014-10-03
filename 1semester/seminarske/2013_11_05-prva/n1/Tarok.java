public class Tarok {

    public static void main(String[] args) {
        // stevilo partij
        System.out.println("Vnesite maksimalno število partij: ");
		int n = BranjePodatkov.preberiInt();
        // zgornja meja točk
        System.out.println("Vnesite zgornjo mejo števila točk: ");
		int t = BranjePodatkov.preberiInt();
        // verjetnost zmage v posamezni partiji
        System.out.println("Vnesite verjetnost zmage v posamezni partij: ");
		double p = BranjePodatkov.preberiDouble();
        int tockeA = 0;
        int tockeB = 0;
        int tockeC = 0;
        int odigranih = 1;
        int predznak = 0;
        char pred = '?';
        boolean odigranaena = false;
        boolean odigranadva = false;
        boolean odigranatri = false;


        System.out.printf("%15s %5s %5s  %5s%n","", "A", "B", "C");
        System.out.printf("%15s %19s%n", "", "================");
        System.out.printf("%15s %5d %5d  %5d%n","", tockeA, tockeB, tockeC);
        while (odigranih <= n && najvecjeSteviloTock(tockeA, tockeB, tockeC) <= t) {
            int akter = (int)(Math.random() * 3) + 1;
            int igra = (int)(Math.random() * 3) + 1;
            if (igra == 1) {
                odigranaena = true;
            } else if (igra == 2) {
                odigranadva = true;
            } else {
                odigranatri = true;
            }
            int razlika = (int)(Math.random() * 8) * 5;
            double nakljucnaZmaga = Math.random();
            if (zmaga(nakljucnaZmaga, p)) {
                predznak = 1;
                pred = '+';
            } else {
                predznak = -1;
                pred = '-';
            } 
            System.out.printf("%1s%1d%1s %3s %1s %1s%1d%n","[", odigranih, "]", igra(igra), akter(akter), pred, razlika);
            /* switch (akter) { */
            /*     case 1: */
            /*         tockeA += ((vrednostIgre(igra)+razlika)*predznak); */
            /*     case 2: */
            /*         tockeB += ((vrednostIgre(igra)+razlika)*predznak); */
            /*     case 3: */
            /*         tockeC += ((vrednostIgre(igra)+razlika)*predznak); */
            /*     default: */
            /*         igra += 0; */
            /* } */
            if (akter == 1) {
                tockeA += ((vrednostIgre(igra)+razlika)*predznak);
            } else if (akter == 2) {
                tockeB += ((vrednostIgre(igra)+razlika)*predznak);
            } else if (akter == 3) {
                tockeC += ((vrednostIgre(igra)+razlika)*predznak);
            } else {
                System.out.println("Napaka spremenljivka akter ne ustreza vrednostim");
            } 
            System.out.printf("%15s %5d %5d  %5d%n","", tockeA, tockeB, tockeC);
            odigranih+=1;
        }
        if (tockeA ==  najvecjeSteviloTock(tockeA, tockeB, tockeC) && tockeA != tockeB && tockeA != tockeC) {
            System.out.println("Zmagal je igralec " + akter(1) + ", ki je zbral " + tockeA + " tock.");
        } else if (tockeB == najvecjeSteviloTock(tockeA, tockeB, tockeC) && tockeA != tockeB && tockeB != tockeC) {
            System.out.println("Zmagal je igralec " + akter(2) + ", ki je zbral " + tockeB + " tock.");
        } else if (tockeC == najvecjeSteviloTock(tockeA, tockeB, tockeC) && tockeC != tockeB && tockeA != tockeC) {
            System.out.println("Zmagal je igralec " + akter(3) + ", ki je zbral " + tockeC + " tock.");
        } else if (tockeA == tockeB)  {
            System.out.println("Zmagala sta igralca " + akter(1) + " in " + akter(2) + ", ki sta zbrala " + tockeA + " tock.");
        } else if (tockeB == tockeC)  {
            System.out.println("Zmagala sta igralca " + akter(2) + " in " + akter(3) + ", ki sta zbrala " + tockeB + " tock.");
        } else {
            System.out.println("Zmagala sta igralca " + akter(1) + " in " + akter(3) + ", ki sta zbrala " + tockeA + " tock.");
        } 
        System.out.println("Vsaj po enkrat odigrane igre");
        if (odigranatri) {
            System.out.println(igra(3));
        }
        if (odigranadva) {
            System.out.println(igra(2));
        }
        if (odigranaena) {
            System.out.println(igra(1));
        }
    }

    private static String igra(int igra) {
        switch (igra) {
            case 1:
                return "ena";
            case 2:
                return "dva";
            case 3:
                return "tri";
            default:
                return "";
        }
    }


    private static String akter(int akter) {
        switch (akter) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            default:
                return "";
        }
    }

    private static int vrednostIgre(int igra) {
        switch (igra) {
            case 1:
                return 30;
            case 2:
                return 20;
            case 3:
                return 10;
            default:
                return 0;
        }
    }

    public static int najvecjeSteviloTock(int tockeA, int tockeB, int tockeC) {
        return Math.max(Math.max(tockeA,tockeB),tockeC);
    }

    public static boolean zmaga(double nakljucnaZmaga, double p) {
        if (nakljucnaZmaga <= p) {
            return true;
        } else {
            return false;
        }
    }

}

