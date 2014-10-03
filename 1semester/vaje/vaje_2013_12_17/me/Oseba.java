
public class Oseba {

    private String ime, priimek;
    private String naslov;

    public Oseba(String ime, String priimek, String naslov) {
        this.ime = ime;
        this.priimek = priimek;
        this.naslov = naslov;
    }

    public String toString() {
        return String.format("%s %s, %s", this.ime, this.priimek, this.naslov);
    }
}

