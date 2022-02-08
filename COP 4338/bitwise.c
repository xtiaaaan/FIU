#include <stdio.h>

int main()
{
    unsigned int num;
    int bit, flag = 1;

    printf("Enter an integer between 1 and 10000:\n");
    scanf("%d", &num);
    if (num < 1 && num > 10000)
    {
        printf("Enter a valid number.\n");
        flag = 0;
        return 0;
    }
    while (flag == 1)
    {
        printf("Enter a number between 0-31 to select which bit to flip:\n");
        scanf(" %d", &bit);
        if (bit < 0 && bit > 31)
        {
            printf("Enter a valid number.\n");
            flag = 0;
            return 0;
        }
        else
        {
            num = num ^ (1 << bit);
            printf("%u\n", num);
            printf("Continue? 1 for Yes, 0 for No.\n");
            scanf(" %d", &flag);
        }
    }
    printf("End of program.\n");
    return 0;
}