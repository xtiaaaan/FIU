#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

int main()
{
    int intList[SIZE];
    int i = 0, j, k;

    printf("Give me a number: ");
    scanf("%d", &intList[i]);
    for(i = 0; i < SIZE || intList[i] != -1; i++){
        for(j = i + 1; j < SIZE; j++){
            if(intList[i] == intList[j]){
                for(k = j; k < SIZE; k++){
                    intList[k] = intList[k + 1];
                }
                j--;
            }
        }
    }

    printf("The numbers in the array are: ");
    for(i = 0; i < SIZE; i++){
        printf("%d\t", intList[i]);
    }

    return 0;

}
