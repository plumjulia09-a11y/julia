import java.io.PrintStream;
import java.util.Scanner;
import java.math.BigInteger;


public class hello {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);

        count(scanner, out);
        add(scanner, out);
        multiply(scanner, out);
        addSpceial(scanner, out);
        multiplySpecial(scanner, out);
    }

    static void count(Scanner scanner, PrintStream out) {
        out.println("I will now count to 100");
        String line = scanner.nextLine();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);

        }

    }

    static void add(Scanner scanner, PrintStream out) {
        out.println("I will now add every number from 1 to 100");
        int summe = 0;
        String line = scanner.nextLine();
        for (int i = 1; i <= 100; i++) {

            summe += i;

        }
        out.println(summe);
    }

    static void multiply(Scanner scanner, PrintStream out) {
        out.println("I will now multiply every number from 1 to 100");

        BigInteger produkt = BigInteger.ONE;

        String line = scanner.nextLine();
        int i;
        for (i = 1; i <= 100; i++) {
            produkt = produkt.multiply(BigInteger.valueOf(i));

        }
        out.println(produkt);
    }

    static void addSpceial(Scanner scanner, PrintStream out) {
        out.println("I will now add every number from 98 to 1008");
        int summe = 0;
        String line = scanner.nextLine();
        for (int i = 98; i <= 1008; i++) {

            summe += i;

        }
        out.println(summe);
    }


    static void multiplySpecial(Scanner scanner, PrintStream out) {
            long summe = 0;
        for (int i = 11; i <= 50; i++) {

            long produkt = 1;
            for (int j= i ; j<= i+4 ; j++) {
                produkt*= j;


            }
            summe += produkt;
        }
                out.print(summe);
    }

}