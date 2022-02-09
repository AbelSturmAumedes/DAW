package AceptaElReto;

import java.util.Scanner;

public class encriptacion102 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pEncr = "";

        while (true){
            pEncr = scan.nextLine().trim();
            if (pEncr.equals("qGJO")) break;
            System.out.println(pEncr);

        }

    }
}
