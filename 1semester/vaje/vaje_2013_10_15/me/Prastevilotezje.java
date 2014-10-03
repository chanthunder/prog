/*
	Napišite program, ki izpiše vsoto števil spodnje vrste med 1 in <n>:
	Vrsta: 1 - 2 + 3 - 4 + ... 

	Vnesi n: 6

    1 - 2 + 3 - 4 + 5 - 6 = -3
	
	---------------------------------------------------------------------
	
	(težja naloga za tiste, ki že znate vgnezdene zanke) Napišite program, 
	ki inkrementalno izpiše vsoto števil zgornje vrste med 1 in <n>.
	
	1 = 1
    1 - 2 = -1
    1 - 2 + 3 = 2
    1 - 2 + 3 - 4 = -2
    1 - 2 + 3 - 4 + 5 = 3
	1 - 2 + 3 - 4 + 5 - 6 = -3
*/

public class NeskoncnaVrsta {

	public static void main(String[] args) {
		System.out.print("Vnesi n: ");
		int n = BranjePodatkov.preberiInt();
		System.out.println();
		
		int[] tabela = new int[n+1];
		/* tabela[0] = 67; tabela.length */

		for (int i = 1;i<=n;i++)  {
			tabela[i] = i;
			for (int j=1;j<=i;j++ ) {
				System.out.print(tabela[i]);

			}	
			println;
		} 
		
		// ...
	}
}
