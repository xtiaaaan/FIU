#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int myArray[10];
    int i, r, total = 0;
    srand(time(NULL));

    for(i = 0; i < 10; i++){
        r = rand()%100;
        myArray[i] = r;
    }

    printf("The numbers in the array are: \n");
    for(i = 0; i< 10; i++){
        total += myArray[i];
        printf("%d\t", myArray[i]);
    }

    printf("\nThe sum of the array elements is: %d\n", total);

    return 0;
}
