#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    printf("Give me a number: ");
    scanf("%d", &num);

    if ((num >= 1) && (num <= 10)){
        printf("\nPositive integer number less than 10.\n");
    }
    else if((num >= 11) && (num <= 20)){
        printf("\nThe number is greater than 10 and less than 20\n");
    }
    return 0;
}
