
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diagram {

    // podatki za prikaz (npr. število prodanih enot po mesecih)
    private static final int[] PODATKI = { 10, 15, 7, 20, 25, 30, 18, 10, 28, 32, 45, 40 };

    // oznake mesecev
    private static final String[] OZNAKE = {
        "jan", "feb", "mar", "apr", "maj", "jun", "jul", "avg", "sep", "okt", "nov", "dec"
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel plosca = new RisalnaPlosca();
                GraficnoOgrodje.ustvariOkno("Diagram", plosca, true);

            }
        });
    }

/**
 * razred za predstavitev risalne plošče
 */
private static class RisalnaPlosca extends JPanel {
    private static Color BARVA_STOLPCA = new Color(240, 240, 200);
    private static Color BARVA_CRTE = Color.BLUE;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double wPlosca = (double) getWidth();
        double hPlosca = (double) getHeight();
        double wStolpec = wPlosca / PODATKI.length;
        double hEnota = hPlosca / getMax(PODATKI);

        double xLevo = 0.0;
        double yZgorajPrejsnji = 0.0;

        for (int i = 0; i < PODATKI.length; i++) {
            double hStolpec = hEnota * PODATKI[i];
            double yZgoraj = hPlosca - hStolpec;

            // nariši stolpec, ki predstavlja podatek PODATKI[i]
            g.setColor(BARVA_STOLPCA);
            g.fillRect(ri(xLevo), ri(yZgoraj), ri(wStolpec), ri(hStolpec));
            g.setColor(BARVA_STOLPCA.darker());
            g.drawRect(ri(xLevo), ri(yZgoraj), ri(wStolpec), ri(hStolpec));

            if (i > 0) {
                g.setColor(BARVA_CRTE);
                g.drawLine( ri(xLevo - wStolpec / 2), ri(yZgorajPrejsnji), 
                        ri(xLevo + wStolpec / 2), ri(yZgoraj));
            }

            xLevo += wStolpec;
            
            // shrani trenutno vrednost yZgoraj
            yZgorajPrejsnji = yZgoraj;
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

    private static int ri(double d) {
        return (int) Math.round(d);
    }

}
}

