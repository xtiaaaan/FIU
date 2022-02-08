#include <stdio.h>
#include <stdlib.h>

void useLocal();
void useStaticLocal();
void useGlobal();

int x = 1;

int main()
{
    int x = 5;

    printf("local x in outer scope of main is %d\n", x);

    {
        int x = 7;

        printf("local x in inner scope of main is %d\n", x);
    }

    printf("local x in outer scope of main is %d\n", x);

    useLocal();
    useStaticLocal();
    useGlobal();
    useLocal();
    useStaticLocal();
    useGlobal();

    printf("\nlocal x in main is %d\n", x);
}

void useLocal()
{
    int x = 25;

    printf("\nlocal in x useLocal is %d after entering useLocal\n", x);
    ++x;
    printf("local x in useLocal is %d before exiting useLocal\n", x);
}

void useStaticLocal()
{
    static int x = 50;

    printf("\nlocal static x is %d on entering useStaticLocal\n", x);
    ++x;
    printf("local static x is %d on exiting useStaticLocal\n", x);
}

void useGlobal()
{
    printf("\nglobal x is %d on entering useGlobal\n", x);
    x *= 10;
    printf("global x is %d on exiting useGlobal\n", x);
}
