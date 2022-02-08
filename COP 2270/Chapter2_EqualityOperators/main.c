#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1;
    int num2;

    printf("Enter two integers, and I will tell you\n");
    printf("the relationships they satisfy\n");

    printf("\nEnter the first integer:\n");
    scanf("%d", &num1);

    printf("\nEnter the second integer:\n");
    scanf("%d", &num2);

    if (num1 == num2){
        printf("\n%d is equal to %d\n", num1, num2);
    }

    if (num1 != num2){
        printf("\n%d is not equal to %d\n", num1, num2);
    }

    if (num1 < num2){
        printf("%d is less than %d\n", num1, num2);
    }

    if (num1 > num2){
        printf("%d is greater than %d\n", num1, num2);
    }

    if (num1 <= num2){
        printf("%d is less than or equal to %d\n", num1, num2);
    }

    if (num1 >= num2){
        printf("%d is greater than or equal to %d\n", num1, num2);
    }
}
