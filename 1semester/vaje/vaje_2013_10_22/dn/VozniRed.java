public class VozniRed {

    public static void main(String[] args) {

        System.out.print("Ura zacetka voznje: ");
        int uraZacetka = BranjePodatkov.preberiInt();
        System.out.print("Minuta zacetka voznje: ");
        int minutaZacetka = BranjePodatkov.preberiInt();
        System.out.print("Ura konca voznje: ");
        int uraKonca = BranjePodatkov.preberiInt();
        System.out.print("Minuta konca voznje: ");
        int minutaKonca = BranjePodatkov.preberiInt();
        System.out.print("Interval (v minutah): ");
        int interval = BranjePodatkov.preberiInt();

				int zacetek = uraZacetka*60 + minutaZacetka;
				int konec = uraKonca*60 + minutaKonca;
        int trenutniCas = zacetek;

        while (trenutniCas <= konec) {
					int ostanek = trenutniCas % 60;
					if (ostanek < 10) {
						System.out.print(trenutniCas/60 + ":0" + ostanek);
					} else {	
						System.out.print(trenutniCas/60 + ":" + ostanek);
					}
					if (trenutniCas + interval < konec)
						System.out.print(", ");
								trenutniCas += interval;
        }
        System.out.println();
    }
}
