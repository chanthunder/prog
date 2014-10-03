//
// Napiši program, ki s tipkovnice prebere <n> števil in izpiše največje in najmanjše med njimi
//

public class MaxStevilo {
	
	public static void main(String[] args) {
		int n = 10;
		double min = 0;
		double max = 0;
		System.out.println("Izbiramo med " + n + " stevili");
		for (int i=1;i<=n ;i++) {
			int st = BranjePodatkov.preberiInt();
			if (i==1) {
				min = st;
				max = st;
			}
			if (st>max) {
			 max = st;
			}
			if (st<min) {
				min = st;
			}
		}	
		System.out.println("Minimum je " + min);
		System.out.println("Maksimum je " + max);
		
		// ...
		
	}
}
