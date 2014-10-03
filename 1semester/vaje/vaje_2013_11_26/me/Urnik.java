
import java.util.*;

public class Urnik {

    //-------------------------------------------------------------------------
    // GLAVNI ATRIBUTI
    //-------------------------------------------------------------------------

    /** najzgodnejša ura, ob kateri je mogoče pričeti pouk */
    private int uraOdprtja;

    /** ura, do katere mora biti pouk zaključen */
    private int uraZaprtja;

    /** Število dni v tednu, ko se pouk izvaja.  Predpostavimo, da se pouk
     * prične v ponedeljek in konča na dan (ponedeljek + stDni - 1). */
    private int stDni;

    /** imena predmetov */
    private String[] imenaPredmetov;

    /** razpored[i][j]: številka predmeta, ki se izvaja v uri (i + uraOdprtja)
     * na dan z indeksom j (0: ponedeljek, 1: torek, ...);
     * 0, če se v tistem terminu ne izvaja nič
     */
    private int[][] razpored;

    //-------------------------------------------------------------------------
    // ATRIBUTI, UPORABNI PRI IZPISU URNIKA
    //-------------------------------------------------------------------------

    /** imena dni v tednu */
    private static final String[] IMENA_DNI = {
        "ponedeljek", "torek", "sreda", "četrtek", "petek", "sobota", "nedelja"
    };

    /** širina prostorčka za izpis ure */
    private static final int SIRINA_URE = 3;

    /** širina prostorčka za izpis predmeta */
    private int sirinaPredmeta;

    //-------------------------------------------------------------------------
    // KONSTRUKTOR
    //-------------------------------------------------------------------------

    /** Izdela nov objekt razreda Urnik.
     * @param uraOdprtja najzgodnejša ura, ob kateri je mogoče pričeti pouk
     * @param uraZaprtja ura, do katere mora biti pouk zaključen
     * @param stDni število dni v tednu, ko se pouk izvaja
     * @param imenaPredmetov imena predmetov
     */
    public Urnik(int uraOdprtja, int uraZaprtja, int stDni, String[] imenaPredmetov) {
        this.uraOdprtja = uraOdprtja;
        this.uraZaprtja = uraZaprtja;
        this.stDni = stDni;
        this.imenaPredmetov = imenaPredmetov;
        this.razpored = new int[uraZaprtja - uraOdprtja][stDni];

        this.sirinaPredmeta = Math.max(maxDolzina(IMENA_DNI), maxDolzina(imenaPredmetov));
    }

    //-------------------------------------------------------------------------
    // METODE
    //-------------------------------------------------------------------------

    /** Če se podani termin ne prekriva z nobenim obstoječim terminom, doda
     * termin v urnik, v nasprotnem primeru pa ne naredi ničesar.
     *
     * @param termin  podatki o terminu:
     * <ul>
     *     <li> [0]: številka predmeta (od 1 naprej) </li>
     *     <li> [1]: številka dneva v tednu (1: ponedeljek; 2: torek; ...) </li>
     *     <li> [2]: ura začetka (0--23) </li>
     *     <li> [3]: trajanje v urah </li>
     * </ul>
     * @return `true', če je termin bilo mogoče dodati v urnik; `false' sicer
     */
    public boolean dodajTermin(int[] termin) {
        int stPredmeta = termin[0];
        int stDneva = termin[1];
        int uraZacetka = termin[2];
        int trajanje = termin[3];

        // preveri, ali se termin prekriva s katerim od obstoječih terminov;
        // če se, vrni `false'
        for (int i = 0;  i < trajanje;  i++) {
            if (this.razpored[uraZacetka - this.uraOdprtja + i][stDneva-1] > 0) {
                return false;
            }
        }

        // dodaj termin v urnik
        for (int i = 0;  i < trajanje;  i++) {
            this.razpored[uraZacetka - this.uraOdprtja + i][stDneva - 1] = stPredmeta;
        }
        return true;
    }

    /** Izpiše obremenitev po predmetih.
     */
    public void izpisiObremenitevPoPredmetih() {
        int[] obremenitev = this.obremenitevPoPredmetih();
        System.out.println("Obremenitev po predmetih:");
        for (int p = 0;  p < this.imenaPredmetov.length;  p++) {
            if (p > 0) System.out.print(" | ");
            System.out.printf("%s -> %d", this.imenaPredmetov[p], obremenitev[p]);
        }
        System.out.println();
        System.out.println();
    }

    /** Ustvari in vrne tabelo, v kateri element z indeksom `i' vsebuje
     * tedensko število ur predmeta z indeksom `i'.
     */
    private int[] obremenitevPoPredmetih() {
        int[] breme = new int[this.imenaPredmetov.length];
        for (int ura = 0;  ura < this.razpored.length;  ura++) {
            // for (int dan = 0;  dan < this.stDni;  dan++) {
			for (int dan = 0;  dan < razpored[ura].length;  dan++) {
                int stPredmeta = this.razpored[ura][dan];
                if (stPredmeta > 0) {
                    breme[stPredmeta - 1]++;
                }
            }
        }
        return breme;
    }

    /** Za vsak dan izpiše, koliko ur imajo študentje na voljo za kosilo v menzi.
     * @param uraZacetkaStrezbe ura, ko menza prične streči kosila
     * @param uraKoncaStrezbe ura, ko menza zaključi s strežbo kosil
     */
    public void izpisiCasZaKosilo(int uraZacetkaStrezbe, int uraKoncaStrezbe) {
        int[] casZaKosilo = this.casZaKosilo(uraZacetkaStrezbe, uraKoncaStrezbe);
        System.out.println("Število ur za kosilo:");
        for (int dan = 0;  dan < this.stDni;  dan++) {
            if (dan > 0) System.out.print(" | ");
            System.out.printf("%s -> %d", IMENA_DNI[dan], casZaKosilo[dan]);
        }
        System.out.println();
        System.out.println();
    }

