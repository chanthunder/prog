public class VozniRedInPot {

    public static void main(String[] args) {

        /*
        System.out.println("Zacetek voznje (v formatu ab:cd): ");
        String[] zacetek = (BranjePodatkov.preberiString()).split(":");
        System.out.println("Konec voznje (v formatu ab:cd): ");
        String[] konec = (BranjePodatkov.preberiString()).split(":");
        int zacetekVMinutah = Integer.parseInt(zacetek[0]) * 60 + Integer.parseInt(zacetek[1]);
        int konecVMinutah = Integer.parseInt(konec[0]) * 60 + Integer.parseInt(konec[1]);
        int steviloPostaj = BranjePodatkov.preberiInt();
        int interval = BranjePodatkov.preberiInt();
        int spremembaIntervala = BranjePodatkov.preberiInt();
        if (konecVMinutah < zacetekVMinutah + interval) {
            System.out.println("Casovna razlika med zacetkom in koncem je neustrezna: ");
            System.exit(1);
        }
        System.out.println(zacetekVMinutah + " " +konecVMinutah);
        */
        int uraZacetka = 5;
        int minutaZacetka = 30;
        int zacetek = uraZacetka * 60 + minutaZacetka;

        int uraKonca = 22;
        int minutaKonca = 10;
        int konec = uraKonca * 60 + minutaKonca;

        int interval = 45;
        int spremembaIntervala = 20;
        int steviloPostaj = 10;
        int casPrehodaMedPostajami = 50;

        izpisiVozniRed(zacetek, konec, steviloPostaj, interval, spremembaIntervala);
        prehodPotnika(zacetek, konec, steviloPostaj, interval, spremembaIntervala, casPrehodaMedPostajami);
        
        if (konec < zacetek + interval) {
            System.out.println("Casovna razlika med zacetkom in koncem je neustrezna: ");
            System.exit(1);
        }
    }
    public static void prehodPotnika(int zacetek, int konec, int steviloPostaj, int interval, int spremembaIntervala, int casPrehodaMedPostajami) {
        System.out.print("Ura prihoda potnika (v formatu ab:cd): ");
        String[] prihodPotnika = (BranjePodatkov.preberiString()).split(":");
        int prihodPotnikaVMinutah = Integer.parseInt(prihodPotnika[0]) * 60 + Integer.parseInt(prihodPotnika[1]);
        System.out.printf("%n%s", "Vnesite zacetno postajo: ");
        int zacetnaPostaja = BranjePodatkov.preberiInt();
        System.out.printf("%n%s", "Vnesite koncno postajo: ");
        int koncnaPostaja = BranjePodatkov.preberiInt();
        int trenutnoStanje = prihodPotnikaVMinutah;
        if (koncnaPostaja - zacetnaPostaja <= 0) {
            System.out.println("Ne morete potovati nazaj");
            System.exit(1);
        } 
        if (prihodPotnikaVMinutah <= zacetek) {
            System.out.printf("%s %d %s %d:%02d.", "S postaje", zacetnaPostaja, "krene ob", pretvoriVUre(zacetek),pretvoriVMinute(zacetek));
            trenutnoStanje = zacetek + casPrehodaMedPostajami;
            System.out.printf(" %s %d %s %d:%02d.%n", "Na postajo", zacetnaPostaja+1, "pride ob", pretvoriVUre(trenutnoStanje),pretvoriVMinute(trenutnoStanje));
        }
        for (int i = zacetnaPostaja; i<koncnaPostaja; i++) {
            int pogoj = trenutnoStanje + interval + spremembaIntervala*(i-1);
            if (pogoj <= konec) {
                for (int j = zacetek;j <= konec;j+=interval + spremembaIntervala*(i-1) ) {
                    if (j >= trenutnoStanje) {
                        System.out.printf("%s %d %s %d:%02d.", "S postaje", i, "krene ob", pretvoriVUre(j),pretvoriVMinute(j));
                        trenutnoStanje=j+casPrehodaMedPostajami;
                        System.out.printf(" %s %d %s %d:%02d.%n", "Na postajo", i+1, "pride ob", pretvoriVUre(trenutnoStanje),pretvoriVMinute(trenutnoStanje));
                        j=konec+1;
                    } 
                }

            } else {
                System.out.println("S postaje " + i + " ne pelje noben vlak vec.");
                break;
            }
        }


    }
    public static int pretvoriVUre(int cas) {
        return cas/60;
    }
    public static int pretvoriVMinute(int cas) {
        return cas % 60;
    }
    public static void izpisiVozniRed(int zacetek, int konec, int steviloPostaj, int interval, int spremembaIntervala) {
        for (int i = 1;i <= steviloPostaj;i++) {
            System.out.print("    " + i + "  ");
        } 
        System.out.println();
        for (int j = 1;j < steviloPostaj;j++) {
            System.out.printf("  %2d:%2d", zacetek/60, zacetek%60);
        } 
        System.out.println();

        int trenutniCas = zacetek;
        while (trenutniCas + interval <= konec) {
            for (int k = 0; k < steviloPostaj; k++) {
                int pogoj = trenutniCas + interval + spremembaIntervala*k;
                if (pogoj <= konec) { 
                    System.out.printf("  %2d:%02d", pogoj/60, pogoj%60);
                } else {
                    k = steviloPostaj;
                }
            }
                System.out.println();
                trenutniCas += interval;

        }
    }
}
