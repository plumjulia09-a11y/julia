import java.io.PrintStream;
import java.util.Scanner;


public class Arrays {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner scanner = new Scanner(System.in);

        // nummer 1
        ganzzahlen(scanner, out);
        //nummer 2
        lenght(scanner, out);
        //nummer 3
        durchschnitt(scanner, out);
        //nummer 4
        max(scanner, out);
        //nummer 5
        min(scanner, out);
        //nummer 6
        turn(scanner, out);
        //nummer 7
        search(scanner, out);
        //nummer 2.1
        zweidiemensional(scanner, out);
        //nummer 2.2
        addarry(scanner, out);
        //nummer 2.3
        biggest(scanner, out);
        //nummer 2.4
        diagonal(scanner, out);
        //nummer 2.5
        matrix(scanner, out);
        //nummer 2.6
        searchzweidimensonal(scanner, out);
        //nummer2.7
        summeeinzelnt(scanner, out);
    }

    // nummer 1
    static void ganzzahlen(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        out.println("The Numbers are: ");
        int[] myNum = {1, 2, 3, 4, 5};
        System.out.println(myNum[0]);
        System.out.println(myNum[1]);
        System.out.println(myNum[2]);
        System.out.println(myNum[3]);
        System.out.println(myNum[4]);
    }

    // nummer 2
    static void lenght(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        out.println("the lenght is: ");
        int[] myNum = {1, 2, 3, 4, 5};
        System.out.println(myNum.length);

    }

    // nummer 3
    static void durchschnitt(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[] myNum = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < myNum.length; i++) {
            sum += myNum[i];
        }
        out.println("The sum is: " + sum);
        out.println("The average is: " + sum / myNum.length);

    }

    //nummer 4
    static void max(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[] myNum = {1, 2, 3, 4, 5};

        int max = myNum[0];

        for (int i = 1; i < myNum.length; i++) {
            if (myNum[i] > max) {
                max = myNum[i];
            }
        }

        System.out.println("The higest number is: " + max);
    }

    //nummer 5
    static void min(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[] myNum = {1, 2, 3, 4, 5};

        int min = myNum[0];

        for (int i = 1; i < myNum.length; i++) {
            if (myNum[i] < min) {
                min = myNum[i];
            }
        }

        System.out.println("The lowest number is: " + min);
    }

    //nummer 6
    static void turn(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[] myNum = {1, 2, 3, 4, 5};

        for (int i = myNum.length - 1; i >= 0; i--) {
            System.out.println(myNum[i]);
        }
    }
        //nummer 7
    static void search(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[] myNum = {1, 2, 3, 4, 5};
        int gesucht = 3;
        for (int i = 0; i < myNum.length; i++) {
            if (myNum[i] == gesucht) {
                out.println("You searched number " + gesucht + " is at index: " + i);

            }

        }

    }

        //nummer 2.1
    static void zweidiemensional(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[][] myNum = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        out.println("there are these numbers in teh Array: ");
        out.println(myNum[0][0]);
        out.println(myNum[0][1]);
        out.println(myNum[0][2]);
        out.println(myNum[1][0]);
        out.println(myNum[1][1]);
        out.println(myNum[1][2]);
        out.println(myNum[2][0]);
        out.println(myNum[2][1]);
        out.println(myNum[2][2]);
    }

        //nummre 2.2
    static void addarry(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();
        int[][] myNum = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sum = 0;

        for (int i = 0; i < myNum.length; i++) {
            for (int j = 0; j < myNum[i].length; j++) {
                sum += myNum[i][j];
            }
        }

        System.out.println(" The sum of all these numbers are: " + sum);
    }
        //nummer 2.3
    static void biggest(Scanner scanner, PrintStream out) {
        String line = scanner.nextLine();

        int[][] myNum = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };
        int max = myNum[0][0];

        for (int i = 1; i < myNum.length; i++) {
            for (int j = 1; j < myNum.length; j++)
                if (myNum[i][j] > max) {
                    max = myNum[i][j];
                }
        }

        System.out.println("The biggest number is: " + max);
    }
        //nummer 2.4
    static void diagonal(Scanner scanner, PrintStream out) {

        String line = scanner.nextLine();

        int[][] myNum = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        out.println("From left top to the right bottem, it looks like this: ");
        out.print(myNum[0][0] + " ");
        out.print(myNum[1][1] + " ");
        out.println(myNum[2][2] + " ");


        out.println("From right top to to left bottem, it looks like this: ");
        out.print(myNum[0][2] + " ");
        out.print(myNum[1][1] + " ");
        out.println(myNum[2][0] + " ");
    }
        //nummer 2.5
    static void matrix(Scanner scanner, PrintStream out)
    { int[][] myNum = { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        String line = scanner.nextLine();
        int temp =myNum[0][1];
        myNum[0][1]=myNum[1][0];
        myNum[1][0]= temp;
        int temp1= myNum[0][2];
        myNum[0][2]=myNum[2][0];
        myNum[2][0]=temp1;
        int temp3= myNum[1][2];
        myNum[1][2]=myNum[2][1];
        myNum[2][1]=temp3;

        out.println(myNum[0][0]+" "+myNum[0][1]+" "+myNum[0][2]);
        out.println(myNum[1][0]+" "+myNum[1][1]+" "+myNum[1][2]);
        out.println(myNum[2][0]+" "+myNum[2][1]+" "+myNum[2][2]); }


            //nummer 2.6
    static void searchzweidimensonal(Scanner scanner, PrintStream out) {

        String line = scanner.nextLine();
        int[][] myNum = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int gesucht = 3;
        for (int i = 0; i < myNum.length; i++) {
            for (int j = 0; j < myNum[1].length; j++) {

                if (myNum[i][j] == gesucht) {
                    out.println("You searched number " + gesucht + " is at index: " + i + " " + j);

                }

            }

        }

    }

    //nummer 2.7
    static void summeeinzelnt(Scanner scanner, PrintStream out) {

        String line = scanner.nextLine();
        int[][] myNum = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum0 = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < myNum.length; i++) {
            sum0 += myNum[0][i];
        }
        for (int i = 0; i < myNum.length; i++) {
            sum1 += myNum[1][i];
        }
        for (int i = 0; i < myNum.length; i++) {
            sum2 += myNum[2][i];
        }
        out.println("The sum for row 0 is " + sum0);
        out.println("The sum for row 1 is " + sum1);
        out.println("The sum for row 1 is " + sum2);
    }




}








