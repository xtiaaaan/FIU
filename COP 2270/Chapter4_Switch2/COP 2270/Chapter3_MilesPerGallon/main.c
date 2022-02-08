#include <stdio.h>
#include <stdlib.h>

int main()
{
    float miles;
    float gallons;
    float totalMiles = 0.0;
    float totalGallons = 0.0;
    float totalAverage;

    printf("Enter the gallons used (-1 to end): ");
    scanf("%f", &gallons);

    while (gallons != -1.0){
        totalGallons += gallons;

        printf("Enter the miles driven: ");
        scanf("%f", &miles);
        totalMiles += miles;

        printf("The miles per gallon for this tank is %.2f\n\n", miles/gallons);

        printf("Enter the gallons used (-1 to end): ");
        scanf("%f", &gallons);
    }

    totalAverage= totalMiles/totalGallons;
    printf("\nThe overall average miles per gallon is %.2f\n", totalAverage);
}
