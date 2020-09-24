public class Encrypter {

    public static String encrypt(String data){
        int[] digits = new int[4];
        String[] charHold = new String[4];
        StringBuilder encryptedData = new StringBuilder();

        // Fills an array with digits from the converted string
        // Performs calculations on these digits
        convertToDigitArray(data, digits);

        // Swaps digits
        digitSwap(digits);

        // Converts digits back to strings and
        // Concatenates them back together
        covertToDigitString(digits, charHold, encryptedData);

/*          // A better way was found
        digit1 = Integer.parseInt(String.valueOf(data.charAt(0)));
        digit2 = Integer.parseInt(String.valueOf(data.charAt(1)));
        digit3 = Integer.parseInt(String.valueOf(data.charAt(2)));
        digit4 = Integer.parseInt(String.valueOf(data.charAt(3)));

        digit1 = (digit1 + 7) % 10;
        digit2 = (digit1 + 7) % 10;
*/

        return encryptedData.toString();
    }

    public static void covertToDigitString(int[] digits, String[] charHold, StringBuilder encryptedData) {
        int i;
        for(i = 0; i < 4; i++){
            charHold[i] = Integer.toString(digits[i]);
            encryptedData.append(charHold[i]);
        }
    }

    public static void digitSwap(int[] digits) {
        int temp;
        temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;
    }

    public static void convertToDigitArray(String data, int[] digits) {
        int i;
        for(i = 0; i < 4; i++){
            digits[i] = Integer.parseInt(String.valueOf(data.charAt(i)));
            digits[i] = (digits[i] + 7) % 10;
        }
    }

/*      // Java only passes variables by value :(
    public static Integer swap(int num1, int num2){
    }
*/
}
