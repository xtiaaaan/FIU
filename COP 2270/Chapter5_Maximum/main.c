#include <stdio.h>
#include <stdlib.h>

int maximum(int x, int y, int z);

int main()
{
    int a, b, c, m;

    printf("Enter the first integer: \n");
    scanf("%d", &a);

    printf("Enter the second integer: \n");
    scanf("%d", &b);

    printf("Enter the last integer: \n");
    scanf("%d", &c);

    m = maximum(a, b, c);
    printf("The largest value is %d\n", m);

}

int maximum(int x, int y, int z)
{
    if ((x > y) && (x > z)){
        return x;
    }
    else if((y > x) && (y > z)){
        return y;
    }
    else if((z > x) && (z > y)){
        return z;
    }
}
