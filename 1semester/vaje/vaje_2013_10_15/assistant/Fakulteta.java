/*
	Napišite program, ki izračuna in izpiše fakulteto števila <n>. Primer:
	
	Vnesi n: 6
	6! = 720
	
*/

public class Fakulteta {

	public static void main(String[] args) {		
		System.out.print("n: ");
		int n = BranjePodatkov.preberiInt();
		System.out.println();
		
		// izracun fakultete stevila

		long fakulteta = 1;
		for (int i = 1; i <= n; i++) {
			fakulteta *= i;
		}
		System.out.println(n + "! = " + fakulteta);
	}
}