#include <stdio.h>
#include <stdlib.h>

int main()
{
    int counter = 2;

    do{
        if ( (counter % 2) == 0)
            printf("Counter = %d\n", counter);
        counter += 2;
    } while (counter <= 20);
    return 0;
}
