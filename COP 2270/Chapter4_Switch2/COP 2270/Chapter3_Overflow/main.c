#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int main()
{
    unsigned int counter;
    unsigned int miles;
    unsigned int gallons;

    float mileage;
    float total_mileage;
    float average;

    counter = 0;

    printf("%s", "Enter the miles driven, -1 to end: ");
    scanf("%d", &miles);
    printf("%s", "Enter the gallons consumed: ");
    scanf("%d", &gallons);

    while (miles != -1){
        mileage = miles / gallons;
        total_mileage = total_mileage + mileage;
        counter = counter + 1;
        printf("Mileage is %d\n", mileage);

        printf("%s", "Enter the miles driven, -1 to end: ");
        scanf("%d", &miles);
        printf("%s", "Enter the gallons consumed: ");
        scanf("%d", &gallons);
    }

    if (counter != 0){
        average = total_mileage / counter;
        printf("Average mileage is %.2f\n", average);
    }
    else{
        puts("No amount was entered");
    }

}
