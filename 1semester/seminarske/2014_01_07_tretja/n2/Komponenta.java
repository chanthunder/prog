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
    public String toString() {
        return "";
    }

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
class Gumb extends Komponenta {
    private String napis;

    public Gumb(int zacVr, int zacSt, int visina, int sirina, String napis) {
        super(zacVr, zacSt, visina, sirina);
        this.napis = napis;
    }

    public char znakGumba() {
        return ':';
    }

    public int dolzina() {
        return this.napis.length();
    }
    public String toString() {
        return String.format("%s %d %d %d %d [%s]", znakGumba(), this.zacVr, this.zacSt, this.visina, this.sirina, this.napis);
    }

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		super.narisi(tabela, odmikVr, odmikSt);
		int zacVr = this.zacVr + odmikVr + ((this.visina - 1) /  2);
		int zacSt = this.zacSt + odmikSt + ((this.sirina -  dolzina()) / 2);

        int stevec = 0;
		for (int i = zacSt; i < zacSt + dolzina(); i++) {
			tabela[zacVr][i] = this.napis.charAt(stevec);
			stevec+=1;
		}
    }
}
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
    public String toString() {
        return String.format("%s %d %d %d %d [%s]", znakGumba(), this.zacVr, this.zacSt, this.visina, this.sirina, this.napis);
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
    public String toString() {
        return String.format("%s %d %d %d %d [%s]", znakGumba(), this.zacVr, this.zacSt, this.visina, this.sirina, this.vsebina);
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
    public String toString() {
        String vrni = "";
        for (int i = 0; i < dolzina(); i++) {
            vrni += this.komponente[i].toString();
            if (i != dolzina() - 1) {
                vrni += ", ";
            } 
        }
        return String.format("%s %d %d %d %d [%s]", znakGumba(), this.zacVr, this.zacSt, this.visina, this.sirina, vrni);
    }

	public void narisi(char[][] tabela, int odmikVr, int odmikSt) {
		super.narisi(tabela, odmikVr, odmikSt);

		for (int i = 0; i < dolzina(); i++) {
            this.komponente[i].narisi(tabela, odmikVr + this.zacVr, odmikSt + this.zacSt);
		}
    }
}
