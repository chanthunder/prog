// [WHILE]

// Napišite program, ki prebere pozitivno celo število in izpiše 
// najprej njegove enice, nato desetice, nato stotice itd.

public class Stevke {

    public static void main(String[] args) {
			int stevilo = BranjePodatkov.preberiInt();
			int trenutno = stevilo;
			int i = trenutno;
			if (stevilo < 0) {
				System.out.println("Stevilo je negativno");
				System.exit(1);
			}
			/* string mesta = Integer.toString(stevilo); */
			/* int counter = mesta.length(); */
			while	(trenutno <= 0){
				i = trenutno % 10;
				System.out.println(i);
				trenutno = trenutno/10;
				

			}

		// ...
    }
}
