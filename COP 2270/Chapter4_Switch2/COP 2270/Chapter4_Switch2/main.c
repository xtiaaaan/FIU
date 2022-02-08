#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    printf("Give me a number: ");
    scanf("%d", &num);

    switch(num%2){
    case 0:
        printf("%d is even\n", num);
        break;
    case 1:
        printf("%d is odd\n", num);
        break;
    default:
        printf("Don't forget this case\n");
        break;
    }
    return 0;
}
