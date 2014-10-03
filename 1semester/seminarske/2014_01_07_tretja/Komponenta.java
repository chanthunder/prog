abstract class Komponenta {
    protected int zacVr, zacSt, visina, sirina;

    public Komponenta(int zacVr, int zacSt, int visina, int sirina) {
        this.zacVr = zacVr;
        this.zacSt = zacSt;
        this.visina = visina;
        this.sirina = sirina;
    }

    abstract public char znakGumba();
    abstract public int dolzina();

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		int vrstica = odmikVr + this.zacVr;
		int stolpec = odmikSt + this.zacSt;
		
		for (int i = vrstica; i < vrstica + this.visina; i++) {
			for (int j = stolpec; j < stolpec + this.sirina; j++) {
                if (i == vrstica || i == vrstica + this.visina - 1 || j == stolpec || j == stolpec + this.sirina - 1) {
                    tabela[i][j] = this.znakGumba();
                } 
			}
		}
	}
}
