class Oznaka extends Komponenta {
    private String napis;

    public Oznaka(int zacVr, int zacSt, int visina, int sirina, String napis) {
        super(zacVr, zacSt, visina, sirina);
        this.napis = napis;
    }

    public char znakGumba() {
        return '-';
    }

    public int dolzina() {
        return this.napis.length();
    }

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		super.narisi(tabela, odmikVr, odmikSt);
		int zacVr = this.zacVr + odmikVr + ((this.visina - 1) /  2);
		int zacSt = this.zacSt + odmikSt + ((this.sirina -  dolzina()) - 1);

        int stevec = 0;
		for (int i = zacSt; i < zacSt + dolzina(); i++) {
			tabela[zacVr][i] = this.napis.charAt(stevec);
			stevec+=1;
		}
    }
}
