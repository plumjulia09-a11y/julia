import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class VierGewinnt {

    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);

        //Andern
        char[][] feld = createFields(6, 7, ' ');

        zeigeSpielfeld(out, feld);

        boolean spielBeendet = false;
        boolean player1 = true;

        while (!spielBeendet) {

            int[] eingabe = eingabe(out, scanner);

            int x = eingabe[0] - 1;
            int y = eingabe[1] - 1;

            if (x >= 0 && x < feld[0].length && y >= 0 && y < feld.length) {

                if (feld[y][x] == ' ') {
                    feld[y][x] = player1 ? 'X' : 'O';
                } else {
                    out.println("This Field is already taken!");
                }
                zeigeSpielfeld(out, feld);


                // Gewinner prüfen
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
                out.println("Invalid input!");
            }
        }
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

    static int[] eingabe(PrintStream out, Scanner scanner) {

        out.println("Your Input (Spalte Zeile):");
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        return new int[]{x, y};
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
        // ÄNDERUNG:

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
        } // Spalten ↓
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
        } // Diagonale links oben → rechts unten

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
        } // Diagonale rechts oben → links unten
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