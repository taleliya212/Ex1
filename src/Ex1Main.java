import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";


        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");


            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals("quit")) {
                System.out.println("quiting now...");
                break;
            }

            if (!Ex1.isNumber(num1)) {
                System.out.println("num1 = " + num1 + "  is number: false , value: -1\nERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }

            if (Ex1.isNumber(num1)) {
                System.out.println("num1 = " + num1 + "  is number: true , value:" + Ex1.number2Int(num1));
            }


            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals("quit")) {
                System.out.println("quiting now...");
                break;
            }

            if (!Ex1.isNumber(num2)) {
                System.out.println("num2 = " + num2 + "  is number: false , value: -1\nERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }

            if (Ex1.isNumber(num2)) {
                System.out.println("num2 = " + num2 + "  is number: true , value:" + Ex1.number2Int(num2));
            }


            System.out.println("Enter a base for output: a number [2,16] ");
            int base = sc.nextInt();

            if (base < 2 || base > 16) {
                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")\n");
                continue;
            }



            int num01 = Ex1.number2Int(num1);
            int num02 = Ex1.number2Int(num2);


            String add = Ex1.int2Number(num01 + num02, base);
            System.out.println(num1 + " + " + num2 + " = " + add);

            String sum = Ex1.int2Number(num01 * num02, base);
            System.out.println(num1 + " * " + num2 + " = " + sum);



            String[] arr = {num1, num2, add, sum};
            int maxInd = Ex1.maxIndex(arr);



                System.out.println("Max number over " + Arrays.toString(arr) + " is:" + Ex1.int2Number(maxInd, base));

        }

    }
}