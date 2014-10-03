public class Uredi3 {

	public static void main(String[] args) {  

		System.out.println("Vnesi 3 stevila: ");
		int n1 = BranjePodatkov.preberiInt();
		// prvemu stevilu priredimo vse indekse
		int max = n1;
		int srednje = n1;
		int min = n1;
		int n2 = BranjePodatkov.preberiInt();
		int n3 = BranjePodatkov.preberiInt();
		// preverimo karero stevilo je najvecje in katero najmanjse
		if (n2 >= max) 
			max=n2;
		if (n2 <= min)
			min=n2;
		if (n3 >= max)
			max=n3;
		if (n3 <= min)
			min=n3;
		// preverimo ali je bodisi n2 bodisi n3 med minimumom in maksimumom,
		// preverimo tudi ali sta si kateri stevili enaki
		if (n2 == n3 && n3 == max) {
			srednje = n2;
		}	else {
		if (min < n2 && n2 < max) 
			srednje=n2;
		if (min < n3 && n3 < max) 
			srednje=n3;
		}
		System.out.println(min + ", " + srednje +  ", " + max);

	}
}
