public class Skakalec {
    private static double tockeZaMeter = 1.8; // število točk za vsak meter odstopanja od K-točke
    private static int kTocka = 120; // K-točka skakalnice
    private int startnaSt; // startna številka
    private String priimek;
    private String ime;
    private double dolzina1; // dolžina skoka v 1. seriji
    private double dolzina2; // dolžina skoka v 2. seriji
    private double[] ocene1; // ocene sodnikov v 1. seriji
    private double[] ocene2; // ocene sodnikov v 2. seriji

    public double tockeZaDolzino(int serija) {
        double dolzina = 0;
        switch (serija) {
            case 1: dolzina = this.dolzina1;
                break;
            case 2: dolzina = this.dolzina2;
                break;
            default: return -1;
        }
        double razlika = dolzina - this.kTocka;
        double modifier = razlika * this.tockeZaMeter;
        return razlika > 0 ? 60 + modifier : 60 - modifier;
    }
    public double tockeZaSlog(int serija) {
        double[] ocene;
        switch (serija) {
            case 1: ocene = this.ocene1;
                break;
            case 2: ocene = this.ocene2;
                break;
            default: return -1;
                break;
        }
        /* if (serija == 1) { */
        /*     ocene = this.ocene1; */
        /* } else { */
        /*     ocene = this.ocene2; */
        /* }  */
        double min = ocene[0];
        double max = 0; 
        int indeksMax = -1;
        int indeksMin = -1;
        for (int i = 0; i < ocene.length; i++) {
            if (ocene[i] > max) {
                max = ocene[i];
                indeksMax = i;
            } 
            if (ocene[i] < min) {
                min = ocene[i];
                indeksMin = i;
            }
        } 
        double ocena = 0;
        for (int i = 0; i < ocene.length; i++) {
            if (i != indeksMax && i != indeksMin) {
                ocena+=ocene[i];
            }
        }
        return ocena;
    }
    public double tockeSkupaj() {
        return tockeZaDolzino(1) + tockeZaSlog(1) + tockeZaDolzino(2) + tockeZaSlog(2);
    }
    public boolean boljsi(Skakalec s) {
        return s.tockeSkupaj() < this.tockeSkupaj() ? false : true;
    }
    
}
public static Skakalec najboljsi(Skakalec[] t) {
    double najvec = 0;
    int indeks = -1;
    for (int i = 0; i < t.length; i++) {
        if (t[i].tockeSkupaj() > najvec) {
            najvec = t[i].tockeSkupaj();
            indeks = i;
        } 
    }
    return t[i];
}

