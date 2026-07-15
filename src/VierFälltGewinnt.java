import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class VierFälltGewinnt {

    public static void main(String[] args) {

        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);


        char[][] feld = createFields(6, 7, ' ');

        zeigeSpielfeld(out, feld);

        boolean spielBeendet = false;
        boolean player1 = true;


        while (!spielBeendet) {

            int x = eingabe(out, scanner);

            if (x >= 0 && x < feld[0].length) {

                int y = findeFreienPlatz(feld, x);


                if (y != -1) {

                    feld[y][x] = player1 ? 'X' : 'O';


                    zeigeSpielfeld(out, feld);


                    if (hatGewonnen(feld)) {

                        out.println(player1 ? "Player 1 wins!" : "Player 2 wins!");

                        spielBeendet = true;


                    } else if (istVoll(feld)) {

                        out.println("Unentschieden!");

                        spielBeendet = true;


                    } else {

                        player1 = !player1;

                    }


                } else {

                    out.println("Diese Spalte ist voll!");

                }


            } else {

                out.println("Ungültige Spalte!");

            }

        }


        scanner.close();

    }


    static void zeigeSpielfeld(PrintStream out, char[][] feld) {


        for (int y = 0; y < feld.length; y++) {


            for (int x = 0; x < feld[y].length; x++) {


                out.print(feld[y][x] + " | ");


            }


            out.println();

        }


        out.println();

    }


    static int eingabe(PrintStream out, Scanner scanner) {


        out.println("Welche Spalte (1-7)?");


        return scanner.nextInt() - 1;

    }


    static int findeFreienPlatz(char[][] feld, int x) {


        for (int y = feld.length - 1; y >= 0; y--) {


            if (feld[y][x] == ' ') {


                return y;

            }

        }


        return -1;

    }


    static boolean istVoll(char[][] feld) {


        for (int y = 0; y < feld.length; y++) {


            for (int x = 0; x < feld[y].length; x++) {


                if (feld[y][x] == ' ') {


                    return false;

                }

            }

        }


        return true;

    }


    static boolean hatGewonnen(char[][] feld) {


        int höhe = feld.length;
        int breite = feld[0].length;


        // Zeilen →
        for (int y = 0; y < höhe; y++) {


            for (int x = 0; x < breite - 3; x++) {


                boolean result = feld[y][x] != ' ';


                for (int i = 0; i < 3; i++) {


                    result = result && feld[y][x] == feld[y][x + i + 1];


                }


                if (result) {


                    return true;


                }

            }

        }


        // Spalten ↓
        for (int x = 0; x < breite; x++) {


            for (int y = 0; y < höhe - 3; y++) {


                boolean result = feld[y][x] != ' ';


                for (int i = 0; i < 3; i++) {


                    result = result && feld[y][x] == feld[y + i + 1][x];


                }


                if (result) {


                    return true;


                }

            }

        }
        // Diagonale links oben -> rechts unten
        for (int y = 0; y < höhe - 3; y++) {

            for (int x = 0; x < breite - 3; x++) {

                boolean result = feld[y][x] != ' ';


                for (int i = 0; i < 3; i++) {

                    result = result && feld[y][x] == feld[y + i + 1][x + i + 1];

                }


                if (result) {

                    return true;

                }

            }

        }


        // Diagonale rechts oben -> links unten
        for (int y = 0; y < höhe - 3; y++) {

            for (int x = 3; x < breite; x++) {

                boolean result = feld[y][x] != ' ';


                for (int i = 0; i < 3; i++) {

                    result = result && feld[y][x] == feld[y + i + 1][x - i - 1];

                }


                if (result) {

                    return true;

                }

            }

        }


        return false;

    }


    static char[][] createFields(int height, int width, char filling) {


        char[][] result = new char[height][width];


        for (int y = 0; y < height; y++) {


            Arrays.fill(result[y], filling);


        }


        return result;

    }

}