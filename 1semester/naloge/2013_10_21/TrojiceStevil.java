
public class TrojiceStevil {

	public static void main(String[] args) {
        System.out.print("Vnesite zgornjo mejo: ");
        int n = BranjePodatkov.preberiInt();
        System.out.print("Vnesite GCD: ");
        int d = BranjePodatkov.preberiInt();
        for (int i = d; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    TrojiceStevil stevilo = new TrojiceStevil();
                    if (stevilo.gcd(stevilo.gcd(i,j),k) == d) {
                        System.out.printf("(%d, %d, %d)%n", i, j, k);

                    }
                } 
            } 
        } 


	}
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        } 
    }

}
