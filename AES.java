import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static void main(String[] args) {
        try {
            byte[] key = "0123456789abcdef".getBytes();
            byte[] plaintext = "HelloAESROHIT".getBytes();
            System.out.println("pt : " + new String(plaintext));
            byte[] ciphertext = encrypt(plaintext, key);
            System.out.println("ct : " + byteToHex(ciphertext));
            byte[] deciphertext = decrypt(ciphertext, key);
            System.out.println("dt : " + new String(deciphertext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] plaintext, byte[] key) throws Exception {
        SecretKeySpec sks = new SecretKeySpec(key, "AES");
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, sks);
        return c.doFinal(plaintext);
    }

    public static byte[] decrypt(byte[] ciphertext, byte[] key) throws Exception {
        SecretKeySpec sks = new SecretKeySpec(key, "AES");
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, sks);
        return c.doFinal(ciphertext);
    }

    public static String byteToHex(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (byte b : bytes) {
            s.append(String.format("%02x", b));
        }
        return s.toString();
    }
}