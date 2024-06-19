import java.util.Scanner;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class ten {

    public static String getmd5(String a){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messagedigest = md.digest(a.getBytes());
            BigInteger no = new BigInteger(1,messagedigest);
            String hash = no.toString(16);
            while(hash.length()<32){
                hash="0"+hash;
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            return "";    
        }
    }

    public static void main(String[] args) {
        System.out.println("Value : " + getmd5("hello"));
    }
}