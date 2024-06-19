#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char str[] = "Hello World";
    int n = strlen(str);
    for (int i = 0; i < n; i++)
    {
        printf("%c = %d\t", str[i], str[i] & 127);
    }
    printf("\n");
    for (int i = 0; i < n; i++)
    {
        printf("%c = %d\t", str[i], str[i] | 127);
    }
    printf("\n");
    for (int i = 0; i < n; i++)
    {
        printf("%c = %d\t", str[i], str[i] ^ 127);
    }
    printf("\n");
    return 0;
}