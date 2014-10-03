class Podatki {
	protected char[][] tabela = new char[28][43];

	
	public static void main(String[] args) {
        new Podatki();
	}
    public Podatki() {
		Komponenta plosca = new Plosca(0, 0, 28, 43, new Komponenta[] {
			new Plosca(2, 3, 5, 37, new Komponenta[] {
				new Oznaka(1, 2, 3, 13, "Poisci:"),
				new VnosnoPolje(1, 16, 3, 19, "cuker"),
			}),
			new Plosca(8, 3, 5, 37, new Komponenta[] {
				new Oznaka(1, 2, 3, 13, "Zamenjaj z:"),
				new VnosnoPolje(1, 16, 3, 19, "sladkor"),
			}),
			new Gumb(14, 3, 3, 12, "Poisci"),
			new Gumb(18, 3, 3, 12, "Zamenjaj"),
			new Gumb(14, 20, 7, 20, "Zamenjaj vse"),
			new Gumb(22, 3, 4, 37, "Zapri"),
		});
		
		
		plosca.narisi(this.tabela, 0, 0);
        System.out.println(plosca.obsegOkvirja());

		for (int i = 0; i < this.tabela.length; i++) {
			for (int j = 0; j < this.tabela[i].length; j++) {
                if (this.tabela[i][j] =='\u0000') {
                    System.out.print(' ');
                } else { 
                    System.out.print(this.tabela[i][j]);
                }
			}
			
			System.out.println();
		}
    }
}

