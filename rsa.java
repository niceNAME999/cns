import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    BigInteger n,d,e;
    int biglen = 256;

    RSA(){
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(biglen/2,100,r);
        BigInteger q = new BigInteger(biglen/2,100,r);
        n = p.multiply(q);
        BigInteger chi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537");
        d = e.modInverse(chi);
    }

    public BigInteger encrypt(BigInteger pt){
        return pt.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger pt){
        return pt.modPow(d,n);
    }

    public static void main(String[] args) {
        RSA r = new RSA();
        String pt = "Hello World";
        System.out.println("pt : "+pt);
        
        BigInteger ptt = new BigInteger(pt.getBytes());
        BigInteger cpt = r.encrypt(ptt);
        System.out.println("ct : "+cpt);
        
        BigInteger dpt = r.decrypt(cpt);
        String st = new String(dpt.toByteArray());
        System.out.println("dt : "+st);


    }
    
}