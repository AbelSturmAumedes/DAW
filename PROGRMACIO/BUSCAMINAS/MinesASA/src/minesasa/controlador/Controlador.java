package minesasa.controlador;

import minesasa.model.Model;

import java.util.Scanner;

/**
 * Classe per començar el joc i fer tots els contorls necessaris.
 */
public class Controlador {
    private static Scanner scan = new Scanner(System.in);
    private static int files, columnes, nBobmes;

    private static int columUsu, filaUsu;

    private static char accioUsu = ' ';

    /**
     * Funcio principal per començar el joc i cridar a les demes funcions.
     */
    public static void jugar() {

        while (true) {
            int opcio;

            System.out.println("Quin nivell vols jugar?");
            System.out.println("1 - 8x8 (10 bombes)");
            System.out.println("2 - 16x16 (40 bombes)");
            System.out.println("3 - 16x30 (99 bombes)");
            System.out.println("4 - Personalitzat");
            System.out.println("0 - Sortir del programa");
            System.out.print("Quina opció vols? ");

            opcio = scan.nextInt();

            menuInicial(opcio);

            if (opcio == 0) {
                System.out.println("Gracies per jugar");
                return;
            }

            Model.iniciarJoc(files,columnes,nBobmes);

            do {
                agafarDadesAP();

                if (accioUsu != 'T' && accioUsu != 'B') {
                    System.out.println("Gracies per jugar");
                    return;
                } else if (accioUsu == 'T') Model.trepitjar(filaUsu, columUsu);
                else Model.posarBandera(filaUsu, columUsu);

            } while (Model.jocAcabat());

            System.out.println();

        }

    }

    private static void menuInicial(int opcio) {

        do {
            switch (opcio) {
                case 1:
                    files = 8;
                    columnes = 8;
                    nBobmes = 10;
                    return;
                case 2:
                    files = 16;
                    columnes = 16;
                    nBobmes = 40;
                    return;
                case 3:
                    files = 16;
                    columnes = 30;
                    nBobmes = 99;
                    return;
                case 4:
                    System.out.print("Quantes files, columnes i bombes vols? {ex: 10 10 5} ");
                    files = scan.nextInt();
                    columnes = scan.nextInt();
                    nBobmes = scan.nextInt();
                case 0:
                    return;
                default:
                    System.out.println("No es una opcio correcte");
                    opcio = scan.nextInt();

            }
        } while (true);

    }

    private static void agafarDadesAP() {
        String accioFrase;
        char filaUsuChar;

        do {
            System.out.print("Vols Trepitjar, posar Bandera o Acabar? {T/B/A} ");
            accioUsu = scan.next().charAt(0);
        } while (accioUsu != 'T' && accioUsu != 'B' && accioUsu != 'A');


        if (accioUsu != 'T' && accioUsu != 'B') return;

        //Aixo ho farm servir després per canviar la frase. Canviarà la frase si es vol, trepitjar o posar bandera
        if (accioUsu == 'T') accioFrase = "trepitjar";
        else accioFrase = "posar una bandera";

        do {
            System.out.print("A quina posicio vols "+ accioFrase +"? {ex: B 2} ");
            filaUsuChar = scan.next().charAt(0);
            filaUsu = (int) filaUsuChar - 64;
            columUsu = scan.nextInt();

            if(!Model.comprovarFilesColumnes(filaUsu, columUsu)) System.out.println("Has d'entrar una posició correcte");

        } while (!Model.comprovarFilesColumnes(filaUsu, columUsu));

    }
}
