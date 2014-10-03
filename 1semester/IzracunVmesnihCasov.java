public class IzracunVmesnihCasov {

	public static void main(String[] args) {
		System.out.println("Vnesi stevilo vmesnih casov: ");
		int n = BranjePodatkov.preberiInt();
        /* prejsna razdalja */
		double pr = 0;
        double cas = 0;
        double povprecje = 0;
		for (int i = 1; i <= n;i++ ) {
		    System.out.println("Vnesi razdaljo: ");
		    int r = BranjePodatkov.preberiInt();
            /* cas v minutah */
		    System.out.println("Vnesi cas v minutah: ");
		    double cm = BranjePodatkov.preberiInt();
		    System.out.println("Vnesi cas v sekundah: ");
            /* cas v sekundah */
		    double cs = BranjePodatkov.preberiInt();
            cas = cm * 60 + cs;
            povprecje = r / cas;
            pr = r - pr;
            System.Out.Println(pr + "km ste preketli v " + cm + "min " + cs + "sekundah " + "s tempom " + povprecje + "na minuto");
            }
		}	
	}
}
