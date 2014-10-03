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

		System.out.print("Vnesi n: ");
		int vsota = 0;
		int staravsota = 0;
		int n = BranjePodatkov.preberiInt();
		for (int i=1;i<=n ;i++ ) {
			staravsota=vsota;
			vsota = vsota + i;
		System.out.println(staravsota + "+" +  i + "="  +vsota);
			
		}	
		System.out.println("Vsota je " + vsota);

  
	}
}
