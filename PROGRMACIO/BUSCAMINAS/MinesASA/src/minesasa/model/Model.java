package minesasa.model;
import minesasa.vista.Vista;

/**
 * Classe amb tot l'esquelet del joc, on es fan les funcions principals per ha que funcioni el joc.
 */
public class Model {
    private static int nFiles, nColumnes, nBombes;
    private static boolean jocAcabatBl;
    private static char[][] campO;
    private static char[][] campV;

    /**
     * Funcio que anira cridant les altres funcions per iniciar els camps, posar bombes i mostrar els camps.
     * @param nF Variable de tipus int.
     * @param nC Variable de tipus int.
     * @param nB Variable de tipus int.
     */
    public static void iniciarJoc(int nF, int nC, int nB) {
        jocAcabatBl = false;
        nFiles = nF;
        nColumnes = nC;
        nBombes = nB;
        campO = new char[nFiles + 2][nColumnes + 2];
        campV = new char[nFiles + 2][nColumnes + 2];

        iniciarCampMines(campO, ' ');
        iniciarCampMines(campV, '.');

        posarBombesAle();

        comptarBombesVoltant();

        System.out.println();
        Vista.mostrarCampMines(campO);
        System.out.println();
        Vista.mostrarCampMines(campV);
        System.out.println();

    }

    /**
     * Funcio que comprovara si la fila i columna que introdueixi l'usuari, entren al nostre camp de mines.
     * @param nFilesUsu Variable de tipus int.
     * @param nColumnesUsu Variable de tipus int.
     * @return Ens retornara un boolea.
     */
    public static boolean comprovarFilesColumnes(int nFilesUsu, int nColumnesUsu) {

        return (nFilesUsu <= nFiles && nFilesUsu >= 1) && (nColumnesUsu <= nColumnes && nColumnesUsu >= 1);

    }

    /**
     * Funcio que a partir de una fila i columna, probara de trepitjar la casella i fara certes accions.
     * @param filaUsu Variable de tipus int.
     * @param columUsu Variable de tipus int.
     */
    public static void trepitjar(int filaUsu, int columUsu) {
        if (campV[filaUsu][columUsu] != '.') System.out.println("Aquesta casella ja s'ha trepitjat o has posat una bandera");
        else if (campO[filaUsu][columUsu] == 'B') {
            System.out.println("Has trepitjat una bomba :(");
            jocAcabatBl = true;
            mostrarSolucio();
        }
        else if (campO[filaUsu][columUsu] != 'B') {
            trepitjarRecursivament(filaUsu, columUsu);
            if (!comprovarGuanyat()) Vista.mostrarCampMines(campV);
        }
        if (comprovarGuanyat()) {
            jocAcabatBl = true;
            System.out.println("Has guanyat");
            mostrarSolucio();
        }

    }

    /**
     * Funcio que a partir de una fila i columna, probara de trepitjar la casella i fara certes accions.
     * @param filaUsu Variable de tipus int.
     * @param columUsu Variable de tipus int.
     */
    public static void posarBandera(int filaUsu, int columUsu) {
        if (campV[filaUsu][columUsu] == '.') campV[filaUsu][columUsu] = 'B';
        else if (campV[filaUsu][columUsu] == 'B') campV[filaUsu][columUsu] = '.';
        else System.out.println("Aquesta casella ja s'ha trepitjat o has posat una bandera");
        if (comprovarGuanyat()) {
            jocAcabatBl = true;
            System.out.println("Has guanyat");
            mostrarSolucio();
        } else Vista.mostrarCampMines(campV);
    }

    /**
     * Funcio per comprovar si el joc s'ha acabat, ja sigui per mort o perque l'usuari ha guanyat.
     * @return Ens retornara un boolea.
     */
    public static boolean jocAcabat() {
        return !jocAcabatBl;
    }

