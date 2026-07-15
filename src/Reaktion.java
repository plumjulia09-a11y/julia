import javax.swing.*;
import java.io.PrintStream;
import java.util.Scanner;

public class Reaktion {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);
        warte(out);
        warte(out);
        anfang(out, scanner);
    }

    static void anfang(PrintStream out, Scanner scanner) {
        out.println("Drücke Enter, wenn du bereit bist!");


    }


    static void warte(PrintStream out) {
        int random = (int) (Math.random() * 5) + 1;

    }
}
