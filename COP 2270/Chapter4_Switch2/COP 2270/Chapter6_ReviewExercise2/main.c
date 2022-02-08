#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

int main()
{
    char string[SIZE], reverse_string[SIZE] = {'\0'};
    int i, length = 0, palindrome = 0;

    printf("Enter a palindrome: \n");
    scanf("%19s", string);

    for(i = 0; string[i] != '\0'; ++i){
            ++length;
    }

    for(i = length - 1; i >= 0; --i){
            reverse_string[length-i - 1] = string[i];
    }

    for(i = 0; i < length; ++i){
        if(reverse_string[i] == string[i])
            palindrome = 1;
        else
            palindrome = 0;
    }

    if(palindrome){
        printf("%s is a palindrome", string);
    }
    else{
        printf("%s is not a palindrome", string);
    }


    return 0;
}
