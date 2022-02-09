package AceptaElReto;

import java.util.Locale;
import java.util.Scanner;

public class palabraspentavo300 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int v = scan.nextInt();
        scan.nextLine();

        for (int f = 0; f < v; ++f) {
            String fra = "";

            int a = 0, e = 0, i = 0, o = 0, u = 0;

            fra = scan.nextLine().trim().toLowerCase();

            for (int z = 0; z < fra.length(); ++z) {

                if (String.valueOf(fra.charAt(z)).equals("a")) ++a;
                if (String.valueOf(fra.charAt(z)).equals("e")) ++e;
                if (String.valueOf(fra.charAt(z)).equals("i")) ++i;
                if (String.valueOf(fra.charAt(z)).equals("o")) ++o;
                if (String.valueOf(fra.charAt(z)).equals("u")) ++u;

            }

            if (a >= 1 && e >= 1 && i >= 1 && o >= 1 && u >= 1) System.out.println("SI");
            else System.out.println("NO");
        }
    }
}
