#include <stdio.h>
#include <stdlib.h>

int main()
{
    unsigned char count;

    puts("ASCII codes for lowercase letters:");
    for(count = 97; count <= 122; ++count){
        printf("%3d-%c\t", count, count);
        if(count % 5 == 1)
            printf("\n");
    }

    puts("\n\nASCII codes for uppercase letters:");
    for(count = 65; count <= 90; ++count){
        printf("%3d-%c\t", count, count);
        if(count % 5 == 4)
            printf("\n");
    }

    return 0;
}
