#include <stdio.h>
#include <stdlib.h>
#define ARRAY_SIZE 10
#define FREQUENCY_SIZE 11

int main()
{
    int a[ARRAY_SIZE];
    int frequency[FREQUENCY_SIZE] = {0};
    int i, r;
    size_t freq, number;

    for(i = 0; i < ARRAY_SIZE; ++i){
        r = rand()%10 + 1;
        a[i] = r;
    }

    puts("The numbers in the array are:\n");
    for(i = 0; i < ARRAY_SIZE; ++i){
        printf("%d ", a[i]);
    }

    for(number = 0; number < ARRAY_SIZE; ++number){
        ++frequency[a[number]];
    }

    for(freq = 1; freq < FREQUENCY_SIZE; ++freq){
        printf("\nThe number %d occurs %d times\n", freq, frequency[freq]);
    }

    puts("");

}
