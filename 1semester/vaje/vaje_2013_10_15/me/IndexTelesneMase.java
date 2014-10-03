/*
	Napišite kalkulator indeksa telesne mase (ITM). Program naj najprej prebere telesno maso 
	in telesno višino, nato pa izračuna in izpiše indeks telesne mase ter izpiše v kateri 
	razred prehranjenosti spadate. Na koncu naj vam na podlagi telesne višine izpiše idealno 
	težo. Formula za izračun ITM:
	 
	ITM = telesna masa (v kg) / (višina * višina (v m))
	
	(starosti in spola ne upoštevamo)
	Kategorija				ITM				Telesna masa
	----------------------------------------------------------------------
	Huda nedohranjenost 	    <= 16,0			
	Zmerna nedohranjenost 	16,0 – 17,0		suhost(zmanjšana telesna masa)
	Blaga nedohranjenost 	17,0 – 18,5
	----------------------------------------------------------------------
	Normalna telesna masa 	18,5 – 25,0 	normalna telesna masa
	----------------------------------------------------------------------
	Zvečana telesna masa 	25,0 – 30,0 	zvečana telesna masa
	----------------------------------------------------------------------
	Debelost stopnje I 		30,0 – 35,0
	Debelost stopnje II 	35,0 – 40,0 	debelost
	Debelost stopnje III 	>= 40,0
	----------------------------------------------------------------------

	Primer:
	
	Vnesi telesno maso: 80
	Vnesi visino (v cm): 180

	ITM = 24,69

	normalna telesna masa
	Idealna teza (kg): 60 - 81	
*/



public class IndexTelesneMase {

	public static void main(String[] args) {
		System.out.print("Vnesi telesno maso: ");
		double masa = BranjePodatkov.preberiDouble();
		System.out.print("Vnesi visino (v cm): ");
		double visina = BranjePodatkov.preberiInt();
		itm = masa/(0,0001*visina*visina);
		 if (itm <= 16,0) {
			 System.out.print("Huda podhranjenost");
			 System.out.println(itm);
		 }  else if ( 16,0 < itm && int <= 17,0) {
			 System.out.print("Zmerna podhranjenost");
			 System.out.println(itm);
		 }  else if ( 17,0 < itm && int <= 18,5) { 
			 System.out.print("Blaga podhranjenost");
			 System.out.println(itm);

		 }  else if ( 18,5 < itm && itm <= 25,0) { 
			 System.out.println(itm);
			 System.out.print("Normalna telesna teza");
		 }  else if ( 25,0 < itm && itm <= 30,0) { 
			 System.out.print("Zvecana telesna teza");
			 System.out.println(itm);
		 }  else if ( 30,0 < itm && itm <= 35,0) { 
			 System.out.print("Debelost stopnje I");
			 System.out.println(itm);
		 }  else if ( 35,0 < itm && itm <= 40,0) { 
			 System.out.print("Debelost stopnje II");
			 System.out.println(itm);
		 }  else  { 
			 System.out.print("Debelost stopnje III");
			 System.out.println(itm);
		 }

		// ...
	}
}
