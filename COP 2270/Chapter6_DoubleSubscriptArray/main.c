#include <stdio.h>
#include <stdlib.h>

int main()
{
    int array1[2][3] = {{1, 2, 3}, {4, 5, 6}};
    int array2[2][3] = {{1, 2, 3}, {4, 5, 6}};
    int array3[2][3] = {};

    size_t i;
    size_t j;

    for(i = 0; i <= 1; ++i){
        for(j = 0; j <= 2; ++j){
            printf("%d ", array1[i][j]);
        }
        printf("\n");
    }

    for(i = 0; i <= 1; ++i){
        for(j = 0; j <= 2; ++j){
            printf("%d ", array2[i][j]);
        }
        printf("\n");
    }

    for(i = 0; i <= 1; ++i){
        for(j = 0; j <= 2; ++j){
            array3[i][j] = array1[i][j] + array2[i][j];
            printf("%d ", array3[i][j]);
        }
        printf("\n");
    }

    return 0;
}
