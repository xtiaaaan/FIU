#include <stdio.h>
#include <stdlib.h>

int factorial(int n);

int main()
{
    int a;

    printf("\nGive me a positive integer number: ");
    scanf("%d", &a);

    printf("\n\nThe factorial of %d is %d\n", a, factorial(a));

    return 0;
}

int factorial(int n)
{
    if (n <= 1)
        return 1
    ;
    else
        return(n * factorial(n-1))
    ;
}
