public class PostevankaI {

	public static void main(String[] args) {  

		System.out.println("Vnesi celo stevilo: ");
		int a = BranjePodatkov.preberiInt();
		System.out.println("Vnesi pozitivno celo stevilo: ");
		int b = BranjePodatkov.preberiInt();
		int trenutno = 1;

		if (b <= 0) { 
			System.out.println("Stevilo ni pozitivno!");
			System.exit(1);
		}

		for (int i = 1; i <= b;i++) {
			trenutno = a * i;
			System.out.println(a  + "  *  " + i + "  =  " + trenutno);
		}



	}
}
