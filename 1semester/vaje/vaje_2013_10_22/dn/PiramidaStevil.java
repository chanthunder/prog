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
 67890123456
 
*/

public class PiramidaStevil {

	public static void main(String[] args) {
		System.out.println("Vnesi n: ");
		int n = BranjePodatkov.preberiInt();
		int k = n;
		char presledek = ' ';
		for (int i = 1; i <= n;i++ ) {
			znaki(presledek, k);
            int krog = 1;
            for (int j = i; j<= 3 * i - 2; j++) {
              krog = j % 10;
		      System.out.print(krog);
            }
			znaki(presledek, k);
			System.out.println();
			k = k - 1;
		}	
	}

	public static void znaki(char znak,int ponovitev) {
		for (int i = 1; i <= ponovitev;i++ ) {
			System.out.print(znak);
		}	
	}


}
