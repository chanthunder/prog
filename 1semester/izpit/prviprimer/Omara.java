import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Omara {
    private static final int[][] VISINE = {
        {70, 30, 100, 0},
        { 0, 0, 50, 75},
        {90, 0, 0, 60}};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel plosca = new RisalnaPlosca();
                GraficnoOgrodje.ustvariOkno("Omara", plosca, true);

            }
        });
    }
    private static class RisalnaPlosca extends JPanel {
        private static Color BARVA_VSEBINE = Color.RED;
        private static Color BARVA_KVADRATKA = Color.WHITE;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            double visina = (double) getHeight();
            double sirina = (double) getWidth();
            for (int i = 0; i < VISINE.length; i++) {
                double visinaStolpca = (visina / VISINE.length);
                double sirinaStolpca = (sirina / VISINE[i].length);
                double enota = visinaStolpca / getMax(VISINE);
                double y = visinaStolpca * i;
                for (int j = 0; j < VISINE[i].length; j++) {
                    double x = sirinaStolpca * j;
                    double visinaOmare = VISINE[i][j] * enota;
                    g.setColor(BARVA_KVADRATKA);
                    g.fillRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));
                    g.setColor(BARVA_VSEBINE);
                    g.fillRect(ri(x), ri((y + visinaStolpca-visinaOmare)), ri(sirinaStolpca), ri(visinaOmare));
                    g.setColor(Color.BLACK);
                    g.drawRect(ri(x), ri((y + visinaStolpca-visinaOmare)), ri(sirinaStolpca), ri(visinaOmare));
                    g.drawRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));

                } 
                
            } 

        }

        private static int getMax(int[][] tabela) {
            int max = 0;
            for (int i = 0; i < tabela.length; i++) {
                for (int j = 0; j < tabela[i].length; j++) { 
                    if (tabela[i][j] > max) {
                        max = tabela[i][j];
                    } 
                }
            } 
            return max;
            
        }

        private static int ri(double d) {
            return (int) Math.round(d);
        }

    }
}
