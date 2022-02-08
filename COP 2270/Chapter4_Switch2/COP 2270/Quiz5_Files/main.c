#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int main()
{
    float c, f;

    FILE *tempPtr;

    if((tempPtr = fopen("Fahrenheit_Conversion.txt", "w")) == NULL){
        puts("File could not be opened");
    }
    else{
        for(f = 0; f <= MAX; f += 5){
            c = ((f - 32)*5)/9;
            printf("%.0f\t%.2f\n", f, c);
            fprintf(tempPtr, "%.0f\t%.2f\n", f, c);
        }
    }
    fclose(tempPtr);
}
