
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

		// smreka je sestavljena iz <n> zamaknjenih piramid
		for (int i = 1;  i <= n;  i++) {
			zamaknjenaPiramida(...);
		}
    }


}

