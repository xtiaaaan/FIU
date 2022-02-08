#include <stdio.h>
#include <stdlib.h>

int main()
{
    int limit = 500;
    int a, b, c = 0;
    int m = 2;
    int n = 1;

    while(c < limit){
        for( ; n < m; ++n){
            a = m * m - n * n;
            b = 2 * m * n;
            c = m * m + n * n;

            if(c > limit)
                break;

            printf("%3d %3d %3d is a Pythagorean triple\n", a, b, c);
        }
        m++;
    }
    return 0;
}
