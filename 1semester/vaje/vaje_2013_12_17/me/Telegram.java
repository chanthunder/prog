
public class Telegram extends Posiljka {

    private static final double CENA_ZA_CRKO = 0.2;

	public Telegram(Oseba naslovnik, String vsebina) {
		super(naslovnik, vsebina);
	}
	
	public String vrsta() {
		return "Telegram";
	}
	
	public double cena() {
		String vsebina = getVsebina();
		int stCrk = 0;
		for (int i = 0; i < vsebina.length(); i++) {
			if (Character.isLetter(vsebina.charAt(i)))
				stCrk++;
		}
		return (stCrk * CENA_ZA_CRKO);
	}
}
