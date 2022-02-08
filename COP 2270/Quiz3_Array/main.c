#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

int main()
{
    int intList[SIZE] = {0};
    int i, j, integer, duplicate, k = 0;

    printf("Give me a number: ");
    scanf("%d", &integer);

    for(i = 0; i < SIZE || integer != -1; ++i){
        duplicate = 0;
        if(integer >= 1 && integer <= 100){
            for(j = 0; j < k, j++){
                if(integer == intList[j]){
                    duplicate = 1;
                    break;
                }
            }
        }
        if(!duplicate){
            intList[k++] = integer;
        }
        else{
            break;
        }
    }

    printf("The numbers in the array are: ");
    for(i = 0; intList[i] != 0; ++i){
        printf("%d\t", intList[i]);
    }

    return 0;

}
