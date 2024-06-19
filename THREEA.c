#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void printVigenereTable()
{
    printf("Vigenere Table \n");
    printf("  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z \n");
    for (int i = 0; i < 26; i++)
    {
        printf("%c ", i + 'A');
        for (int j = 0; j < 26; j++)
        {
            printf("%c ", 'A' + (i + j) % 26);
        }
        printf("\n");
    }
    printf("\n");
}
void encrypt()
{
    char plaintext[128];
    char key[16];
    printf("Enter Plaintext : ");
    scanf(" %[^\n]", plaintext);
    printf("Enter Key : ");
    scanf(" %[^\n]", key);
    for (int i = 0, j = 0; i < strlen(plaintext); i++, j++)
    {
        if (j >= strlen(key))
        {
            j = 0;
        }
        int shift = toupper(key[j]) - 'A';
        char ch = 'A' + (((toupper(plaintext[i])) - 'A') + shift) % 26;
        printf("%c", ch);
    }
    printf("\n");
}

void decrypt()
{
    char ciphertext[128];
    char key[16];
    printf("Enter ciphertext : ");
    scanf(" %[^\n]", ciphertext);
    printf("Enter Key : ");
    scanf(" %[^\n]", key);
    for (int i = 0, j = 0; i < strlen(ciphertext); i++, j++)
    {
        if (j >= strlen(key))
        {
            j = 0;
        }
        int shift = toupper(key[j]) - 'A';
        char ch = 'A' + (((toupper(ciphertext[i])) - 'A') - shift) % 26;
        printf("%c", ch);
    }
    printf("\n");
}

int main()
{
    int option;
    while (1)
    {
        printf("\n1. Encrypt");
        printf("\n2. Decrypt");
        printf("\n3. Print Vigenère Table");
        printf("\n4. Exit\n");
        printf("\nEnter your option: ");
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            encrypt();
            break;
        case 2:
            decrypt();
            break;
        case 3:
            printVigenereTable();
            break;
        case 4:
            exit(0);
        default:
            printf("\nInvalid selection! Try again.\n");
            break;
        }
    }
    return 0;
}