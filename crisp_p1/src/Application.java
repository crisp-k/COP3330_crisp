public class Application {
    public static void main(String[] args){
        String data = "3425";

        System.out.printf("Data before Encryption: %s\n", data);

        data = Encrypter.encrypt(data);

        System.out.printf("Data after Encryption: %s\n", data);

        data = Decrypter.decrypt(data);

        System.out.printf("Data after Decryption: %s\n", data);
    }
}
