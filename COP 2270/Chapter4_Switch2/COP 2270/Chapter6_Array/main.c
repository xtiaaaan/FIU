#include <stdio.h>
#include <stdlib.h>
#define SIZE 10

int main()
{
    int s[SIZE];
    size_t j;

    for(j = 0; j < SIZE; ++j){
        s[j] = 2 + 2 * j;
    }

    printf("%s%13s\n", "Element", "Value");

    for(j = 0; j < SIZE; ++j){
        printf("%7u%13d\n", j, s[j]);
    }
}
