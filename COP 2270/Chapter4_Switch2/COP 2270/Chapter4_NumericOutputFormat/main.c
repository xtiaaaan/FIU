#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    printf("numbers:\t");

    for(num = 3; num <= 23; num += 5){
        printf("%d\t", num);
    }

    printf("\n\nnum after for: %d\n", num);

    return 0;
}
