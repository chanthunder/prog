public class Evrosop {

	public static void main(String[] args) {  

		int en = 0;
		int dva = 0;
		boolean imaDenar = true;
		System.out.println("Stanje v blagajni: " + en + "|" + dva);
		while (imaDenar) {
			System.out.println("Vnesi placilo (1 ali 2): ");
			int a = BranjePodatkov.preberiInt();
			if (a != 1 && a != 2 || a == 2 && en - 1 < 0) {
				System.out.println("Vracilo ni mogoce!");
				imaDenar = !imaDenar;
			} else if (a == 1) {
				en +=1;
				System.out.println("Stanje v blagajni: " + en + "|" + dva);
			} else {
				dva +=1;
				en -=1;
				System.out.println("Stanje v blagajni: " + en + "|" + dva);
			}
		} 

	}
}
