import java.awt.*;
import javax.swing.*;

public class GraficnoOgrodje {
  public static void ustvariOkno(String naslov, JPanel plosca, boolean izrecnaVelikost) {
    Okno okno=new Okno(naslov);
    okno.add(plosca);
    if (izrecnaVelikost) {
      okno.nastaviVelikost();
    }
    else {
      okno.pack();
      okno.postaviNaSredinoZaslona();
    }
    okno.setVisible(true);
  }
  
  private static class Okno extends JFrame {
    private int wZaslon, hZaslon;
    
    public Okno(String naslov) {
      setTitle(naslov);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Toolkit tk=Toolkit.getDefaultToolkit();
      Dimension d=tk.getScreenSize();
      wZaslon=d.width;
      hZaslon=d.height;
    }
    
    public void nastaviVelikost() {
      setSize(3*wZaslon/4, 3*hZaslon/4);
      setLocation(wZaslon/8, hZaslon/8);
    } 
      
    public void postaviNaSredinoZaslona() {
      setLocation((wZaslon - getWidth()) / 2, (hZaslon - getHeight()) / 2);
    }
  }
}
