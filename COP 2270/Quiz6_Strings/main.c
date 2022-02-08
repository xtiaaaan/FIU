#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define SIZE 80

int main()
{
    char string[SIZE];
    char encrypt[SIZE];
    int i;

    printf("Give me a line of text:\t");
    fgets(string, SIZE, stdin);

    for(i = 0; string[i] != '\0'; ++i){
        encrypt[i] = string[i];

        if(encrypt[i] >= 'a' && encrypt[i] <= 'z'){
            encrypt[i] = encrypt[i] + 3;


            if(encrypt[i] > 'z'){
                encrypt[i] = encrypt[i] - 'z' + 'a' - 1;
            }

            encrypt[i] = toupper(encrypt[i]);
        }

    }

    printf("\nThis is the coded text:\t%s", encrypt);
}
