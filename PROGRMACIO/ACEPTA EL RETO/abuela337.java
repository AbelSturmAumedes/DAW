package AceptaElReto;

import java.util.Scanner;

public class abuela337 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cp = scan.nextInt();

        for (int i = 0; i < cp; ++i) {
            int[] ds = new int[6];
            int[] da = new int[6];
            int[] sum = new int[6];

            boolean enca = true;


            for (int a = 0; a < 6 ; ++a) {
                ds[a] = scan.nextInt();
            }
            for (int a = 0; a < 6 ; ++a) {
                da[a] = scan.nextInt();
            }
            for (int a = 0; a < 6 ; ++a) {
                sum[a] = (ds[a] + da[a]);
            }

            for (int a = 0; a < sum.length - 1 ; ++a) {
                if (sum[a] != sum[a + 1]) {
                    enca = false;
                    break;
                }
            }

            if (!enca) System.out.println("NO");
            else System.out.println("SI");
        }



    }
}
