#include <stdio.h>
#include <stdlib.h>

int main()
{
    unsigned int sum = 0;
    unsigned int number;

    for (number = 2; number <= 100; number += 2){
        sum += number;
    }

    printf("Sum is %u\n", sum); // Summing the Even Integers From 2 to 100
}
