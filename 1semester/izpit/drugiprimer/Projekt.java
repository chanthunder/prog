import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Projekt {
    private static final String[] NAZIVI = {
        "Analiza", "Nacrtovanje", "Integracija modulov",
        "Izdelava modulov", "Priprava specifikacij", "Testiranje", "Namestitev"
    };
    private static final int[] ZACETKI = {0, 3, 18, 10, 1, 12, 27};
    private static final int[] TRAJANJA = {5, 10, 16, 11, 16, 18, 6};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel plosca = new RisalnaPlosca();
                GraficnoOgrodje.ustvariOkno("Projekt", plosca, true);

            }
        });
    }
    private static class RisalnaPlosca extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            double visina = (double) getHeight();
            double sirina = (double) getWidth();
            double visinaStolpca = visina / NAZIVI.length;
            double enota = sirina / dobiSirino(ZACETKI, TRAJANJA);
			g.setFont(new Font("SansSerif", Font.PLAIN, ri(visinaStolpca / 3)));
            FontMetrics fm = g.getFontMetrics();  // objekt, s pomočjo katerega lahko merimo napise
            int hNapis = fm.getAscent();  // višina napisa (odvisna samo od trenutno izbrane pisave)
            for (int i = 0; i < NAZIVI.length; i++) {
                    double x = ZACETKI[i]*enota;
                    double y = visinaStolpca*i;
                    double sirinaStolpca = TRAJANJA[i]*enota;
                    g.setColor(Color.YELLOW);
                    g.fillRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));
                    g.setColor(Color.GRAY);
                    g.drawRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));
                    int sirinaNapisa = fm.stringWidth(NAZIVI[i]);
                    double xNapis = x + (sirinaStolpca - sirinaNapisa) / 2;
                    double yNapis = y + (visinaStolpca - hNapis);
                    g.setColor(Color.BLACK);
                    g.drawString(NAZIVI[i], ri(xNapis), ri(yNapis));

            } 

        }

        private static int getMax(int[] tabela) {
            int max = 0;
            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i] > max) {
                    max = tabela[i];
                } 
            } 
            return max;
            
        }
        private static int dobiSirino(int[] zacetki, int[] trajanja) {
            int max = 0;
            for (int i = 0; i < zacetki.length; i++) {
                if (zacetki[i] + trajanja[i] > max) {
                    max = zacetki[i] + trajanja[i];
                } 
            } 
            return max;
        }

        private static int ri(double d) {
            return (int) Math.round(d);
        }

    }
}
