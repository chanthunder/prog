
/*
Vojaki bi se na poziv "V vrsto zbor!" morali razvrstiti po višini od
najmanjšega do največjega, a tega ne znajo najbolje.  Napišite program, ki na
podlagi tabele višin vojakov v "vrsti zbor" izpiše indekse vojakov, ki so
postavljeni lokalno pravilno.  Vojak je postavljen lokalno pravilno, če je
njegov levi sosed nižji ali enako visok, desni pa višji ali enako visok kot
on.  Če noben vojak ni postavljen lokalno pravilno, naj program to sporoči z
besedico "nihče".

Primer 1: Za tabelo višin {185, 172, 180, 181, 190, 183, 178, 185, 191, 207}
naj program izpiše:

Postavljeni lokalno pravilno: 2 3 7 8 9

Primer 2: Za tabelo višin {175, 169, 183, 176, 200, 180} naj program izpiše:

Postavljeni lokalno pravilno: nihče
*/

public class VrstaZbor {

    public static void main(String[] args) {
        int[] visine1 = {185, 172, 180, 181, 190, 183, 178, 185, 191, 207};
        lokalnoPravilni(visine1);
        System.out.println();

        /*
        int[] visine2 = BranjePodatkov.preberi1i("visine.txt");
        lokalnoPravilni(visine2);
        System.out.println();

        System.out.print("Vnesite zaporedje višin, ločeno s presledki: ");
        int[] visine3 = BranjePodatkov.preberi1i();
        lokalnoPravilni(visine3);
        */
    }

    private static void lokalnoPravilni(int[] visine) {
        System.out.print("Postavljeni lokalno pravilno: ");
        int dolzinatabele = visine.lenght;
        boolean obstaja;
        if (visine[1] <= visine[2]) {
          System.out.println(1);
          obstaja = true;
        } 
        for (int i = 1;i < dolzinatabele; i++) {
          if (visine[i-1] <= visine[i] && visine[i] <= visine[i+1]) {
            System.out.println(i);
            obstaja = true;
          }
        } 
        if (visine[dolzinatabele-1] <= visine[dolzinatabele]) {
          System.out.println(dolzinatabele);
          obstaja = true;
        } 
        System.out.println();
        if (!obstaja) { 
          System.out.println("nihce");
        }
        // ...
    }
}

