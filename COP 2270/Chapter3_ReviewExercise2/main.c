#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n = 1;
    int sum = 0;

    while (n <= 10){
        sum = sum + n;
        n = n + 1;
    }

    printf("The sum of the integers from 1 to 10 is %d\n", sum);
}
