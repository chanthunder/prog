/*
Kleptomanka Anka bi rada ukradla kolo, ki je zaščiteno s številčno
ključavnico.  Ključavnica ima tri številska mesta (a-b-c).  Nekdo Anki
prišepne, da je prva števka liha, zadnja deljiva s 3, srednja števka pa je
večja od t (t je števka med 0 in vključno 8, ki jo vnese uporabnik). Napišite
program, ki izpiše vse možne kombinacije števk. Na koncu naj program izpiše,
koliko je teh kombinacij.

Primer izvajanja programa:

Vnesite celo število med 0 in vključno 8: 7

1-8-0
1-8-3
1-8-6
1-8-9
1-9-0
1-9-3
1-9-6
1-9-9
3-8-0
3-8-3
3-8-6
3-8-9
3-9-0
3-9-3
3-9-6
3-9-9
5-8-0
5-8-3
5-8-6
5-8-9
5-9-0
5-9-3
5-9-6
5-9-9
7-8-0
7-8-3
7-8-6
7-8-9
7-9-0
7-9-3
7-9-6
7-9-9
9-8-0
9-8-3
9-8-6
9-8-9
9-9-0
9-9-3
9-9-6
9-9-9

Število kombinacij: 40
*/

public class Anka {

    public static void main(String[] args) {
        System.out.print("Vnesite celo število med 0 in vključno 8: ");
        int t = BranjePodatkov.preberiInt();
        int stevec = 0;
        if (t < 0 && t > 8) {
            System.out.println("Stevilo ni med 0 in vključno 8.");
            System.exit(1);
        }
        for (int i=0;i<=9;i++){
            if (i % 2 != 0) {
                for (int j=t+1;j<=9;j++) {
                    for (int k=1;k<=t;k++) {
                        if (j % 3 == 0) {
                            System.out.println(i + "-" + j + "-" + k);
                            stevec +=1;
                        } 
                    } 
                } 
            } 
        } 
        System.out.println("Stevilo kombinacij: " + stevec);
    }
}

