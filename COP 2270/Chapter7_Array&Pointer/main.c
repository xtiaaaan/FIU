#include <stdio.h>
#include <stdlib.h>

int main()
{
    int array[] = {2, 3, 5, 7, 11, 13, 17, 19};
    int *aPtr = array;
    size_t i, offset;

    puts("Array 'array' printed with:\nArray subscript notation");

    for(i = 0; i < 8; ++i){
        printf("b[%u] = %d\n", i , array[i]);
    }

    puts("\nPointer/offset notation where\n"
         "the pointer is the array name");

    for(offset = 0; offset < 8; ++offset){
        printf("*(array + %u) = %d\n", offset, *(array + offset));
    }

    puts("\nPointer subscript notation");

    for(i = 0; i < 8; ++i){
        printf("aPtr[%u] = %d\n", i, aPtr[i]);
    }

    puts("\nPointer/offset notation");

    for(offset = 0; offset < 8; ++offset){
        printf("*(array + %u) = %d\n", offset, *(array + offset));
    }
}
