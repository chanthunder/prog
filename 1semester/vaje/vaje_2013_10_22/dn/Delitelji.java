public class Delitelji {

	public static void main(String[] args) {  

		System.out.println("Vnesi naravno stevilo: ");
		int a = BranjePodatkov.preberiInt();

		if (a <= 1) { 
			System.out.println("Stevilo ni pozitivno!");
			System.exit(1);
		}

		for (int i = 1;i<=a/2;i++) {
			if (a % i == 0)
				System.out.print(i + " ");
		}
			System.out.print(a);
			System.out.println();



	}
}
