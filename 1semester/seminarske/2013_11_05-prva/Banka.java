public class Banka {

    public static void main(String[] args) {
        // stevilo bankovcev po 5
        System.out.println("Vnesite stevilo bankovcev po 5 evrov: ");
		int pet = BranjePodatkov.preberiInt();
        while (pet < 0) {
            System.out.println("Stevilo bankovcev za 5 evrov je manjse od 0. Ponovite vnos: ");
		    pet = BranjePodatkov.preberiInt();
        }
        // stevilo bankovcev po 2
        System.out.println("Vnesite stevilo bankovcev po 2 evra: ");
        // stevilo bankovcev po 1
		int dva = BranjePodatkov.preberiInt();
        while (dva < 0) {
            System.out.println("Stevilo kovancev za 2 evra je manjse od 0. Ponovite vnos: ");
		    dva = BranjePodatkov.preberiInt();
        }
        System.out.println("Vnesite stevilo bankovcev po 1 evro: ");
		int ena = BranjePodatkov.preberiInt();
        while (ena < 0) {
            System.out.println("Stevilo kovancev za 1 evro je manjse od 0. Ponovite vnos: ");
		    ena = BranjePodatkov.preberiInt();
        }
        // izplacilo po 5
        int ipet = 0;
        // izplacilo po 2
        int idva = 0;
        // izplacilo po 1
        int iena = 0;

        // privzamemo da lahko izplacamo znesek, dokler ni dokazano nasprotno
        boolean lahkoIzplaca = true;

        /* izpisemo prebrano stanje na banki, % predstavlja zacetek formata,
         * stevilo za tem koliko mest rezerviramo za izpis in zadnje kaksno
         * spremenljivko izpisemo, s je string, d je stevilo, n je nova vrstica */
        System.out.printf("%15s %3d | %3d | %3d%n","Stanje na banki: ", pet, dva, ena);
        // dokler lahko izplacamo
        while (lahkoIzplaca) {
            System.out.println("znesek: ");
            // preberemo znesek
		    int znesek = BranjePodatkov.preberiInt();
            // ce je znesek vecji od nic polagamo
            if (znesek > 0) {
                ena += znesek % 10;
                znesek = znesek / 10;
                dva += znesek % 10;
                znesek = znesek / 10;
                pet += znesek % 10;
                znesek = znesek / 10;
            // v nasprotnem primeru dvigamo
            } else if (znesek < 0){
                // znesek spremenimo v pozitivnega, saj ze vemo, da dvigamo denar 
                znesek *= -1;
                // dokler je nas znesek vecji od 0
                while (znesek > 0) {
                    // ce je znesek vecji od 5 in imamo kaj bankovcev za 5 evrov
                    if (znesek >= 5 && pet > 0) {
                        /* ce nimamo dovolj bankovcev za 5 evrov odstejemo od
                         * zneska za toliko bankovcev za 5 evrov, kolikor jih
                         * imamo, izplacali smo toliko bankovcev za 5 evrov
                         * kolikor jih imamo, torej jih nimamo vec*/
                        if (znesek / 5 > pet) {
                            znesek -= pet*5;
                            ipet = pet;
                            pet = 0;
                        /* Imamo dovolj bankovcev za 5 evrov, porabili smo za
                         * znesek/5 bankovcev za 5 evrov, izplacali smo za
                         * znesek/5 bankovcev za 5 evrov, znesek se je zmanjsal
                         * za 5*ipet(stevilo izplacanih bankovcev za 5 evrov)
                         * */
                        } else {
                            pet -= znesek/5;
                            ipet = znesek/5;
                            znesek -= ipet*5;
                        }
                    // ce je znesek vecji od 2 in imamo kaj bankovcev za 2 evrov
                    } else if (znesek >= 2 && dva > 0) {
                        /* ce nimamo dovolj bankovcev za 2 evra odstejemo od
                         * zneska za toliko bankovcev za 2 evra, kolikor jih
                         * imamo, izplacali smo toliko bankovcev za 2 evra
                         * kolikor jih imamo, torej jih nimamo vec*/
                        if (znesek / 2 > dva) {
                            idva = dva;
                            dva = 0;
                            znesek -= idva*2;
                        /* Imamo dovolj bankovcev za 2 evra, porabili smo za
                         * znesek/5 bankovcev za 2 evra, izplacali smo za
                         * znesek/5 bankovcev za 2 evra, znesek se je zmanjsal
                         * za 2*idva(stevilo izplacanih bankovcev za 2 evra)
                         * */
                        } else {
                            dva -= znesek/2;
                            idva = znesek/2;
                            znesek -= idva*2;
                        } 
                    // drugace ali nimamo vec bankovcev za 5 ali 2 evra ali pa je znesek manjsi od 2 ali pa ne moremo izplacati
                    } else {
                        /* ce je stevilo bankovcev za en evro vecji od
                         * zneska, izplacamo toliko bankovcev za 1 evro,
                         * koliksen je znesek, odstejemo od bankovcev za en
                         * evro znesek, znesek postane 0 */
                        if (znesek <= ena) {
                            iena = znesek;
                            ena -= znesek;
                            znesek = 0;
                        // drugace zneska ne moremo izplacati, napisemo, da ga ne moremo in izstopimo iz programa
                        } else {
                            System.out.println("Zneska ni mogoce izplacati");
                            System.exit(1);
                        } 
                    }
                }
                // napisemo koliko bankovcev smo izplacali in ponastavimo ipet, idva in iena
                System.out.printf("%15s %3d | %3d | %3d%n","Izplacilo: ", ipet, idva, iena);
                ipet = 0;
                idva = 0;
                iena = 0;
            } else {
                System.out.println("Poloziti morate vsaj 1 evro.");
            }
            // izpisemo stanje na banki
            System.out.printf("%15s %3d | %3d | %3d%n","Stanje na banki: ", pet, dva, ena);
        }
    }
}

