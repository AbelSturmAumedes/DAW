package AceptaElReto;

import java.util.Scanner;

public class diabolico101 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int p, n, sf, sf1;
        boolean db, ca;
        int e, c, l, f, m, m2;
        boolean[] arrbole;
        int[][] ns;

        while (true) {


            p = Integer.valueOf(s.nextLine());
            if (p == 0) break;

            db = false;
            ca = false;
            arrbole = new  boolean[(p * p + 1)]; // array booleana per comprovar mes tard els valors
            ns = new int[p][p];

            //Bucle per agafar les dades del usu, un bucle for per a un "index" i l'altre per a l'altre "index"
            for (int i = 0; i < p; ++i) {
                for (int a = 0; a < p; ++a) {
                    n = s.nextInt();
                    ns[a][i] = n;
                }
            }
            s.nextLine();

            //Fer les comparacions i operacions per multiplicar els valors. (S'ha de programar.)
            //Sumar per columnes
            sf = 0;
            sf1 = 1;
            for (int i = 0; i < p; ++i) {
                for (int a = 0; a < p; ++a) {
                    sf += ns[a][i];
                }
                if (sf == sf1) db = true;
                sf1 = sf;
                sf = 0;
            }

            //Sumar per files
            sf = 0;
            sf1 = 1;
            for (int i = 0; i < p; ++i) {
                for (int a = 0; a < p; ++a) {
                    sf += ns[i][a];
                }
                if (sf == sf1 && db) db = true;
                sf1 = sf;
                sf = 0;
            }

            //Sumar diagonal
            sf = 0;
            sf1 = 0;
            for (int i = 0; i < p; ++i) {
                sf += ns[i][i];
            }
            for (int i = p - 1, a = 0; i >= 0; --i, ++a) {
                sf1 += ns[a][i];
            }
            if (sf == sf1 && db) db = true;

            //si no es cap de les atres opcions mostrara "NO" i ignorarem la resta del codi
            if (!db) {
                System.out.println("NO");
                continue;
            }

            //Bucle per comprovar si algun valor supera p*p
            for (int i = 0; i < p; ++i) {
                for (int a = 0; a < p; ++a) {
                    if (ns[a][i] < (p * p)) ca = true;
                    else {
                        ca = false;
                        break;
                    }
                    if (!ca) break;
                }

            }

            if (!ca) {
                System.out.println("DIABOLICO");
                continue;
            }

            //Bucle per comprovar si els numeros són iguals entre ells.
            for (int i = 0; i < p; ++i) {
                for (int a = 0; a < p; ++a) {
                    n = ns[a][i];
                    arrbole[n] = true;
                }
            }

            for (int y = 1; y < (p * p); ++y) {
                if (arrbole[y]) ca = true;
                else {
                    System.out.println("DIABOLICO");
                    ca = false;
                    break;
                }
            }

            if (!ca) {
                continue;
            }

            //Comprovarem si p es par o impar i farem les operacons que toca.
            f = p -1;
            m = (p - 1) / 2;
            m2 = m + 1;
            if (p % 2 == 0) {

                e = (ns[0][0] + ns[0][f] + ns[f][0] + ns[f][f]) * 2;
                l = ns[m][0] + ns[m2][0] + ns[m][f] + ns[m2][f] + ns[0][m] + ns[0][m2] + ns[f][m] + ns[f][m2];
                c = (ns[m][m] + ns[m2][m] + ns[m][m2] + ns[m2][m2]) * 2;

            }
            else  {

                e = ns[0][0] + ns[0][f] + ns[f][0] + ns[f][f];
                l = ns[m][0] + ns[m][f] + ns[0][m] + ns[f][m];
                c = ns[m][m] * 4;

            }

            //Mostrem els resultats finals.
            if (e == c && e == l) System.out.println("ESOTERICO");

        }
    }
}
