#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1;
    int num2;
    int remainder;

    printf("Enter first integer\n");
    scanf("%d", &num1);

    printf("Enter second integer\n");
    scanf("%d", &num2);

    remainder = num1 % num2;

    if (remainder == 0){
        printf("%d is a multiple of %d\n", num1, num2);
    } else{
        printf("%d is not a multiple of %d\n", num1, num2);
    }
}
