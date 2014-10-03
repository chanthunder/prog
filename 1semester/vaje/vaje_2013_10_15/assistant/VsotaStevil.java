// [Vsota stevil]

// Napiši program, ki izpiše vsoto števil med 1 in N. 
// Program nadgradi tako, da izpiše tudi vmesne vsote. Primer na sliki.

	// izpisi vsoto stevil od [1, n]
	// vsota / i / nova vsota
	// 0 + 1 = 1
	// 1 + 2 = 3
	// 3 + 3 = 6
	// 6 + 4 = 10
	// 10 + 5 = 15
	// 15 + 6 = 21
	//
	// Vsota = 21
		
// Nadgradnja: Napišite program, ki izpiše seštevek lihih in sodih števil.

public class VsotaStevil {

	public static void main(String[] args) {  
		int n = 6;
		int vsota = 0;
		
		for (int i = 1; i <= n; i++) {
			System.out.print(vsota + " + " + i + " = ");
			vsota = vsota + i;
			System.out.println(vsota);
		}
		System.out.println();
		System.out.println("Vsota = " + vsota);
	}
}
