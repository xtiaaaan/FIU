#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num, tn;
    int product = 1;

    printf("Enter a positive integer: ");
    scanf("%d", &num);

    tn = num;

    for( ; num >= 1; num --){
        product = product * num;
    }

    printf("The value of %d! is %d", tn, product);
}
