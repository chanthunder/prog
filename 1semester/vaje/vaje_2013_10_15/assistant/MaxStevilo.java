//
// Napiši program, ki s tipkovnice prebere <n> števil in izpiše največje in najmanjše med njimi
//

public class MaxStevilo {
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Izbiramo med " + n + " stevili");
		System.out.println();
		
		int min = -1;
		int max = -1;
		for (int i = 0; i < n; i++) {
			System.out.print("Vnesi " + (i+1) + ".stevilo: ");
			int stevilo = BranjePodatkov.preberiInt();
			if (i == 0 || stevilo < min)
				min = stevilo;
			if (i == 0 || max < stevilo)
				max = stevilo;
		}
		System.out.println();
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
	}
}