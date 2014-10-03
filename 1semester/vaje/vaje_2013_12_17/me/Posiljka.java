
public abstract class Posiljka {

    private Oseba naslovnik;
	private String vsebina;
	
	protected Posiljka(Oseba naslovnik, String vsebina) {
		this.naslovnik = naslovnik;
		this.vsebina = vsebina;
	}
	
	public Oseba getNaslovnik() {
		return naslovnik;
	}
	
	public String getVsebina() {
		return vsebina;
	}
	
	public abstract String vrsta();
	
	public abstract double cena();
	
	public String toString() {
		return String.format("Vrsta: %s %nNaslovnik: %s %nVsebina: %s %n", vrsta(), naslovnik, this.vsebina);
	}
}

