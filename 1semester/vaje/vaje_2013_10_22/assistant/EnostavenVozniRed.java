// poenostavljen avtobusni vozni red

// Vozni red – začne se na polno uro, konča se na polno uro in presledki so tudi polne ure.
// Denimo, da mestni avtobus na neki progi vozi v enakomernih presledkih.  Napišite 
// program, ki prebere čas začetka in čas konca voženj ter interval v urah (npr. 2 uri), 
// nato pa izpiše dnevni vozni red.

// Primer: 	začetek = 10, konec = 14, interval = 2 uri	==> 
//          izpis: 10:00, 12:00, 14:00


public class EnostavenVozniRed {

    public static void main(String[] args) {

        System.out.print("Ura zacetka voznje: ");
        int uraZacetka = BranjePodatkov.preberiInt();
        System.out.print("Ura konca voznje: ");
        int uraKonca = BranjePodatkov.preberiInt();
        System.out.print("Interval (v urah): ");
        int interval = BranjePodatkov.preberiInt();

        int trenutnaUra = uraZacetka;

        while (trenutnaUra <= uraKonca) {
            System.out.print(trenutnaUra + ":00");
			if (trenutnaUra + interval < koncnaUra)
				System.out.print(", ");
            trenutnaUra += interval;
        }
        System.out.println();
    }
}
