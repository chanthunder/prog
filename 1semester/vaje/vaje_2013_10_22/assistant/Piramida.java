/*


Izpiši piramido zvezdic višine <n>, kot je prikazana na sliki:
Primer: n = 5
	
     *
    ***
   *****
  *******
 ********* 
 
 
 -------------------------------
 
 v2
 
     1
    234
   34567
  4567890
 567890123 
 
*/

public class Piramida {

	public static void main(String[] args) {
		System.out.print("Vnesi n: ");
		int n = BranjePodatkov.preberiInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++)
				System.out.print(" ");
			for (int j = 0; j < 2 * i + 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}






























