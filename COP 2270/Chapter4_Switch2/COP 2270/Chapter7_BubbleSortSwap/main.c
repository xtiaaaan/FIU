#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 10

void bubbleSort(int a[]);
void swap(int *a, int *b);

int main()
{
    int a[SIZE];
    int i, r;

    for(i = 0; i < SIZE; ++i){
        r = rand()%100;
        a[i] = r;
    }

    puts("Data items in the original order");
    for(i = 0; i < SIZE; ++i){
        printf("%4d", a[i]);
    }

    bubbleSort(a);

    puts("\nData items in ascending order");

    for(i = 0; i < SIZE; ++i){
        printf("%4d", a[i]);
    }

    puts("");

}

void bubbleSort(int a[])
{
    int pass;
    size_t i;

    for(pass = 1; pass < SIZE; ++pass){
        for(i = 0; i < SIZE; ++i){
            if(a[i] > a[i + 1]){
            swap(&a[i], &a[i + 1]);
            }
        }
    }
}

void swap(int *a, int *b)
{
    int hold;

    hold = *a;
    *a = *b;
    *b = hold;
}
