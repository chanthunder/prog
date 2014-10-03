public class Potence {

	public static void main(String[] args) {  

		System.out.println("Vnesi osnovo (>=1): ");
		int a = BranjePodatkov.preberiInt();
		System.out.println("Vnesi eksponent (>=0): ");
		int b = BranjePodatkov.preberiInt();
		int trenutno = 1;

		if (b < 0 || a <= 1) { 
			System.out.println("Stevilo ni pozitivno!");
			System.exit(1);
		}
		if (b == 0) {
			System.out.println(a + " ^ " + b + " = " + 1);
			System.exit(1);
		}
			

		for (int i = 1;i<=b;i++) {
			trenutno = trenutno * a;
		}
		System.out.println(a  + "  ^  " + b + "  =  " + trenutno);



	}
}
