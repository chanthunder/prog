public class IzracunMandatov {
    // stranke, ki sodelujejo na volitvah
	private static String[] imenaStrank;
    // odstotki glasov, ki so jih dobile sodelujoce stranke
	private static double[] odstotkiStrank;
    // stevilo kandidatov, ki jih je dobila vsaka stranka
	private static int[] stKandidatov;
    // stevilo neodvisnih kandidatov
	private static int stNeodvisnihKandidatov;
    // skupno stevilo mandatov, ki so na voljo
	private final int SKUPNO_MEST = 88;
    /* tabela, ki za vsako stranko shrani koliko mest je dobila v prvem in
     * drugem krogu ter revalorizirane odstotke */
	private double[][][] tabela = new double[this.imenaStrank.length][2][2];

    private static final int[][] KOALICIJE = {
        {1, 6, 10},
        // koalicija 1 (liste B, G, K)
        {2},
        // koalicija 2 (lista C)
        {0, 9, 12, 13},
        // ...
        {5},
        {4, 8},
        {3, 7, 11}
    };

	public static void main(String[] args) {
        String[] stranke = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
        double[] procenti = {17, 3.5, 2.8, 12.3, 4.5, 14.2, 10.7, 8, 5.5, 0.8, 1.2, 9.7, 9.8, 0};
        int[] kandidati = {7, 4, 2, 6, 3, 10, 4, 0, 0, 0, 0, 0, 0, 0};
        int neodvisni = 8;
        imenaStrank = stranke;
        odstotkiStrank = procenti;
        stKandidatov = kandidati;
        stNeodvisnihKandidatov = neodvisni;
        new IzracunMandatov();
	}


	public IzracunMandatov() {
        // preveri pravilnost podatkov (ce tabele niso enako dolge lahko pride do napak)
        if (this.imenaStrank.length != this.odstotkiStrank.length || this.imenaStrank.length != this.stKandidatov.length) {
            System.out.println("Podatki so asimetricni. Izracun po trenutni metodi ni mogoc");
            System.exit(1);
        }
        // napolni tabelo s podatki
        napolniTabelo();
		
        // izpise tabelo
        izpisiTabelo();
	}
	

    public void napolniTabelo() {
		for (int i = 0; i < 2; i++) {
            // izracunamo koliko mest je zasedenih in se ne uposteva pri nadalnji delitvi
			int stZasedenihMest = this.stNeodvisnihKandidatov;
            // odstotek strank, ki ne ustrezajo ne pogoju A ne pogoju B
			double odstotekNesodelujocihStrank   = 0;
			
			for (int j = 0; j < this.imenaStrank.length; j++) {
                // ce smo v drugem krogu preverjamo podatke iz prejšnjega kroga, drugace preverimo ali stranka ne zadosca ne pogoju A ne pogoju B, torej ne sodeluje v dodatni delitvi mandatov
				if (this.odstotkiStrank[j] < 4 && this.stKandidatov[j] < 4 || i==1 && this.tabela[j][0][1] < this.stKandidatov[j]) {
					stZasedenihMest +=  this.stKandidatov[j];
					odstotekNesodelujocihStrank   += this.odstotkiStrank[j];
				}
			}
			
			for (int j = 0; j < this.imenaStrank.length; j++) {
                // v prvem krogu preverimo ce katera od strank zadosca pogoju A ali B v drugem krogu pa ali je stevilo kandidatov za to stranko iz prejsnega kroga vecje od 0
				if (i == 0 && (4 <= this.odstotkiStrank[j] || 4 <= this.stKandidatov[j]) || i==1 && 0 != this.tabela[j][0][1] && this.stKandidatov[j] <= this.tabela[j][0][1]) {
                    double novDelez = this.revalorizirajOdstotekGlasov(odstotekNesodelujocihStrank, this.odstotkiStrank[j]);
					double razdelitevMest  = (novDelez * (this.SKUPNO_MEST - stZasedenihMest) / 100.0);
					
					this.tabela[j][i][0] = novDelez;
					this.tabela[j][i][1] = razdelitevMest;
				}
			}
		}
    }


    public void izpisiTabelo() {
		double odstotkiPrveDelitve = 0;
        double odstotkiDrugeDelitve = 0;
        int mestaPrveDelitve = 0;
        int mestaDrugeDelitve = 0;
		
		for (int i = 0; i < this.imenaStrank.length; i++) {
			System.out.printf("%12s %4d %8.1f", this.imenaStrank[i], this.stKandidatov[i], this.odstotkiStrank[i]);
			
            

            if (this.tabela[i][0][0] == 0.0) {
			    System.out.printf("%25s", "");
            } else {
			    System.out.printf("%12.6f %12.4f", this.tabela[i][0][0], this.tabela[i][0][1]); 
            } 
            if (this.tabela[i][1][0] == 0.0) {
			    System.out.printf("%25s", "");
            } else {
                System.out.printf("%12.5f %12.5f", this.tabela[i][1][0], this.tabela[i][1][1]);
            } 
			
			int steviloMestPoStrankah   = (int) Math.round(this.tabela[i][1][1]);
			int steviloDodatnihMestPoStrankah = steviloMestPoStrankah - this.stKandidatov[i];
			
            if (steviloMestPoStrankah > 0) {
                mestaPrveDelitve += steviloMestPoStrankah;
                System.out.printf(" %8d", steviloMestPoStrankah);
            } else if (this.stKandidatov[i] !=0 || this.odstotkiStrank[i] == 0 && this.stKandidatov[i] == 0){
                mestaPrveDelitve += this.stKandidatov[i];
                System.out.printf(" %8d", this.stKandidatov[i]);
            } else {
                System.out.printf("%9s", "");
            }
            if (steviloDodatnihMestPoStrankah > 0) {
                System.out.printf(" %8d", steviloDodatnihMestPoStrankah);
                mestaDrugeDelitve += steviloDodatnihMestPoStrankah;
            } else {
                System.out.printf("%9s", "");
            }
			
			odstotkiPrveDelitve  += this.tabela[i][0][1];
			odstotkiDrugeDelitve += this.tabela[i][1][1];
			
			System.out.println();
		}
		
		System.out.printf("%12s %4d %62s %4d\n", "Neodvisni", this.stNeodvisnihKandidatov, "", this.stNeodvisnihKandidatov);
		
        int mandati = this.SKUPNO_MEST;
        int sto = 100;
		System.out.printf("%12s %4d %8d %11d %12.4f %11d %12.6f %8d %8d\n", "Skupaj", mandati/2, sto, sto, odstotkiPrveDelitve, sto, odstotkiDrugeDelitve, mestaPrveDelitve+stNeodvisnihKandidatov, mestaDrugeDelitve);
        for (int j = 0; j < this.KOALICIJE.length; j++) {
            int mandatKoalicije = 0;
            int indeksKoalicije = 0;
            for (int k = 0; k<this.KOALICIJE[j].length; k++) {
                if (tabela[KOALICIJE[j][k]][1][1] >= mandatKoalicije) {
                    mandatKoalicije = (int) tabela[KOALICIJE[j][k]][1][1];
                    indeksKoalicije = KOALICIJE[j][k];
                } 
            }
            System.out.printf("%s %d %s %s.\n", "V koaliciji", j+1, "je najvec mandatov prejela lista", imenaStrank[indeksKoalicije]);

        } 
    }
	public double revalorizirajOdstotekGlasov(double odstotek, double odstotekStranke) {
		return odstotekStranke*(100 / (100 - odstotek));
	}
}
