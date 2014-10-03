
public class Drugi {

	public static void main(String[] args) {
		System.out.print("Vnesi prvo število: ");
		int a = BranjePodatkov.preberiInt();
		System.out.print("Vnesi drugo število: ");
		int b = BranjePodatkov.preberiInt();
		
		int vsota = a + b;
		System.out.println("Vsota znaša: " + vsota);
	}
}
