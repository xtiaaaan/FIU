#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 80

int main()
{
    char a, sentence[SIZE];
    int i, flag = 0, count = 0;

    printf("Give me a line of text: \n");
    gets(sentence);

    printf("Give me the search character: ");
    scanf("%c", &a);

    for(i = 0; i < strlen(sentence); i++){
        if(sentence[i] == a){
            flag = 1;
        }
        if(sentence[i] == ' ')
            count++;
    }

    if(flag){
        printf("The line of text contains %d words\n", count + 1);
        }
    else{
        printf("The line of text provided doesn't contain the character '%c'\n", a);
        }

    return 0;
}
