#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define SIZE 20

int main()
{
    long num;
    long total = 0;
    char sentence[SIZE];

    puts("\nEnter an integer number:");

    while(fgets(sentence, SIZE, stdin) != NULL) {
        printf("You entered: %s\n", sentence);

        num = strtol(sentence, NULL, 0);

        if(num == 0)
            puts("\nNot a number.\n")
        ;
        else
            total += num
        ;
    }
    return 0;
}
