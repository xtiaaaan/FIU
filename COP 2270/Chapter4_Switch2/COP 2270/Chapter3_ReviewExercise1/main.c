#include <stdio.h>
#include <stdlib.h>

int main()
{
    int integer;
    int result;

    printf("Enter an integer:\n");
    scanf("%d", &integer);

    result = integer % 2;

    if (result == 0){
        printf("The integer is even.\n");
    }
    else{
        printf("The integer is odd.\n");
    }
}
