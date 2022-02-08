#include <stdio.h>
#include <stdlib.h>

int main()
{
    int productNumber;
    int quantity;
    double total = 0.0;

    puts("Enter pairs of product number and quantities.");
    puts("Enter -1 for the product number to end input.");
    printf("Please enter product number: ");
    scanf("%d", &productNumber);

    while (productNumber != -1){
        printf("Please enter quantity: ");
        scanf("%d", &quantity);

        switch (productNumber){

            case 1:
                total += quantity * 2.98;
                break;

            case 2:
                total += quantity * 4.50;
                break;

            case 3:
                total += quantity * 9.98;
                break;

            case 4:
                total += quantity * 4.49;
                break;

            case 5:
                total += quantity * 6.87;
                break;

            default:
                printf("Invalid product number:     %d\n", productNumber);
                printf("                Quantity:   %d\n", quantity);
        }

        printf("\nItem number: ");
}
