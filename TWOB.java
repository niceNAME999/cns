import java.util.Arrays;
import java.util.Scanner;

public class TWOB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the key: ");
        String key = sc.nextLine().toLowerCase().replaceAll("[^a-z]", "");
        System.out.print("Enter the plaintext: ");
        String pt = sc.nextLine().toLowerCase().replaceAll("[^a-z]", "");
        String ciphertext = encryptByPF(pt, key);
        System.out.println("Ciphertext: " + ciphertext);
        String decryptedText = decryptByPF(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);

    }

    private static void generateKeyTable(char[] key, char[][] keyTable) {
        int n = key.length;
        int row = 0, col = 0;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (!visited[key[i] - 'a']) {
                visited[key[i] - 'a'] = true;
                keyTable[row][col] = key[i];
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch == 'j') {
                continue;
            }
            if (!visited[ch - 'a']) {
                keyTable[row][col] = ch;
                // visited[ch-'a']=true;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    public static char[] prepare(char[] str) {
        int n = str.length;
        if (n % 2 != 0) {
            str = Arrays.copyOf(str, n + 1);
            str[n] = 'z';
        }
        return str;
    }

    public static void search(char a, char b, char[][] keyTable, int[] arr) {
        if (a == 'j')
            a = 'i';
        else if (b == 'j')
            b = 'i';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyTable[i][j] == a) {
                    arr[0] = i;
                    arr[1] = j;
                } else if (keyTable[i][j] == b) {
                    arr[2] = i;
                    arr[3] = j;
                }
            }
        }
    }

    public static int mod5(int a) {
        return (a % 5 + 5) % 5;
    }

    private static void encrypt(char[] s, char[][] keyTable) {
        for (int i = 0; i < s.length; i += 2) {
            int[] arr = new int[4];
            search(s[i], s[i + 1], keyTable, arr);
            if (arr[0] == arr[2]) {
                s[i] = keyTable[arr[0]][mod5(arr[1] + 1)];
                s[i + 1] = keyTable[arr[2]][mod5(arr[3] + 1)];
            } else if (arr[1] == arr[3]) {
                s[i] = keyTable[mod5(arr[0] + 1)][arr[1]];
                s[i + 1] = keyTable[mod5(arr[2] + 1)][arr[3]];
            } else {
                s[i] = keyTable[arr[0]][arr[3]];
                s[i + 1] = keyTable[arr[2]][arr[1]];
            }
        }
    }

    private static void decrypt(char[] s, char[][] keyTable) {
        for (int i = 0; i < s.length; i += 2) {
            int[] arr = new int[4];
            search(s[i], s[i + 1], keyTable, arr);
            if (arr[0] == arr[2]) {
                s[i] = keyTable[arr[0]][mod5(arr[1] - 1)];
                s[i + 1] = keyTable[arr[2]][mod5(arr[3] - 1)];
            } else if (arr[1] == arr[3]) {
                s[i] = keyTable[mod5(arr[0] - 1)][arr[1]];
                s[i + 1] = keyTable[mod5(arr[2] - 1)][arr[3]];
            } else {
                s[i] = keyTable[arr[0]][arr[3]];
                s[i + 1] = keyTable[arr[2]][arr[1]];
            }
        }
    }

    private static String encryptByPF(String pt, String key) {
        char[] ptch = pt.toCharArray();
        char[] keych = key.toCharArray();
        char[][] keyTable = new char[5][5];

        generateKeyTable(keych, keyTable);
        ptch = prepare(ptch);
        encrypt(ptch, keyTable);
        return new String(ptch);
    }

    private static String decryptByPF(String ct, String key) {
        char[] ctch = ct.toCharArray();
        char[] keych = key.toCharArray();
        char[][] keyTable = new char[5][5];

        generateKeyTable(keych, keyTable);
        decrypt(ctch, keyTable);
        return new String(ctch);
    }

}