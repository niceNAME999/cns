#include <stdio.h>
#include <string.h>

void encrypt(char *input, char *encrypted, int key)
{
    int len = strlen(input);
    int j = 0;
    for (int rail = 0; rail < key; rail++)
    {
        for (int i = 0; i < len; i += key)
        {
            encrypted[j++] = input[i];
        }
    }
    encrypted[len]='\0';
}

void decrypt(char *input, char *decrypted, int key)
{
    int len = strlen(input);
    int seg = len / key;
    int extra = len % key;
    int j = 0;

    char *rails[key];
    for (int i = 0; i < len; i++)
    {
        rails[i] = input + j;
        j += (i < extra) ? seg + 1 : seg;
    }
    for (int i = 0, pos = 0; i < seg + 1; i++)
    {
        for (int rail = 0; i < key; rail++)
        {
            if (i < ((rail < extra) ? seg + 1 : seg))
            {
                decrypted[pos++] = rails[rail][i];
            }
        }
    }
    decrypted[len]='\0';
}

int main()
{
    char input[100], encrypted[100], decrypted[100];
    int key;

    printf("\n\t\tRAIL FENCE TECHNIQUE");
    printf("\n\nEnter the input string: ");
    scanf(" %[^\n]", input);
    printf("Enter the key (number of rails): ");
    scanf("%d", &key);

    encrypt(input, encrypted, key);
    printf("\nCipher text after applying rail fence: %s", encrypted);

    decrypt(encrypted, decrypted, key);
    printf("\nText after decryption: %s", decrypted);

    return 0;
}