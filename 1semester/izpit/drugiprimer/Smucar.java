class Smucar {
}
class Tekmovanje {
    private Smucar[] tekmovalci;
    private int[] mesta;
    private Tekmovanje predhodno;

    private static int tockeMesta(int mesto) {
        return mesto < 11 ? 11 - mesto : 0;
    }
    public int tocke(Smucar s) {
     for (int i = 0; i < this.tekmovalci.length; i++) {
         if (this.tekmovalci[i].equals(s)) {
             return tockeMesta(this.mesta[i]);
         }
     }
     return 0;
    }
    public int tockeDoslej(Smucar s) {
        return this.predhodno != null ? this.predhodno.tocke(s) + tocke(s) : tocke(s);
    }
}

