// [WHILE]

// Napišite program, ki prebere pozitivno celo število in izpiše 
// najprej njegove enice, nato desetice, nato stotice itd.

public class Stevke {

    public static void main(String[] args) {
        System.out.print("Stevilo: ");
        int n = BranjePodatkov.preberiInt();

        while (n != 0) {
            int stevka = n % 10;
            System.out.print(stevka + " ");
            n = n / 10;
        }
        System.out.println();
    }
}
