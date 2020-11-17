package COP3330_cannon.cannon_p1.src;

public class Application {
    public static void main(String[] args) {
        String EncryptedValue = new Encrypter().encrypt("1234");
        System.out.println(EncryptedValue);
        String DecryptedValue = new COP3330_cannon.cannon_p1.src.Decrypter().decrypt("0189");
        System.out.println(DecryptedValue);
    }
}