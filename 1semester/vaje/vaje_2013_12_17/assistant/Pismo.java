
public class Pismo extends Posiljka {

    private static final double ZACETNA_CENA = 3.0;
    private static final double POVECANJE = 2.0;
    private static final int OSNOVNA_RAZDALJA = 100;

    private int razdalja;

    public Pismo(Oseba naslovnik, String vsebina, int razdalja) {
        super(naslovnik, vsebina);
        this.razdalja = razdalja;
    }

    public double cena() {
        return ZACETNA_CENA + (this.razdalja / OSNOVNA_RAZDALJA) * POVECANJE;
    }

    public int getRazdalja() {
        return this.razdalja;
    }

    public String vrsta() {
        return "navadno pismo";
    }

    public String toString() {
        return (super.toString() + String.format("Razdalja: %d km%n", this.razdalja));
    }
}
