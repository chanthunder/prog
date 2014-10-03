
public class Oseba {

    private String ime, priimek;
    private int starost;
    private Naslov naslov;
    private Oseba[] prijatelji;

    public Oseba(String ime, String priimek, int starost, Naslov naslov) {
        this.ime = ime;
        this.priimek = priimek;
        this.starost = starost;
        this.naslov = naslov;
        this.prijatelji = new Oseba[0];
    }

    public void nastaviPrijatelje(Oseba[] prijatelji) {
        this.prijatelji = prijatelji;
    }

    /** 
     * Vrne niz sledeče oblike:
     * 
     * ime priimek (starost), naslov
     *
     * Na primer: Jože Gorišek (56), Gasilska 15, 2342 Ruše
     */
    public String toString() {
		return String.format("%s %s (%d), %s", this.ime, this.priimek, this.starost, this.naslov.toString());
    }

    /** 
     * Vrne imena prijateljev osebe `this' v oglatih oklepajih, ločena z
     * vejicami.  Na primer: [Milena, Lojze, Zvonko]
     */
    public String imenaPrijateljev() {
        String p = "[";
        for (int i = 0;  i < this.prijatelji.length;  i++) {
            if (i > 0) {
                p += ", ";
            }
            p += this.prijatelji[i].ime;
        }
        return (p + "]");
		// učinkovitejša rešitev: StringBuilder
    }

    /**
     * Vrne `true' natanko v primeru, če oseba `os' prebiva na istem naslovu
     * kot oseba `this'.
     */
    private boolean naIstemNaslovuKot(Oseba os) {
		return this.naslov.jeEnakKot(os.naslov);
    }

    /**
     * Izpiše podatke o prijateljih osebe `this', ki živijo na istem naslovu
     * kot oseba `this'.
     */
    public void prijateljiNaIstemNaslovu() {
		for (int i = 0;  i < this.prijatelji.length;  i++) {
			if (this.prijatelji[i].naIstemNaslovuKot(this)) {
				System.out.println(this.prijatelji[i].toString());
			}
		}
    }

    /**
     * Vrne najstarejšega prijatelja osebe `this'.
     */
    public Oseba najstarejsiPrijatelj() {
		if (this.prijatelji.length == 0) {
			return null;
		}
		// poišči indeks najstarejšega prijatelja
		int iNaj = 0;
		for (int i = 1;  i < this.prijatelji.length;  i++) {
			if (this.prijatelji[i].starost > this.prijatelji[iNaj].starost) {
				iNaj = i;
			}
		}
		return this.prijatelji[iNaj];
    }

    /**
     * Vrne `true' natanko v primeru, če je oseba `this' prijatelj osebe `os'.
     */
    private boolean jePrijateljOd(Oseba os) {
		for (int i = 0;  i < os.prijatelji.length;  i++) {
			if (os.prijatelji[i] == this) {
				return true;
			}
		}
        return false;
    }

    /**
     * Vrne matriko prijateljstev za dano tabelo oseb.  Velikost matrike naj
     * bo enaka n x n, kjer je `n' dolžina tabele `osebe'.  Element na
     * poziciji (i, j) naj ima vrednost `true' natanko v primeru, če je oseba
     * z indeksom `j' prijatelj osebe z indeksom `i'.
     */
    public static boolean[][] prijateljstva(Oseba[] osebe) {
        boolean[][] p = new boolean[osebe.length][osebe.length];
		for (int i = 0;  i < osebe.length;  i++) {
			for (int j = 0;  j < osebe.length;  j++) {
				p[i][j] = osebe[j].jePrijateljOd(osebe[i]);
			}
		}
		return p;
    }
}
