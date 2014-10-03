public class Zaporedja {

	public static void main(String[] args) {  

		System.out.println("Vnesi zacetno stevilo: ");
		int a = BranjePodatkov.preberiInt();
		System.out.println("Vnesi koncno mejo: ");
		int b = BranjePodatkov.preberiInt();
		System.out.println("Vnesi korak: ");
		int k = BranjePodatkov.preberiInt();
		int trenutno = a;

		if (k == 0) { 
			System.out.println("Korak ne sme biti enak 0.");
			System.exit(1);
		}
		if (a > b && k > 0 || a < b && k < 0) {
			System.out.println("Korak ni usklajen z mejama.");
			System.exit(1);
		}

		System.out.println();
		for (int i = 0; i*k <= Math.abs(a-b);i++) {
			System.out.print(trenutno + " ");
			trenutno += k;
		}
		System.out.println();



	}
}
