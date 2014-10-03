
import java.util.*;
import java.io.*;

public class BranjePodatkov {

    /** S standardnega vhoda prebere celo število kot podatek tipa
     * <tt>int</tt>.  Branje ponavlja, dokler uporabnik ne vnese veljavnega
     * celega števila. */
    public static int preberiInt() {
        boolean uspeh = false;
        int stevilo = 0;
        while (!uspeh) {
            try {
                Scanner scanner = new Scanner(System.in);
                stevilo = scanner.nextInt();
                uspeh = true;
            } catch (InputMismatchException e) {
                System.out.print("Napačen format števila! Ponovite vnos: ");
            }
        }
        return stevilo;
    }

    /** S standardnega vhoda prebere realno število kot podatek tipa
     * <tt>double</tt>.  Branje ponavlja, dokler uporabnik ne vnese veljavnega
     * realnega števila. */
    public static double preberiDouble() {
        boolean uspeh = false;
        double stevilo = 0.0;
        while (!uspeh) {
            try {
                Scanner scanner = new Scanner(System.in);
                stevilo = scanner.nextDouble();
                uspeh = true;
            } catch (InputMismatchException e) {
                System.out.print("Napačen format števila! Ponovite vnos: ");
            }
        }
        return stevilo;
    }

    /** S standardnega vhoda prebere vrstico besedila kot podatek tipa
     * <tt>String</tt>. */
    public static String preberiString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /** S standardnega vhoda prebere zaporedje celih števil, ločenih s
     * presledki, kot tabelo tipa <tt>int[]</tt>. */
    public static int[] preberi1i() {
        return strint1(preberi1(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi1i</tt>, le da bere iz datoteke. */
    public static int[] preberi1i(String datoteka) {
        return strint1(preberi1(odpri(datoteka)));
    }

    /** S standardnega vhoda prebere tabelo tipa <tt>int[][]</tt>. 
     * Primer vnosa tabele 3 x 4: <tt> 4 5 -3 6; 10 3 5 4; 8 -2 0 6 </tt> */
    public static int[][] preberi2i() {
        return strint2(preberi2(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi2i</tt>, le da bere iz datoteke. */
    public static int[][] preberi2i(String datoteka) {
        return strint2(preberi2(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>double[]</tt>. */
    public static double[] preberi1d() {
        return strdouble1(preberi1(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>double[]</tt>. */
    public static double[] preberi1d(String datoteka) {
        return strdouble1(preberi1(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>double[][]</tt>. */
    public static double[][] preberi2d() {
        return strdouble2(preberi2(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>double[][]</tt>. */
    public static double[][] preberi2d(String datoteka) {
        return strdouble2(preberi2(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>boolean[]</tt>.  Vhod je možno vnesti v obliki (npr.)
     * <tt> true false true true </tt> ali <tt> 1 0 1 1 </tt>. */
    public static boolean[] preberi1b() {
        return strboolean1(preberi1(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>boolean[]</tt>. */
    public static boolean[] preberi1b(String datoteka) {
        return strboolean1(preberi1(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>boolean[][]</tt>. */
    public static boolean[][] preberi2b() {
        return strboolean2(preberi2(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>boolean[][]</tt>. */
    public static boolean[][] preberi2b(String datoteka) {
        return strboolean2(preberi2(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>String[]</tt>. */
    public static String[] preberi1s() {
        return strstr1(preberi1(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi1i</tt>, le da prebere tabelo tipa
     * <tt>String[]</tt>. */
    public static String[] preberi1s(String datoteka) {
        return strstr1(preberi1(odpri(datoteka)));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>String[][]</tt>. */
    public static String[][] preberi2s() {
        return strstr2(preberi2(new Scanner(System.in).nextLine()));
    }

    /** Enako kot <tt>preberi2i</tt>, le da prebere tabelo tipa
     * <tt>String[][]</tt>. */
    public static String[][] preberi2s(String datoteka) {
        return strstr2(preberi2(odpri(datoteka)));
    }

    /** Odpre datoteko in vrne bralnik zanjo. */
    private static Scanner odpri(String datoteka) {
        try {
            return new Scanner(new File(datoteka));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /** Prebere posamezne besede, ločene s presledki, v seznam. */
    private static List<String> preberi1(Scanner vhod) {
        List<String> seznam = new ArrayList<>();
        while (vhod.hasNext()) {
            seznam.add(vhod.next());
        }
        return filtriraj(seznam);
    }

    /** Prebere posamezne besede, ločene s presledki, v seznam. */
    private static List<String> preberi1(String vhod) {
        List<String> seznam = Arrays.asList(vhod.trim().split("\\s+"));
        return filtriraj(new ArrayList<>(seznam));
    }

    /** Odstrani prazne nize iz podanega seznama in vrne referenco na
     * predelan seznam. */
    private static List<String> filtriraj(List<String> seznam) {
        Iterator<String> iterator = seznam.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s == null || s.isEmpty()) {
                iterator.remove();
            }
        }
        return seznam;
    }

    /** Prebere posamezna zaporedja s presledki ločenih elementov v seznam
     * seznamov.  Zaporedja so med seboj ločena s podpičji. */
    private static List<List<String>> preberi2(Scanner vhod) {
        List<List<String>> seznam = new ArrayList<>();
        List<String> zadnjiPodseznam = null;
        while (vhod.hasNextLine()) {
            String vrstica = vhod.nextLine();
            String[] razdelki = (" " + vrstica + " ").split(";");
            boolean prvic = true;
            for (String razdelek: razdelki) {
                if (prvic && zadnjiPodseznam != null) {
                    zadnjiPodseznam.addAll(preberi1(new Scanner(razdelek)));
                } else {
                    zadnjiPodseznam = preberi1(new Scanner(razdelek));
                    seznam.add(zadnjiPodseznam);
                }
                prvic = false;
            }
        }
        return seznam;
    }

    /** Prebere posamezna zaporedja s presledki ločenih elementov v seznam
     * seznamov.  Zaporedja so med seboj ločena s podpičji. */
    private static List<List<String>> preberi2(String vhod) {
        String[] razdelki = vhod.split(";");
        List<List<String>> seznam = new ArrayList<>();
        for (String razdelek: razdelki) {
            seznam.add(preberi1(razdelek));
        }
        return seznam;
    }

    /** Pretvori seznam nizov v tabelo tipa <tt>int[]</tt>,
     * npr. ["3", "-4", "2"] v [3, -4, 2]. */
    private static int[] strint1(List<String> seznam) {
        int[] rezultat = new int[seznam.size()];
        int i = 0;
        for (String element: seznam) {
            rezultat[i++] = Integer.parseInt(element);
        }
        return rezultat;
    }

    /** Pretvori seznam seznamov nizov v tabelo tipa <tt>int[][]</tt>,
     * npr. [["3.1e2", "-4.3"], ["-0.04", "-1.8e-1]] v 
     * [[3.1e2, -4.3], [-0.04, -1.8e-1]]. */
    private static int[][] strint2(List<List<String>> seznam) {
        int[][] rezultat = new int[seznam.size()][];
        int i = 0;
        for (List<String> podseznam: seznam) {
            rezultat[i++] = strint1(podseznam);
        }
        return rezultat;
    }

    /** Pretvori seznam nizov v tabelo tipa <tt>double[]</tt>. */
    private static double[] strdouble1(List<String> seznam) {
        double[] rezultat = new double[seznam.size()];
        int i = 0;
        for (String element: seznam) {
            rezultat[i++] = Double.parseDouble(element);
        }
        return rezultat;
    }

    /** Pretvori seznam seznamov nizov v tabelo tipa <tt>double[][]</tt>. */
    private static double[][] strdouble2(List<List<String>> seznam) {
        double[][] rezultat = new double[seznam.size()][];
        int i = 0;
        for (List<String> podseznam: seznam) {
            rezultat[i++] = strdouble1(podseznam);
        }
        return rezultat;
    }

    /** Pretvori seznam nizov v tabelo tipa <tt>boolean[]</tt>,
     * npr. ["1", "false", 0, "true"] v [true, false, false, true]. */
    private static boolean[] strboolean1(List<String> seznam) {
        boolean[] rezultat = new boolean[seznam.size()];
        int i = 0;
        for (String element: seznam) {
            switch (element) {
                case "1":
                case "true":
                    rezultat[i] = true;
                    break;
                case "0":
                case "false":
                    rezultat[i] = false;
                    break;
                default:
                    throw new InputMismatchException("Neveljaven element: " + element);
            }
            i++;
        }
        return rezultat;
    }

    /** Pretvori seznam seznamov nizov v tabelo tipa <tt>boolean[][]</tt>. */
    private static boolean[][] strboolean2(List<List<String>> seznam) {
        boolean[][] rezultat = new boolean[seznam.size()][];
        int i = 0;
        for (List<String> podseznam: seznam) {
            rezultat[i++] = strboolean1(podseznam);
        }
        return rezultat;
    }

    /** Pretvori seznam nizov v tabelo tipa <tt>String[]</tt>. */
    private static String[] strstr1(List<String> seznam) {
        return seznam.toArray(new String[0]);
    }

    /** Pretvori seznam seznamov nizov v tabelo tipa <tt>String[][]</tt>. */
    private static String[][] strstr2(List<List<String>> seznam) {
        String[][] rezultat = new String[seznam.size()][];
        int i = 0;
        for (List<String> podseznam: seznam) {
            rezultat[i++] = strstr1(podseznam);
        }
        return rezultat;
    }

}

