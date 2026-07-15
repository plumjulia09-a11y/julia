import java.io.PrintStream;
import java.util.Scanner;

public class ZahlenRaten {
    int num = (int) (Math.random() * 100) + 1;

    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);
        //random(scanner);
        kontrolle(out, scanner);
    }



    static int kontrolle(PrintStream out, Scanner scanner) {

        int klein = 1;
        int groß = 100;

        out.println("Zahl von " + klein + "-" + groß);

        int Zahl = scanner.nextInt();

        ZahlenRaten myObj = new ZahlenRaten();

        while (Zahl != myObj.num) {
            if (Zahl < klein || Zahl > groß) {
                out.println("Zahl nicht im Zahlenbereich!");
                out.println("Bitte Zahl zwischen " + klein + "-" + groß + " eingeben:");
                Zahl = scanner.nextInt();
                continue;
            }

            if (Zahl < myObj.num) {

                out.print("Zahl zu klein!");
                klein = Zahl;


            } else if (Zahl > myObj.num) {
                out.print("Zahl zu Groß! ");
                groß = Zahl;



            } else {
                out.println("Zalhl nicht im Zahlernbereich");

            }
            out.println( "\n"+ "Die Zahl befindet sich zwischen " + klein + "-" + groß + " Neue Zahl:");
            Zahl = scanner.nextInt();
        }
        out.println("Korrekt!");
        return Zahl;

    }


}