    /** Ustvari in vrne tabelo, v kateri element z indeksom `i' vsebuje število ur,
     * ki jih imajo študentje na voljo za kosilo v menzi v dnevu z indeksom `i'.
     * @param uraZacetkaStrezbe ura, ko menza prične streči kosila
     * @param uraKoncaStrezbe ura, ko menza zaključi s strežbo kosil
     */
    private int[] casZaKosilo(int uraZacetkaStrezbe, int uraKoncaStrezbe) {
        int[] casPoDnevih = new int[this.stDni];
        for (int dan = 0;  dan < this.stDni;  dan++) {
            int cas = 0;
            for (int ura = uraZacetkaStrezbe;  ura < uraKoncaStrezbe;  ura++) {
                if (this.razpored[ura - this.uraOdprtja][dan] == 0) {
                    cas++;
                }
            }
            casPoDnevih[dan] = cas;
        }
        return casPoDnevih;
    }

    /** Izpiše podatke o vrzelih po posameznih dneh.
     */
    public void izpisiVrzeli() {
        System.out.println("Vrzeli:");
        int razpon = this.uraZaprtja - this.uraOdprtja;

        for (int dan = 0;  dan < this.stDni;  dan++) {
            System.out.print(IMENA_DNI[dan] + ":");
            int uraZacVrzeli = 0;  // ura začetka trenutne vrzeli
            boolean vVrzeli = false;

            for (int ura = 1;  ura < razpon;  ura++) {
                if (!vVrzeli && this.razpored[ura-1][dan] > 0 && 
                                this.razpored[ura][dan] == 0) {
                    vVrzeli = true;
                    uraZacVrzeli = ura + this.uraOdprtja;

                } else if (vVrzeli && this.razpored[ura-1][dan] == 0 && 
                                      this.razpored[ura][dan] > 0) {
                    vVrzeli = false;
                    System.out.printf("  %d--%d", uraZacVrzeli, ura + this.uraOdprtja);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
	
    /** Izpiše urnik. 
     */
    public void izpisi() {
        // Metoda najprej zgradi objekt razreda StringBuilder (`raztegljiv
        // niz') in vanj po vrsticah zapiše celoten videz urnika, nato pa
        // vsebino niza izpiše na zaslon.  Sestavljanje nizov s pomočjo
        // objekta StringBuilder je učinkovitejše od sestavljanja s pomočjo
        // operatorja +.

        // ločilna črta (+----+--------------+--------------+...)
        String crta = this.crta();

        // ločilna črta, glava, ločilna črta, ločilna črta
        StringBuilder builder = new StringBuilder();
        builder.append(crta);
        String[] imenaDni = Arrays.copyOfRange(IMENA_DNI, 0, this.stDni);
        builder.append(this.vrstica("Ura", '|', imenaDni));
        builder.append(crta);
        builder.append(crta);

        // posamezne vrstice urnika, ločene z ločilnimi črtami
        for (int ura = 0;  ura < this.razpored.length;  ura++) {
            String vrstica = this.vrstica(
                    Integer.toString(ura + this.uraOdprtja),
                    '|', 
                    this.imenaPredmetovVVrstici(this.razpored[ura]) );
            builder.append(vrstica);
            builder.append(crta);
        }

        // izpiše niz, ki smo ga zgradili
        System.out.println(builder.toString());
    }
	
	
    /** Zgradi in vrne ločilno črto v urniku 
     * (niz oblike +----+--------------+--------------+...).
     */
    private String crta() {
        String[] t = new String[IMENA_DNI.length];
        Arrays.fill(t, nZnakov('-', this.sirinaPredmeta));
        return this.vrstica(nZnakov('-', SIRINA_URE), '+', t);
    }

    /** Zgradi in vrne eno vrstico urnika (glavo ali vrstico z urami).
     * @param ura besedilo v prostorčku za uro
     * @param locilo ločilo med prostorčki
     * @param polja besedilo v prostorčkih za posamezne dni
     */
    private String vrstica(String ura, char locilo, String[] polja) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(locilo + "%" + SIRINA_URE + "s", ura));
        for (int i = 0;  i < this.stDni;  i++) {
            builder.append(
                    String.format(locilo + "%-" + this.sirinaPredmeta + "s", polja[i]) );
        }
        builder.append(String.format("%c%n", locilo));
        return builder.toString();
    }

    /** Na podlagi tabele številk predmetov ustvari in vrne tabelo imen predmetov.
     */
    private String[] imenaPredmetovVVrstici(int[] vrsticaUrnika) {
        String[] imena = new String[vrsticaUrnika.length];
        for (int dan = 0;  dan < this.stDni;  dan++) {
            int st = vrsticaUrnika[dan];
            imena[dan] = (st == 0) ? ("") : (this.imenaPredmetov[st-1]);
        }
        return imena;
    }

    /** Vrne dolžino najdaljšega niza v podani tabeli.
     */
    private static int maxDolzina(String[] nizi) {
        int m = 0;
        for (int i = 0;  i < nizi.length;  i++) {
            m = Math.max(m, nizi[i].length());
        }
        return m;
    }

    /** Vrne niz, sestavljen iz `n' ponovitev znaka `znak'.
     */
    private static String nZnakov(char znak, int n) {
        StringBuilder builder = new StringBuilder(n);
        for (int i = 0;  i < n;  i++) {
            builder.append(znak);
        }
        return builder.toString();
    }
}

