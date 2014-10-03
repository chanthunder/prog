
/*
Napišite program, ki prebere število <n> in nato nariše "smreko", sestavljeno
iz piramid višine 1, 2, ..., <n>.

n = 5:

    *
    *
   ***
    *
   ***
  *****
    *
   ***
  *****
 *******
    *
   ***
  *****
 *******
*********
*/

public class Smreka {

    public static void main(String[] args) {
        System.out.print("Vnesite število piramid: ");
        int n = BranjePodatkov.preberiInt();
        System.out.println();
        int zamik = n;
        for (int i=1; i<=n; i++) {
            piramida(i, zamik);
            zamik -= 1;
        } 

        // dopolnite ...
    }

	public static void piramida(int l, int zamik) {
		int k = l + zamik;
		char presledek = ' ';
		char zvezdica = '*';
		for (int i = 1; i <= l;i++ ) {
			znaki(presledek, k);
			znaki(zvezdica, i*2 - 1);
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

    // definirajte ustrezne metode ...
}

