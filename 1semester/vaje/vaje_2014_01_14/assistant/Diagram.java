
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Diagram {

    // podatki za prikaz (npr. število prodanih enot po mesecih)
    private static final int[] PODATKI = { 10, 15, 7, 20, 25, 30, 18, 10, 28, 32, 45, 40 };

    // oznake mesecev
    private static final String[] NAPISI = {
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
			
			// mere
            double wPlosca = (double) getWidth();    // širina plošče
            double hPlosca = (double) getHeight();   // višina plošče
            double wStolpec = wPlosca / PODATKI.length;   // širina enega stolpca
            double hEnota = hPlosca / max(PODATKI);   // višina, ki ustreza podatku 1

            // nastavi pisavo v odvisnosti od trenutne širine stolpca
			g.setFont(new Font("SansSerif", Font.PLAIN, ri(wStolpec / 3)));
			
            FontMetrics fm = g.getFontMetrics();  // objekt, s pomočjo katerega lahko merimo napise
            int hNapis = fm.getAscent();  // višina napisa (odvisna samo od trenutno izbrane pisave)
			
            double xLevo = 0.0;  // x-koordinata levega roba trenutnega stolpca
            double yZgorajPrejsnji = 0.0;  // y-koordinata zgornjega roba prejšnjega stolpca
			
            for (int i = 0; i < PODATKI.length; i++) {
                double hStolpec = hEnota * PODATKI[i];  // višina stolpca
                double yZgoraj = hPlosca - hStolpec;  // y-koordinata zgornjega roba

                // nariši stolpec, ki predstavlja podatek PODATKI[i]
                g.setColor(BARVA_STOLPCA);
                g.fillRect(ri(xLevo), ri(yZgoraj), ri(wStolpec), ri(hStolpec));
                g.setColor(BARVA_STOLPCA.darker());
                g.drawRect(ri(xLevo), ri(yZgoraj), ri(wStolpec), ri(hStolpec));
				
                // črta od sredine vrha prejšnjega stolpca do sredine vrha trenutnega stolpca
                if (i > 0) {
                    g.setColor(BARVA_CRTE);
                    g.drawLine(	ri(xLevo - wStolpec / 2), ri(yZgorajPrejsnji), 
                                ri(xLevo + wStolpec / 2), ri(yZgoraj));
                }
				
                // napisi na stolpcih
                int wNapis = fm.stringWidth(NAPISI[i]);
                double xNapis = xLevo + (wStolpec - wNapis) / 2;
                double yNapis = hPlosca - hNapis;
                g.setColor(Color.BLACK);
                g.drawString(NAPISI[i], ri(xNapis), ri(yNapis));

                xLevo += wStolpec;
				
				// shrani trenutno vrednost yZgoraj
				yZgorajPrejsnji = yZgoraj;
            }
        }

        private static int max(int[] t) {
            int max = t[0];
            for (int i = 1;  i < t.length;  i++) {
                if (t[i] > max) {
					max = t[i];
				}
            }
            return max;
        }

        private static int ri(double d) {
            return (int) Math.round(d);
        }
    }
}
