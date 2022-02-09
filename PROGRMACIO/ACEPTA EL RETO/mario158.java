package AceptaElReto;

import java.util.Scanner;

public class mario158 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int v = scan.nextInt();

        for (int a = 0; a < v; ++a) {
            int ns = scan.nextInt();
            int su = 0, sd = 0, s;

            s = scan.nextInt();

            for (int i = 1, j; i < ns ; ++i) {
                j = scan.nextInt();
                if (s > j) ++sd;
                else if (s < j) ++su;
                s = j;
            }

            System.out.println(su + " " + sd);
        }
    }
}
