/*
	Napišite program, ki za vnešeno število ugotovi ali je praštevilo.
*/

public class Prastevilo {

	public static void main(String[] args) {
		System.out.print("Vnesi n: ");
		int n = BranjePodatkov.preberiInt();
		
		// preverimo, ali je prastevilo
		boolean jePrastevilo = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				jePrastevilo = false;
				System.out.println("Stevilo " + n + " je deljivo z " + i);
				break;
			}
		}
		
		// izpis
		System.out.print("Stevilo " + n + " ");
		if (jePrastevilo)
			System.out.print("je");
		else
			System.out.print("ni");
		System.out.println(" prastevilo.");
	}
}