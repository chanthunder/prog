class VnosnoPolje extends Komponenta {
    private String vsebina;

    public VnosnoPolje(int zacVr, int zacSt, int visina, int sirina, String vsebina) {
        super(zacVr, zacSt, visina, sirina);
        this.vsebina = vsebina;
    }

    public char znakGumba() {
        return '=';
    }

    public int dolzina() {
        return this.vsebina.length();
    }

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		super.narisi(tabela, odmikVr, odmikSt);
		int zacVr = this.zacVr + odmikVr + ((this.visina - 1) /  2);
		int zacSt = this.zacSt + odmikSt + 1;

        int stevec = 0;
		for (int i = zacSt; i < zacSt + dolzina(); i++) {
			tabela[zacVr][i] = this.vsebina.charAt(stevec);
			stevec+=1;
		}
    }
}
