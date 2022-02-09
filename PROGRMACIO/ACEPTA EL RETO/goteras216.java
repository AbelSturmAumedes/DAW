package AceptaElReto;

import java.util.Scanner;

public class goteras216 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int v = scan.nextInt();
        scan.nextLine();

        for (int f = 0; f < v; ++f) {

            int h, m, mt, s,st = scan.nextInt();
            scan.nextLine();

            mt = st / 60;
            s = st % 60;
            h =  mt / 60;
            m = mt % 60;
            System.out.printf("%02d:%02d:%02d\n", h, m, s);

        }
    }
}
