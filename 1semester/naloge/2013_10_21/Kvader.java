
public class Kvader {

	public static void main(String[] args) {
        Kvader o = new Kvader();
        int v = o.getNumberAndValidate("Vnesite sirino kvadra: ");
        int s = o.getNumberAndValidate("Vnesite visino kvadra: ");
        int g = o.getNumberAndValidate("Vnesite globino kvadra: ");
        char zvezdica = '*';
        char presledek = ' ';
        for (int i = 0; i < g / 2; i++) {
            String vrstica = narisi(g / 2 - i, presledek);
            if (i == 0) {
                vrstica += narisi(s + 1, zvezdica);
            } else {
                vrstica += String.valueOf(zvezdica);
                vrstica += narisi(s - 1, presledek);
                vrstica += String.valueOf(zvezdica);
                vrstica += narisi(i - 1, presledek);
                vrstica += String.valueOf(zvezdica);
            }
            System.out.println(vrstica);

        } 
        for (int i = 0; i < v + 1; i++) {
            String vrstica = "";
            if (i == 0) {
                vrstica += narisi(s+1
                
            }
        } 

	}

    public static String narisi(int ponovitev, char znak) {
        String dodaj = "";
        for (int i = 0; i < ponovitev; i++) {
            dodaj += znak;
        }
        return dodaj;
    }

    public int getNumberAndValidate(String sporocilo) {
        System.out.print(sporocilo);
        int n = BranjePodatkov.preberiInt();
        if (sporocilo.equals("Vnesite globino kvadra: ")) {
            if (n > 1) {
                return n;
            } else {
                System.out.println("Globina mora biti vsaj 2. Ponovite vnos.");
                return getNumberAndValidate(sporocilo);
            } 
        } 
        if (n > 0) {
            return n;
        } else {
            System.out.println("Stevilo ni naravno. Ponovite vnos.");
            return getNumberAndValidate(sporocilo);
        } 
    }

}
