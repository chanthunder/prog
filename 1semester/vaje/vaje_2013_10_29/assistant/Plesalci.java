
/*
V klubu matematičnih plesalcev so moški in ženske označeni z zaporednimi
številkami od 1 naprej.  Moški s številko <m> lahko pleše z žensko s številko
<z> samo, če je GCD (največji skupni delitelj) števil <m> in <z> enak
določenemu številu ("ustrezni GCD").  Napišite program, ki prebere število
moških, število žensk in ustrezni GCD, nato pa izpiše vse možne plesne pare.

Primer:

Vnesite število moških: 10
Vnesite število žensk: 10
Vnesite ustrezni GCD: 3

Par 1: moški 3 in ženska 3
Par 2: moški 3 in ženska 6
Par 3: moški 3 in ženska 9
Par 4: moški 6 in ženska 3
Par 5: moški 6 in ženska 9
Par 6: moški 9 in ženska 3
Par 7: moški 9 in ženska 6
*/

public class Plesalci {

    public static void main(String[] args) {
        System.out.print("Vnesite število moških: ");
        int stMoskih = BranjePodatkov.preberiInt();
        System.out.print("Vnesite število žensk: ");
        int stZensk = BranjePodatkov.preberiInt();
        System.out.print("Vnesite ustrezni GCD: ");
        int ustrezniGCD = BranjePodatkov.preberiInt();
        System.out.println();

        int stevilkaPara = 1;
        for (int m = ustrezniGCD;  m <= stMoskih;  m += ustrezniGCD) {
            for (int z = ustrezniGCD;  z <= stZensk;  z += ustrezniGCD) {
                if (gcd(m, z) == ustrezniGCD) {
                    System.out.printf("Par %d: moški %d in ženska %d%n", 
                            stevilkaPara, m, z);
                    stevilkaPara++;
                }
            }
        }
	}

    /** Vrne GCD pozitivnih celih števil a in b. */
    public static int gcd(int a, int b) { 
        while (a != b) {
            if (a > b) {
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }
}

