#include <stdio.h>
#include <stdlib.h>

int main()
{
    int integer1;
    int integer2;
    int integer3;
    int smallest;
    int largest;

    printf("Give me the first integer: ");
    scanf("%d", &integer1);

    printf("Give me the second integer: ");
    scanf("%d", &integer2);

    printf("Give me the third integer: ");
    scanf("%d", &integer3);

    if (integer1 > integer2){
        if (integer1 > integer3){
            largest = integer1;
        }
        else{
            largest = integer3;
        }
    }
    else{
        if (integer2 > integer3){
            largest = integer2;
        }
        else{
            largest = integer3;
        }
    }

    if (integer1 < integer2){
        if (integer1 < integer3){
            smallest = integer1;
        }
        else{
            smallest = integer3;
        }
    }
    else{
        if (integer2 < integer3){
            smallest = integer2;
        }
        else{
            smallest = integer3;
        }
    }

    printf("\nThe smallest integer of the group is: %d\n", smallest);
    printf("The largest integer of the group is: %d\n", largest);

    return 0;
}

