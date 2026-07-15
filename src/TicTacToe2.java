import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class TicTacToe2 {

    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);

        JFrame frame;
        JButton[][] buttons = new JButton[3][3];

        char[][] feld = createFields(3, 3, ' ');

        zeigeSpielfeld(out, feld);

        boolean spielBeendet = false;
        boolean player1 = true;

        while (!spielBeendet) {

            int[] eingabe = eingabe(out, scanner);

            int x = eingabe[0] - 1;
            int y = eingabe[1] - 1;

            if (x >= 0 && x < 3 && y >= 0 && y < 3) {

                if (feld[x][y] == ' ') {


                    feld[x][y] = player1 ? 'X' : 'O';

                    zeigeSpielfeld(out, feld);

                    // Gewinner prüfen
                    if (hatGewonnen(feld)) {
                        out.println(player1 ? "Player 1 wins!" : "Player 2 wins!");
                        spielBeendet = true;
                    } else {
                        player1 = !player1;
                    }
                } else {
                    out.println("Dieses Feld ist bereits belegt!");
                }

            } else {
                out.println("Invalid input! Please enter numbers from 1 to 3.");
            }
        }
    }







    static void zeigeSpielfeld(PrintStream out, char[][] feld) {

        out.println("Let's play TicTacToe");

        out.println(feld[0][0] + " | " + feld[0][1] + " | " + feld[0][2]);
        out.println("---------");
        out.println(feld[1][0] + " | " + feld[1][1] + " | " + feld[1][2]);
        out.println("---------");
        out.println(feld[2][0] + " | " + feld[2][1] + " | " + feld[2][2]);
    }

    static int[] eingabe(PrintStream out, Scanner scanner) {

        out.println("Your Input (e.g. 1 1):");

        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);

        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();

        return new int[]{x, y};
    }

    static boolean hatGewonnen(char[][] feld) {
        //Zeilen
        for (int i = 0; i < feld.length; i++) {


            if (feld[i][0] != ' '
                    && feld[i][0] == feld[i][1]
                    && feld[i][1] == feld[i][2]) {

                return true;
            }
        }


        // Spalten
        for (int x = 0; x < feld[0].length; x++) {
            boolean result = feld[0][x] != ' ';
            for (int y = 0; y < feld.length - 1; y++) {

                result = result && feld[y][x] == feld[y + 1][x];
            }
            if (result) {

                return true;
            }
        }


        // Diagonale links oben -> rechts unten


        if (feld[0][0] != ' '
                && feld[0][0] == feld[1][1]
                && feld[1][1] == feld[2][2]) {

            return true;
        }


        // Diagonale rechts oben -> links unten


        if (feld[0][2] != ' '
                && feld[0][2] == feld[1][1]
                && feld[1][1] == feld[2][0]) {

            return true;
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