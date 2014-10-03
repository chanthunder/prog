
public class PriporocenoPismo extends Pismo {

    public static final double PRIPOROCNINA = 2.5;

    private Oseba posiljatelj;

    public PriporocenoPismo(Oseba naslovnik, String vsebina, int razdalja, Oseba posiljatelj) {
        super(naslovnik, vsebina, razdalja);
        this.posiljatelj = posiljatelj;
    }

    public double cena() {
        return super.cena() + PRIPOROCNINA;
    }

    public String vrsta() {
        return "priporoceno pismo";
    }

    public String toString() {
        return String.format("%sPosiljatelj: %s%n", 
                super.toString(), this.posiljatelj.toString());
    }

    public Pismo povratnica() {
        return new Pismo(this.posiljatelj, "povratnica", this.getRazdalja());
    }
}
