public class PostevankaII {

	public static void main(String[] args) {  

		System.out.println("Vnesi celo stevilo: ");
		int a = BranjePodatkov.preberiInt();
		System.out.println("Vnesi zgornjo mejo ");
		int b = BranjePodatkov.preberiInt();
		int trenutno = 1;
		int i = 1;

		if (b <= 0 || a <= 0) { 
			System.out.println("Stevilo ni pozitivno!");
			System.exit(1);
		}

		while (i*a <= b) {
			trenutno = a * i;
			System.out.println(a  + "  *  " + i + "  =  " + trenutno);
			i += 1;
		}



	}
}
