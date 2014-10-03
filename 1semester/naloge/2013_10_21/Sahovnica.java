
public class Sahovnica {

	public static void main(String[] args) {
        Sahovnica o = new Sahovnica();
        int v = o.getNumberAndValidate("Vnesite stevilo vrstic: ");
        int s = o.getNumberAndValidate("Vnesite stevilo stolpcev: ");
        int d = o.getNumberAndValidate("Vnesite dolzino stranice polja: ");
        String pipe = "|";
        char plus = '+';
        char minus = '-';
        char zvezdica = '*';
        char presledek = ' ';
        System.out.printf("%s%s%s%n",plus,narisi(s*d,minus),plus);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < d; j++) {
                String vrstica = pipe;
                for (int k = 0; k < s; k++) {
                    if (i%2 == 0 && k%2 == 0 || i%2 == 1 && k%2 == 1) {
                        vrstica += narisi(d, presledek);
                    } else {
                        vrstica += narisi(d, zvezdica);
                    }
                } 
                vrstica += pipe;
                System.out.println(vrstica);
            } 
        } 
        System.out.printf("%s%s%s%n",plus,narisi(s*d,minus),plus);

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
        if (n > 0) {
            return n;
        } else {
            System.out.println("Stevilo ni naravno. Ponovite vnos.");
            return getNumberAndValidate(sporocilo);
        } 
    }

}
