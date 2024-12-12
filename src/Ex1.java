/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;

        if (!isNumber(num))
            return ans;

        int indexb = num.indexOf("b");
        if (indexb == -1){
            return Integer.parseInt(num);
        }

        String numPart = num.substring(0, indexb);
        String basePart = num.substring(indexb + 1);


        int base;
        char baseChar = basePart.charAt(0);
        if (Character.isDigit(baseChar)) {
            base = baseChar - '0';
        } else {
            base = baseChar - 'A' + 10;
        }
        if (base < 2 || base > 16) {
            return ans;
        }

            int result = 0;
        for (int i = 0; i < numPart.length(); i++) {
            char c = numPart.charAt(i);
            int value;

            if (Character.isDigit(c)) {
                value = c - '0';
            } else if (c >= 'A' && c <= 'G') {
                value = c - 'A' + 10;
            } else {
                return ans;
            }

            if (value >= base) {
                return ans;
            }

            result = (result * base) + value;

            if (result < 0) {
                return ans;
            }
        }
        return result;

    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.isEmpty())
            return false;

        if (!a.contains("b")) {
            for (int i = 0; i < a.length(); i++) {
                if (!Character.isDigit(a.charAt(i))) {
                    return false;
                }
            }
                return ans;
            }

         if (a.contains("b"))

        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            if (a.charAt(i) == 'b')
                count++;

            if (count > 1)
                return false;
        }

        int indexb = a.indexOf('b');
        if ( indexb == 0 || indexb == a.length() - 1)
            return false;


        String numPart = a.substring(0, indexb);
        String basePart = a.substring(indexb + 1);

        if (numPart.isEmpty() || basePart.isEmpty())
            return false;



        if (basePart.length() == 1) {
            char c = basePart.charAt(0);
            int base;


            if (Character.isDigit(c) && c >= '2' && c <= '9') {
                base = c - '0';
            } else if (c >= 'A' && c <= 'G') {
                base = c - 'A' + 10;
            } else
                return false;





            for (int i = 0; i < numPart.length(); i++) {
                char n = numPart.charAt(i);
                if (!((n >= '0' && n <= '9') || (n >= 'A' && n <= 'G')))
                    return false;

                int numValue;
                if (Character.isDigit(n)) {
                    numValue = n - '0';
                } else {
                    numValue = n - 'A' + 10;
                }
                if (numValue >= base)
                    return false;

            }

            return true;
        } else
            return false;

    }
    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number ( int num, int base){
            String ans = "";
            if ( num < 0 || base < 2 || base > 16 )
                return ans;

            while (num > 0) {
                int remainder = num % base;
                char digit;

                if (remainder < 10) {
                    digit = (char) ('0' + remainder);
                } else {
                    digit = (char) ('A' + remainder - 10);
                }

                ans = digit + ans;

                num /= base;
            }
        char baseChar = ' ';
        if (base >= 2 && base <= 9) {
            baseChar = (char) ('0' + base);
        } else if (base >= 10 && base <= 16) {
            baseChar = (char) ('A' + base - 10);
        }

            return ans+ "b"+ baseChar;

        }
    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
        public static boolean equals (String n1, String n2) {
            boolean ans = true;
            if (!isNumber(n1) || !isNumber(n2)) {
                return false;
            }
            int value1 = number2Int(n1);
            int value2 = number2Int(n2);
            if (value1 != value2) {
                return false;
            } else {
                return ans;
            }
        }
    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
        public static int maxIndex (String[]arr){
            int ans = -1;
            int max = -1;

            for(int i = 0; i < arr.length ; i++){
                String num = arr[i];
                if( isNumber(num)){
                    int value = number2Int(num);
                    if(value > max){
                     max = value;
                     ans = max;

                    }

                }
            }

            return ans;
        }
    }




