#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int main()
{
    char buf1[MAX];
    char buf2[MAX];

    printf("Read with fgets: ");
    fgets(buf2, MAX, stdin);
    printf("String with fgets is %s\n", buf2);

    printf("Read with scanf: ");
    scanf("%s", buf1);
    printf("String with scanf is: %s\n", buf1);

    return 0;
}
