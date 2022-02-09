package AceptaElReto;

import java.util.Scanner;

public class findemes313 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int v = scan.nextInt();
        scan.nextLine();

        for (int f = 0; f < v; ++f) {
            int n1 = 0, n2 = 0, c;

            n1 = scan.nextInt();
            n2 = scan.nextInt();
            scan.nextLine();


            if ((n1 + n2) >= 0) System.out.println("SI");
            else System.out.println("NO");
        }
    }
}
