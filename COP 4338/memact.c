#include <stdio.h>
#include <stdlib.h>

int main(void){
    char* pletter = (char*)malloc(1 * sizeof(char));
    char* pstr = (char*)malloc(10 * sizeof(char));
    int* pnum = (int*)malloc(1 * sizeof(int));
    float* pfl = (float*)malloc(1 * sizeof(float));
    int* parr = (int*)malloc(10 * sizeof(int));

    pletter[0] = 'A';
    pstr[0] = 'C';
    pstr[1] = 'h';
    pstr[2] = 'r';
    pstr[3] = 'i';
    pstr[4] = 's';
    pstr[5] = 't';
    pstr[6] = 'i';
    pstr[7] = 'a';
    pstr[8] = 'n';
    pstr[9] = '\0';
    pnum[0] = 100;
    pfl[0] = 98.76;

    for(int i = 0; i < 10; i++){
        parr[i] = i;
    }


    printf("Character: %s\n", pletter);
    printf("Integer: %d\n", *pnum);
    printf("String: ");
    for(int i = 0; i < 10; i++){
        if(pstr[i] != '\0'){
            printf("%c", pstr[i]);
        }
    }
    printf("\nFloating Point: %0.2f\n", *pfl);
    printf("Aray of Integers: ");
    for(int i = 0; i < 10; i++){
        printf("%d ", parr[i]);
    }
    printf("\n");
    
    free(pletter);
    free(pstr);
    free(pnum);
    free(pfl);
    free(parr);

    return 0;

}
