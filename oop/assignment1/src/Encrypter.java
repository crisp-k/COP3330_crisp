public class Encrypter {

    public static String encrypt(String data){
        int i, temp;
        int[] digits = new int[4];
        String[] charHold = new String[4];
        StringBuilder encryptedData = new StringBuilder();

        // Converts string into ints, stored in array
        // Ints have calculations performed on them
        for(i = 0; i < 4; i++){
            digits[i] = Integer.parseInt(String.valueOf(data.charAt(i)));
            digits[i] = (digits[i] + 7) % 10;
        }

        // Digits are swapped
        temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        // Digits are reconverted to string and
        // concatenated into single string
        for(i = 0; i < 4; i++){
            charHold[i] = Integer.toString(digits[i]);
            encryptedData.append(charHold[i]);
        }

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

/*      // Java only passes variables by value :(
    public static Integer swap(int num1, int num2){
    }
*/
}
