public class PopolnaStevila {
	public static void main(String[] args) {
		System.out.println("Vnesi zgornjo mejo: ");
        int nMax= BranjePodatkov.preberiInt();
		for (int st = 1; st <= nMax;st++ ) {
            if (jePopolno(st)) {
                System.out.println(st);
            } 

		}	
	}
    public static boolean jePopolno(int n) {
        /* sestevek deliteljev */
        int ds = 0;
        for (int i = 0; i <= n/2; i++) {
            if (n % i == 0) {
                ds += i;
            } 
        } 
        if (ds == n) {
            return true;
        } else {
            return false;
        } 
        /* return ds == n; */

        
    }
}
