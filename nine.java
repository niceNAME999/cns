import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class nine {
    public static String getsha(String a){
        try{

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messagedigest = md.digest(a.getBytes());
            BigInteger no = new BigInteger(1,messagedigest);
            String hash = no.toString(16);
            while (hash.length()<32) {
                hash="0"+hash;
            }
            return hash;
        }
        catch(NoSuchAlgorithmException e){
            return "";
        }
        
    }

    public static void main(String[] args) {
        String a = "hello";
        System.out.println("Value : "+getsha(a));
    }
}