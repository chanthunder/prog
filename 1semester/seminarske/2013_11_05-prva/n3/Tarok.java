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
        int radelca = 0;
        int radelcb = 0;
        int radelcc = 0;


        System.out.printf("%21s  %5s    %5s     %5s  %n","", "A", "B", "C");
        System.out.printf("%21s   %21s%n", "", "=========================");
        System.out.printf("%21s %5d|%-2d %5d|%-2d  %5d|%-2d%n","", tockeA, radelca, tockeB, radelcb, tockeC, radelcc);
        while (odigranih <= n && najvecjeSteviloTock(tockeA, tockeB, tockeC) <= t) {
            int akter = (int)(Math.random() * 3) + 1;
            int igra = (int)(Math.random() * 4) + 1;
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
                if (radelca > 0) {
                    tockeA += ((vrednostIgre(igra)+razlika)*predznak*2);
                    if(zmaga(nakljucnaZmaga, p)) {
                        radelca -= 1;
                    }
                } else {
                    tockeA += ((vrednostIgre(igra)+razlika)*predznak);
                }
            } else if (akter == 2) {
                if (radelcb > 0) {
                    tockeB += ((vrednostIgre(igra)+razlika)*predznak*2);
                    if(zmaga(nakljucnaZmaga, p)) {
                        radelcb -= 1;
                    }
                } else {
                    tockeB += ((vrednostIgre(igra)+razlika)*predznak);
                }
            } else if (akter == 3) {
                if (radelcc > 0) {
                    tockeC += ((vrednostIgre(igra)+razlika)*predznak*2);
                    if(zmaga(nakljucnaZmaga, p)) {
                        radelcc -= 1;
                    }
                } else {
                    tockeC += ((vrednostIgre(igra)+razlika)*predznak);
                }
            } else {
                System.out.println("Napaka spremenljivka akter ne ustreza vrednostim");
            } 
            if (igra == 4) {
                radelca +=1;
                radelcb +=1;
                radelcc +=1;
            }
            System.out.printf("%21s %5d|%-2d %5d|%-2d  %5d|%-2d%n","", tockeA, radelca, tockeB, radelcb, tockeC, radelcc);
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
    }

    private static String igra(int igra) {
        switch (igra) {
            case 1:
                return "ena";
            case 2:
                return "dva";
            case 3:
                return "tri";
            case 4:
                return "brez talona";
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
            case 4:
                return 80;
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

