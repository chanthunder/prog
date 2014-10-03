public class Sahovnica {
    private static int[][] napadena(int n, int[][] trdnjave) {
        int [][] tabela = new int[n][n];
        for (int i = 0; i < trdnjave.length; i++) {
            tabela[trdnjave[i][0]][trdnjave[i][1]] = -1;
            for (int k = 0; k < tabela.length; k++) {
                if (tabela[trdnjave[i][0]][k] != -1) {
                    tabela[trdnjave[i][0]][k] ++;
                } 
                if (tabela[k][trdnjave[i][1]] != -1) {
                    tabela[k][trdnjave[i][1]] ++;
                } 
            } 
        }
        return tabela;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] trdnjave = {{0, 3}, {1, 0}, {1, 2}, {2, 1},
            {2, 3}, {4, 1}};
        int[][] podatki=napadena(n, trdnjave);
        for (int i = 0; i < podatki.length; i++) {
            System.out.printf("{%s", "");
            for (int j = 0; j < podatki.length; j++) {
                System.out.printf("%2d,", podatki[i][j]);
            } 
            System.out.printf("%s}%n", "");
        }

    }
}
