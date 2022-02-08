#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 80

int main()
{
    char sentence[SIZE];
    char word[SIZE];
    char *tokenPtr;

    puts("Enter a sentece:");
    fgets(sentence, SIZE, stdin);

    printf("\nEnter a word (either found in your sentence or not):\n");
    scanf("%s", word);

    tokenPtr = strtok(sentence, " ");

    while(tokenPtr != NULL){
        if(!strcmp(word, tokenPtr))
            printf("%s : This is the word you are looking for\n", tokenPtr)
        ;
        else
            printf("%s\n", tokenPtr)
        ;

        tokenPtr = strtok(NULL, " ");
    }

    return 0;
}
