public class Decrypter {

    public static String decrypt(String data){
        int[] digits = new int[4];
        StringBuilder decryptedData = new StringBuilder();
        String[] charHold = new String[4];

        // Converts string character to ints and stores them in digits
        // Performs a check to undo changes made by encrypter
        convertToDigitArray(data, digits);

        // Performs digit swap
        digitSwap(digits);

        // Converts ints back to strings
        // and concatenates them into a single string
        convertToDigitString(digits, decryptedData, charHold);

        return decryptedData.toString();
    }

    public static void convertToDigitString(int[] digits, StringBuilder decryptedData, String[] charHold) {
        int i;
        for(i = 0; i < 4; i++){
            charHold[i] = Integer.toString(digits[i]);
            decryptedData.append(charHold[i]);
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
            if(digits[i] >= 7){
                digits[i] -= 7;
            }
            else if(digits[i] < 7){
                digits[i] += 3;
            }
        }
    }

}
