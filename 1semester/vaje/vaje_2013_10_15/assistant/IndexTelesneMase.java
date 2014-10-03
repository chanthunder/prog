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
		int visina = BranjePodatkov.preberiInt();
		double visinaM = (double)visina / 100;
		
		double itm = masa / (visinaM * visinaM);
		System.out.printf("%nITM = %4.2f%n", itm);

		System.out.println();
		if (itm < 18.5)
			System.out.println("suhost");
		else if (18.5 <= itm && itm < 25)
			System.out.println("normalna telesna masa");
		else if (25 <= itm && itm < 30)
			System.out.println("zvecana telesna masa");
		else
			System.out.println("debelost");
			
		int minIdeal = (int)Math.round(18.5 * (visinaM * visinaM));
		int maxIdeal = (int)Math.round(25.0 * (visinaM * visinaM));
		System.out.println("Idealna teza (kg): " + minIdeal + " - " + maxIdeal);
	}
}