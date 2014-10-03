
public class Naslov {
    private String ulica;
    private int postnaStevilka;
    private String posta;

    public Naslov(String ulica, int postnaStevilka, String posta) {
        this.ulica = ulica;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    /** 
     * Vrne niz sledeče oblike:
     * 
     * ulica, poštnaŠtevilka pošta
     *
     * Na primer: Gasilska 15, 2342 Ruše
     */
    public String toString() {
        // ...
        return this.ulica + Integer.toString(this.postnaStevilka) + ", " + this.posta;
    }

    /** 
     * Vrne `true' natanko v primeru, če objekt `n' predstavlja enak naslov
     * kot objekt `this'.  Ni nujno, da gre za isti objekt; metoda naj vrne
     * `true' tudi v primeru, če sta objekta `n' in `this' različna, vendar pa
     * imata enake vrednosti atributov.
     */
    public boolean jeEnakKot(Naslov n) {
        return ulica.equals(n.ulica) && postnaStevilka == n.postnaStevilka && posta.equals(n.posta);
        // ...
    }
}

