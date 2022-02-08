#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define SIZE 20

int main()
{
    char string[SIZE];
    char *p;

    puts("\nEnter some text in lower case: ");
    fgets(string, SIZE, stdin);

    p = string;
    while(*p != '\0'){
        *p = toupper(*p);
        ++p;
    }

    printf("\nThe string in upper case is %s", string);
    return 0;
}
