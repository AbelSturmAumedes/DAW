package minesasa.vista;

/**
 * Classe per guardar funcions, on es mostren coses per pantalla.
 */
public class Vista {

    /**
     * Funcio per mostrar una array bidimensional de tipus char.
     * @param campMostra Array bidimensional de tipus char.
     */
    public static void mostrarCampMines(char[][] campMostra) {
        for(int i = 0; i < campMostra.length - 1; ++i) {
            if (i == 0) {
                System.out.print(" " + "  ");
            } else {
                System.out.print((char) (i + '@') + "  ");
            }
            for (int j = 1; j < campMostra[0].length - 1; ++j) {
                if (i == 0 && j < 9) System.out.print(j + "  ");
                else if (i == 0 && j >= 9) System.out.print(j + " ");
                else System.out.print(campMostra[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Funcio per mostrar per pantalla una string.
     * @param missatge Variable de tipus String.
     */
    public static void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }
}
