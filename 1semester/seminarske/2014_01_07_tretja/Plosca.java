class Plosca extends Komponenta {
    private Komponenta[] komponente;

    public Plosca(int zacVr, int zacSt, int visina, int sirina, Komponenta[] komponente) {
        super(zacVr, zacSt, visina, sirina);
        this.komponente = komponente;
    }

    public char znakGumba() {
        return '+';
    }

    public int dolzina() {
        return this.komponente.length;
    }

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		super.narisi(tabela, odmikVr, odmikSt);

		for (int i = 0; i < dolzina(); i++) {
            this.komponente[i].narisi(tabela, odmikVr + this.zacVr, odmikSt + this.zacSt);
		}
    }
}
