#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n);

int main()
{
    int a;

    printf("\nGive me a positive integer number: ");
    scanf("%d", &a);

    printf("\n\nThe Fibonacci of %d is %d\n", a, fibonacci(a));

    return 0;
}

int fibonacci(int n)
{
    if (n = 0)
        return 0
    ;
    else if (n == 1)
        return 1
    ;
    else
        return(fibonacci(n - 1) + fibonacci(n - 2))
    ;
}
