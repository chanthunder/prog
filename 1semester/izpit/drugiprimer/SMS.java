public class SMS {
    public static void main(String[] args) {
        char[][] tipke = {
            {'0'},
            {' ', '1'},
            {'a', 'b', 'c', '2'},
            {'d', 'e', 'f', '3'},
            {'g', 'h', 'i', '4'},
            {'j', 'k', 'l', '5'},
            {'m', 'n', 'o', '6'},
            {'p', 'q', 'r', 's', '7'},
            {'t', 'u', 'v', '8'},
            {'w', 'x', 'y', 'z', '9'}
        };
        System.out.println(steviloPritiskov(tipke, 'z'));
        String vsebina = "Se";
        char[] charArray = vsebina.toCharArray();
        System.out.println(steviloPritiskov(tipke, charArray));
    }
    private static int steviloPritiskov(char[][] tipke, char znak) {
        for (int i = 0; i < tipke.length; i++) {
            for (int j = 0; j < tipke[i].length; j++) {
                if (tipke[i][j] == znak) {
                    return j+1;
                } 
            }
        } 
        return -1;
    }

    private static int steviloPritiskov(char[][] tipke, char[] besedilo) {
        int pritiski = 0;
        boolean male = true;
        for (int k = 0; k < besedilo.length; k++) {
            boolean obstaja = false;
            if (Character.isUpperCase(besedilo[k])) {
                besedilo[k] = Character.toLowerCase(besedilo[k]);
                if (male) { 
                    pritiski++;
                    male = false;
                }
            } else if (Character.isLowerCase(besedilo[k])) {
                if (!male) {
                    pritiski++;
                    male = true;
                } 
            } else {
                obstaja = false;

            }
            for (int i = 0; i < tipke.length; i++) {
                for (int j = 0; j < tipke[i].length; j++) {
                    if (tipke[i][j] == besedilo[k]) {
                        obstaja = true;
                        pritiski += j+1;
                    } 
                }
            } 
            if (!obstaja) {
                return -1;
            } 
        }
        return pritiski;
    }

}
