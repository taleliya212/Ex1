public class Ex1 {
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




