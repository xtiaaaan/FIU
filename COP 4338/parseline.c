#include <stdio.h>
#include <string.h>

int main()
{
    char str[100];
    const char tok[2] = " ";
    char *token;

    scanf("%[^\n]s", str);

    token = strtok(str, tok);

    while (token != NULL)
    {
        printf("%s\n", token);
        token = strtok(NULL, tok);
    }

    return 0;
}