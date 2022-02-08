#include <stdio.h>
#include <stdlib.h>

int main()
{
    char name[30];
    double grade1;
    double grade2;
    double grade3;
    double grade4;
    double average;
    FILE *cfPtr;

    if((cfPtr = fopen("Grades.txt", "r")) == NULL){
        puts("File could not be opened");
    }
    else{
        fscanf(cfPtr, "%29s%lf%lf%lf%lf%lf", name, &grade1, &grade2, &grade3, &grade4);

        while(!feof(cfPtr)){
            printf("%-13s%2.2f\n", name, average = (grade1+ grade2 + grade3 + grade4)/4);
            fscanf(cfPtr, "%29s%lf%lf%lf%lf%lf", name, &grade1, &grade2, &grade3, &grade4);
        }

        fclose(cfPtr);
    }
}
