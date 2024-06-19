#include <stdio.h>
#include <string.h>

void encrypt(int key[3][3], int pt[3], int et[3])
{
    for (int i = 0; i < 3; i++)
    {
        int t = 0;
        for (int j = 0; j < 3; j++)
        {
            t += key[i][j] * pt[j];
        }
        et[i] = t % 26;
    }
}

void decrypt(int key[3][3], int et[3], int dt[3])
{
    for (int i = 0; i < 3; i++)
    {
        int t = 0;
        for (int j = 0; j < 3; j++)
        {
            t += key[i][j] * et[j];
        }
        dt[i] = t % 26;
    }
}

int main()
{
    int key[3][3] = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}};
    int keyInv[3][3] = {{8, 5, 10}, {21, 8, 21}, {21, 12, 8}};
    printf("Enter plain text: ");
    char msg[4];
    scanf("%s", msg);
    int pt[3];
    int et[3];
    int dt[3];
    for (int i = 0; i < 3; i++)
    {
        pt[i] = msg[i] - 'A';
    }
    encrypt(key, pt, et);

    printf("\nEncrypted Cipher Text :");
    for (int i = 0; i < 3; i++)
    {
        printf("%c", et[i] + 'A');
    }
    decrypt(keyInv, et, dt);
    printf("\nDecrypted Cipher Text :");
    for (int i = 0; i < 3; i++)
    {
        printf("%c", dt[i] + 'A');
    }

    return 0;
}