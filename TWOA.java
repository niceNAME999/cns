import java.util.*;


public class TWOA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to encrypt: ");
        String s = sc.nextLine();
        System.out.print("Enter the encryption key (an integer): ");
        int k = sc.nextInt();
        
        String encrypted = encrypt(s, k);
        System.out.println("Encrypted Code: " + encrypted);
        
        String decrypted = decrypt(encrypted, k);
        System.out.println("Decrypted Code: " + decrypted);
        
        sc.close();
    }

    public static String encrypt(String s , int k){
        String ans = "";
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                ans += (char)('A'+ (c-'A'+k)%26);
            }
            else if(Character.isLowerCase(c)){
                ans+= (char)('a' + (c-'a'+k)%26);
            }
            else{
                ans+=c;
            }
        }
        return ans;
    }
    public static String decrypt(String s, int k){
        return encrypt(s, 26-k);
    }
}