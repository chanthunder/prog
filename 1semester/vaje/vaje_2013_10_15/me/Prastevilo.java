/*
	Napišite program, ki za vnešeno število ugotovi ali je praštevilo.
*/

public class Prastevilo {

	public static void main(String[] args) {
		System.out.print("Vnesi n: ");
		int n = BranjePodatkov.preberiInt();
		boolean jePrastevilo=true;
		for (int i = 2;i<=Math.sqrt(n);i++ ) {
			if (n % i == 0) {
				jePrastevilo=false;
				break;
			}	
		}	
				if (jePrastevilo) {
					System.out.println("Stevilo " + n + " je prastevilo.");
				}
				else {
					System.out.println("Stevilo " + n + " ni prastevilo.");
				}
		
		// ...
		
	}
}
