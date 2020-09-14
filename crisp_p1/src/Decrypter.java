public class Decrypter {

    public static String decrypt(String data){
        int i, temp;
        int[] digits = new int[4];
        StringBuilder decryptedData = new StringBuilder();
        String[] charHold = new String[4];

        // Converts string character to ints and stores them in digits
        // Performs a check to undo changes made by encrypter
        for(i = 0; i < 4; i++){
            digits[i] = Integer.parseInt(String.valueOf(data.charAt(i)));
            if(digits[i] >= 7){
                digits[i] -= 7;
            }
            else if(digits[i] < 7){
                digits[i] += 3;
            }
        }

        // Performs digit swap
        temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        // Converts ints back to strings
        // and concatenates them into a single string
        for(i = 0; i < 4; i++){
            charHold[i] = Integer.toString(digits[i]);
            decryptedData.append(charHold[i]);
        }

        return decryptedData.toString();
    }

}
