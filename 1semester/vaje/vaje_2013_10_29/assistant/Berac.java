/*
Berač se usede na pločnik živahne ulice in predse pomoli svoj klobuk.  Po
ulici se poleg domačinov sprehaja tudi veliko angleških in ameriških turistov.
Domačini beraču v klobuk mečejo evre, Angleži in Američani pa funte oziroma
dolarje.  Berač zaključi svoj dnevni "šiht", ko zbere denar v vrednosti 50
evrov.  Ker ne zna preračunavati funtov in dolarjev v evre, mu moramo
pomagati.

Napišite program, ki simulira potek beračevega "šihta".  Za vsakega
mimoidočega naključno izberite številko valute (0: evro, 1: funt, 2: dolar) in
podarjeni znesek (celo število med 1 in vključno 5). Sproti izpisujte prejemke
in količino denarja v beračevem klobuku v evrih.

V programu napišite in uporabite sledeči metodi:

-- private static String oznakaValute(int valuta):
   Ta metoda vrne oznako valute za podano številko valute 
   (0 --> "EUR", 1 --> "GBP", 2 --> "USD").

-- private static double preracunajVEvre(double znesek, int valuta):
   Ta metoda vrne znesek v evrih, ki ustreza podanemu znesku v podani valuti.
   Na primer, klic preracunajVEvre(2.7, 1) vrne vrednost v evrih, ki ustreza
   znesku 2.7 GBP.

Primer izpisa:

   Prejemek      Klobuk
--------------------------
      3 EUR    3.00 EUR
      4 GBP    7.63 EUR
      3 USD    9.80 EUR
      4 GBP   14.43 EUR
      1 USD   15.16 EUR
      2 GBP   17.47 EUR
      4 GBP   22.10 EUR
      3 USD   24.27 EUR
      1 EUR   25.27 EUR
      4 USD   28.17 EUR
      4 USD   31.06 EUR
      2 GBP   33.37 EUR
      5 USD   36.99 EUR
      5 EUR   41.99 EUR
      2 GBP   44.30 EUR
      4 USD   47.20 EUR
      5 GBP   52.99 EUR
*/

public class Berac {

    // koliko EUR ustreza eni enoti tuje valute
    private static final double TECAJ_USD = 0.73;
    private static final double TECAJ_GBP = 1.18;

    // ciljni znesek v klobuku (v EUR)
    private static final double CILJNI_ZNESEK = 50.0;

    //-------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.printf("%11s %11s%n", "Prejemek", "Klobuk");
        System.out.println("--------------------------");
		
		double klobuk = 0.0;  // trenutna vrednost v klobuku v EUR
		while (klobuk < CILJNI_ZNESEK) {
			// naključno izberi številko valute in prejemek
			int valuta = (int) (Math.random() * 3);
			int prejemek = (int) (Math.random() * 5) + 1;
			
			// preračunaj prejemek v evre
			double prejemekEUR = preracunajVEvre(prejemek, valuta);
			
			// dodaj prejemek v klobuk
			klobuk += prejemekEUR;
			
			// izpiši trenutno stanje
			String oznaka = oznakaValute(valuta);
            System.out.printf("%7d %s %7.2f EUR%n", prejemek, oznaka, klobuk);
		}
    }

    //-------------------------------------------------------------------------
    /* Vrne oznako valute za podano številko valute (0 --> "EUR", 1 --> "GBP",
     * 2 --> "USD"). */
    //-------------------------------------------------------------------------
    private static String oznakaValute(int valuta) {
		switch (valuta) {
			case 0: return "EUR";
			case 1: return "GBP";
			case 2: return "USD";
		}
		return "";  // neznana valuta
    }

    //-------------------------------------------------------------------------
    /* Vrne znesek v evrih, ki ustreza podanemu znesku v podani valuti. */
    //-------------------------------------------------------------------------
    private static double preracunajVEvre(double znesek, int valuta) {
		switch (valuta) {
			case 0: return znesek;
			case 1: return (TECAJ_GBP * znesek);
			case 2: return (TECAJ_USD * znesek);
		}
		return znesek;  // neznana valuta
    }
}
