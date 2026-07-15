import java.io.PrintStream;

public class Snake {


    public static void main(String[] args) {
        PrintStream out = System.out;
        spielfeld(out);
    }

    static void spielfeld(PrintStream out) {

            int zeile= 10 ;
            int spalte= 10;

            char[][] feld = new char[zeile][spalte];

            //feld bauen
            for (int i = 0; i < zeile; i++) {

            for (int x = 0; x < spalte; x++) {
                feld [i][x]= ('\u25A1');

            }

        }

        // Schlange setzen
        feld[4][4] = 'O';


        // Feld ausgeben
        for (int i = 0; i < zeile; i++) {

            for (int x = 0; x < spalte; x++) {

                out.print(feld[i][x] + " ");

            }

          out.println();
        }
    }
}


