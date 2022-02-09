package AceptaElReto;

import java.util.Scanner;
//Mirar si podem fer alguna cosa amb dos variables de tipus int i anar fent sumas a aquestes variables substituir les arrays per variables
public class juegoscintas620 {
    static int nJocs, midaCinta, midaCintaTotal, midaVariable, cara1, cara2;
    static int[] jocs;
    static String[] repetit;
    public static void main(String[] args) {

        agafarDades();
        if (superaMida()) {
            return;
        }
        posarValorsString();
        calculsMides();

    }

    static void agafarDades() {
        Scanner scan = new Scanner(System.in);

        midaCinta = scan.nextInt();
        midaCintaTotal = midaCinta * 2;
        nJocs = scan.nextInt();
        midaVariable = nJocs * 2;

        jocs = new int[nJocs];
        repetit = new String[nJocs * nJocs];

        for (int a = 0; a < nJocs ; ++a) {
            jocs[a] = scan.nextInt();
        }

        scan.close();
    }

    static boolean superaMida() {
        boolean supera = false;
        int suma = 0;

        for (int a = 0; a < nJocs; ++a) {
            suma += jocs[a];
        }

        if (suma > midaCintaTotal) {
            supera = true;
        }

        return supera;
    }

    static void posarValorsString() {
        for (int i = 0; i < repetit.length; ++i) {
            repetit[i] = "";
        }
    }

    /**
     * todo: trovar la manera de treure totes les convinacions posibles i tenint en compte les que es repetiran.
     * **/

    static void calculsMides() { //Mirar com fer sumes dels jocs, per saber si es supera
        boolean rep = false;
        for (int a = 0, z = 0; a < jocs.length; ++a) {
            for (int i = 0; i < jocs.length; ++i, ++z) {

                for (int j = 0; j < repetit.length; ++j) {
                    if (repetit[j].equals(jocs[a] + "" + jocs[i]) || repetit[j].equals(jocs[i] + "" + jocs[a])) {
                        rep = true;
                        break;
                    }
                }

                if ((a + 1 < jocs.length) && (a != i) && !rep && (jocs[a] + jocs[i] <= midaCinta)) {
                    System.out.println(jocs[a] + " " + jocs[i]);
                }

                rep = false;

                repetit[z] = jocs[a] + "" + jocs[i];//Buscar valors repetits d'alguna manera.

            }
        }
    }
}
