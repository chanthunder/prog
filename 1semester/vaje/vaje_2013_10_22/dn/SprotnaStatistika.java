public class SprotnaStatistika {

    public static void main(String[] args) {

            double b = 0;
            double max = 0;
            double min = 0;
            double vsota = 0;
            double vsotaKvadratov = 0;
            double stdev = 0;
            double avg = 0;
            int i = 1;

            while (!Double.isNaN(b)) {
                System.out.println("Vnesi realno stevilo");
                double a = BranjePodatkov.preberiDouble();
                b = a;
                if (i == 1) {
                 max = a;
                 min = a;
                 vsota += a;
                 vsotaKvadratov += a*a;
                 avg = a;
                } else {
                    if (a > max)
                        max = a;
                    if (a < min)
                        min = a;
                    vsota += a;
                    vsotaKvadratov += a*a;
                    avg = vsota / i;
                    stdev = Math.sqrt((vsotaKvadratov / i) - ((vsota / i) * (vsota / i)));
                }
                System.out.printf("%f", max);
                System.out.print(" | ");
                System.out.printf("%f", min);
                System.out.print(" | ");
                System.out.printf("%f", avg);
                System.out.print(" | ");
                System.out.printf("%f%n", stdev);
                i+=1;   

            }
    }
}
