
public class Golaz {

	public static void main(String[] args) {
        boolean imaDenar = true;
        System.out.print("Vnesite zacetno zalogo denarja: ");
        int zaloga = BranjePodatkov.preberiInt();
        System.out.println();
        while (imaDenar) {
            System.out.print("Vnesite ceno kosila: ");
            double cena = BranjePodatkov.preberiDouble();
            System.out.print("Vnesite stevilo kosil: ");
            int stevilo = BranjePodatkov.preberiInt();
            System.out.print("So gostje naročili vino (1: da / 2: ne)? ");
            boolean enadva = true;
            boolean vino = false;
            while (enadva) {
            int vinoInt = BranjePodatkov.preberiInt();
                if (vinoInt == 1) {
                    enadva = false;
                    vino = true;
                } else if (vinoInt == 2) {
                    enadva = false;
                } else {
                    System.out.println("Stevilo ni 1 ali 2. Ponovite vnos");
                }
            }
            double pogostitev = (double)cenaPogostitve(cena, stevilo, vino);
            System.out.printf("%s %.2f %s.%n", "Skupna cena pogostitve znasa", pogostitev, "EUR");
            if (zaloga - pogostitev >= 0) { 
                if (zaloga - pogostitev == 0) {
                    imaDenar = false;
                }
                System.out.printf("%s %.2f %s.%n%n", "Trenutna zaloga denarja znasa", (zaloga - pogostitev),"EUR");
            } else {
                imaDenar = false;
                System.out.println("Zmanjkalo je denarja!");
            }


        }
	}
    private static double cenaPogostitve(double cenaKosila, int stKosil, boolean vino) {
        if (vino) {
            return cenaKosila*stKosil*1.5;
        } else {
            return cenaKosila*stKosil;
        } 
    }

}