    private static void trepitjarVoltant(int fila, int columna) {
        if (campV[fila][columna] == '.') campV[fila][columna] = campO[fila][columna];
        if(campO[fila - 1][columna - 1] != 'B') campV[fila - 1][columna - 1] = campO[fila - 1][columna - 1];
        if(campO[fila - 1][columna] != 'B') campV[fila - 1][columna] = campO[fila - 1][columna];
        if(campO[fila - 1][columna + 1] != 'B') campV[fila - 1][columna + 1] = campO[fila - 1][columna + 1];
        if(campO[fila][columna - 1] != 'B') campV[fila][columna - 1] = campO[fila][columna - 1];
        if(campO[fila][columna + 1] != 'B') campV[fila][columna + 1] = campO[fila][columna + 1];
        if(campO[fila + 1][columna - 1] != 'B') campV[fila + 1][columna - 1] = campO[fila + 1][columna - 1];
        if(campO[fila + 1][columna] != 'B') campV[fila + 1][columna] = campO[fila + 1][columna];
        if(campO[fila + 1][columna + 1] != 'B') campV[fila + 1][columna + 1] = campO[fila + 1][columna + 1];
    }

    private static void trepitjarRecursivament(int fila, int columna) {
        if (!comprovarFilesColumnes(fila,columna)) return;

        if (campV[fila][columna] != '.') return;

        campV[fila][columna] = campO[fila][columna];

        if(campV[fila][columna] == ' ') {
            trepitjarRecursivament(fila - 1, columna - 1);
            trepitjarRecursivament(fila - 1, columna);
            trepitjarRecursivament(fila - 1, columna + 1);
            trepitjarRecursivament(fila, columna - 1);
            trepitjarRecursivament(fila, columna + 1);
            trepitjarRecursivament(fila + 1, columna - 1);
            trepitjarRecursivament(fila + 1, columna);
            trepitjarRecursivament(fila + 1, columna + 1);
        }
    }

    private static void iniciarCampMines(char[][] campIniciar, char charCasella) {

        for(int i = 1; i < campIniciar.length - 1; ++i) {
            for (int j = 1; j < campIniciar[0].length - 1; ++j) {
                campIniciar[i][j] = charCasella;
            }
        }

    }

    private static void posarBombesAle() {
        int nAleF, nAleC;
        for (int x = 0; x < nBombes;) {
            nAleF = (int) Math.floor(Math.random()*((nFiles)-1+1)+1);
            nAleC = (int) Math.floor(Math.random()*((nColumnes)-1+1)+1);
            if (campO[nAleF][nAleC] != 'B') {
                campO[nAleF][nAleC] = 'B';
                ++x; //En cas que es repeteixi la posició on hi ha bomba, no aumnetara x++ i tornara a generar numeros aleatoris.
            }
        }

    }

    private static void comptarBombesVoltant() {

        for(int i = 1; i < campO.length - 1; ++i) {
            for (int j = 1; j < campO[0].length - 1; ++j) {
                if (campO[i][j] != 'B') {
                    int contaBombes = 0;
                    //Contar bombes
                    if (campO[i-1][j-1] == 'B') contaBombes++;
                    if (campO[i][j-1] == 'B') contaBombes++;
                    if (campO[i+1][j-1] == 'B') contaBombes++;
                    if (campO[i-1][j] == 'B') contaBombes++;
                    if (campO[i+1][j] == 'B') contaBombes++;
                    if (campO[i-1][j+1] == 'B') contaBombes++;
                    if (campO[i][j+1] == 'B') contaBombes++;
                    if (campO[i+1][j+1] == 'B') contaBombes++;

                    if (contaBombes > 0) {
                        campO[i][j] = (char) (contaBombes + '0');
                    }
                }
            }
        }
    }

    private static boolean comprovarGuanyat() {
        for (int i = 0; i < campO.length; ++i) {
            for (int j = 0; j < campO[0].length; ++j) {
                if (campV[i][j] != campO[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void mostrarSolucio() {
        System.out.println();
        System.out.println("La teva partida:");
        Vista.mostrarCampMines(campV);
        System.out.println();
        System.out.println("Solucio:");
        Vista.mostrarCampMines(campO);
    }

}
