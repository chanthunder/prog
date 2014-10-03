
public class VrazeverniBoris {

	public static void main(String[] args) {
        boolean imaDenar = true;
        System.out.print("Vnesite stevilo dni: ");
        int steviloDni = BranjePodatkov.preberiInt();
        System.out.println();
        for (int i = 1; i<=steviloDni; i++) {
            boolean nedelja = false;
            int limit = 3;
            if (i%7==0) {
                limit = 5;
                nedelja = true;
            } 
            int lihih = 0;
            System.out.printf("%d. %s: ", i, "dan");
            int stevec = 0;
            while (lihih < limit) {
                int stevilo = ((int)(Math.random()*6)+1);
                System.out.printf("%d ", stevilo);
                if (stevilo%2 == 1) {
                    lihih++;
                } 
                stevec++;
            }
            System.out.printf("%s: %d %s %s%n", "| skupaj", stevec, "metov", nedelja ? "(nedelja)" : "");
        } 
	}

}
