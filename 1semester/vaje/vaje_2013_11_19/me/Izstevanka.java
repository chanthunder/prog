
/*
Otroci so razporejeni v ravni vrsti in se igrajo izštevanko tako dolgo, dokler
v vrsti ne ostane samo en otrok.  V vsakem krogu izštevanke izpade po en
otrok, ki se določi na sledeči način: "Selektor", ki ne pripada otrokom v
vrsti, izgovarja besede izštevanke (npr. am-bam-pet-podgan-...) in istočasno s
prstom "potuje" po otrocih.  Prične pri prvem otroku v vrsti, po vsaki besedi
pa pokaže na naslednjega otroka.  Kadarkoli prispe do konca vrste, nadaljuje
spet pri prvem otroku.  Ko izgovori zadnjo besedo izštevanke, otrok, na
katerega tedaj kaže njegov prst, izpade.

Na primer, če se na začetku v vrsti nahajajo otroci Ana, Bojan, Cene, Denis in
Eva, izštevanka pa je sestavljena iz 9 besed, potem v prvem krogu izpade
Denis:

Otroci              Ana  Bojan  Cene  Denis  Eva 
Beseda izštevanke    1.    2.    3.     4.    5.
                     6.    7.    8.     9.

V igri ostanejo Ana, Bojan, Cene in Eva.  Drugi krog se vnovič prične pri Ani
(vsak krog se prične pri prvem otroku v vrsti!), konča pa se tudi pri Ani.
Ostanejo torej Bojan, Cene in Eva.  Tretji krog se prične pri Bojanu in konča
pri Evi.  Ostaneta Bojan in Cene.  V četrtem krogu izpade Bojan.  Sedaj se
igra konča, saj je v vrsti ostal samo še en otrok (Cene).

Napišite program, ki simulira opisano izštevanko.
*/

public class Izstevanka {

    public static void main(String[] args) {
        System.out.print("Vnesite imena otrok: ");
        String[] otroci = BranjePodatkov.preberi1s();
        System.out.print("Vnesite število besed izštevanke: ");
        int stBesed = BranjePodatkov.preberiInt();
        System.out.println();
        izstevanka(otroci, stBesed);
    }

    private static void izstevanka(String[] otroci, int stBesed) {
        // ...
    }

}

