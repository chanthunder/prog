public class Smucanje {

	public static void main(String[] args) {  

		System.out.println("Vnesi stevilo tekmovalcev: ");
		int n = BranjePodatkov.preberiInt();
		int najboljsi = Integer.MAX_VALUE;
		int t = 0;

		if (n <= 0) {
			System.out.println("Tekmovalcev je manj kot 1");
			System.exit(1);
		}	

		for (int i=1; i<=n; i++) {
			System.out.println("Tekmovalec " + i);
			System.out.print("		Vnesite cas v prvem teku: ");
			int a = BranjePodatkov.preberiInt();
			System.out.print("		Vnesite cas v drugem teku: ");
			int b = BranjePodatkov.preberiInt();
			if (a != -1 && b != -1 && a + b < najboljsi ) {
				t = i;
				najboljsi = a + b;
			}	
		}

		if (t != 0) {
			System.out.println("Najboljsi skupni cas (" + najboljsi + ") je dosegel tekmovalec " + t + ".");
		} else {
			System.out.println("Vsi tekmovalci so diskvalificirani");
		}	

	}
}
