#include <stdio.h>
#include <stdlib.h>

int main()
{
    double pi = 0;
    double numerator = 4;
    double denominator = 1;
    unsigned int i = 1;
    unsigned int acc;

    printf("Enter the number of terms to calculate for pi: ");
    scanf("%u", &acc);

    for( ; acc>1; acc--){
        if((acc%2)==0){
            pi += numerator / denominator;
        }
        else{
            pi -= numerator / denominator;
        }
        denominator += 2;
        ++i;
    }

    printf("%10s%20s\n", "Loop", "Approximation");
    printf("%10u%20f\n", i, pi);

    return 0;

}
