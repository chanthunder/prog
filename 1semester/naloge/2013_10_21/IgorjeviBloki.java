
public class IgorjeviBloki {

	public static void main(String[] args) {
        IgorjeviBloki o = new IgorjeviBloki();
        int prva = o.getNumberAndValidate("prvo");
        int druga = o.getNumberAndValidate("drugo");
        int tretja = o.getNumberAndValidate("tretjo");

        for (int i = 0; i <= maksimum(maksimum(prva, druga), tretja); i++) {
            String vrstica = "";
            vrstica += nStevk(prva, i);
            vrstica += nStevk(druga, i);
            vrstica += nStevk(tretja, i);
            System.out.println(vrstica);
        } 
	}

    public static String nStevk(int ponovitev, int stevec) {
        String dodaj = "";
        if (ponovitev > stevec) { 
            for (int i = 0; i < ponovitev; i++) {
                dodaj += ponovitev;
            }
        } else {
            for (int i = 0; i < ponovitev; i++) {
                dodaj += " ";
            }
        }
        dodaj += " ";
        return dodaj;
    }

    public static int maksimum(int i, int j) {
        return (i > j) ? i : j;
    }
    public int getNumberAndValidate(String stevka) {
        System.out.printf("%s %s %s: ", "Vnesite", stevka, "stevko");
        int n = BranjePodatkov.preberiInt();
        if (n > 0 && n < 10) {
            return n;
        } else {
            System.out.println("Stevilo ni stevka. Ponovite vnos.");
            return getNumberAndValidate(stevka);
        } 
    }

}
