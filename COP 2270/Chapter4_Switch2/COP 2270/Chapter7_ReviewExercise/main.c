#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b);

int main()
{
 int a;
 int b;

 printf("Enter a value for a: ");
 scanf("%d", &a);
 printf("\nEnter a value for b: ");
 scanf("%d", &b);

 swap(&a, &b);

 printf("The new value of a and b are %d and %d", a, b);
}

void swap(int *a, int *b)
{

    int hold = *a;
    *a = *b;
    *b = hold;

}
