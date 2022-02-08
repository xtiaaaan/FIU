#include <stdio.h>
#include <stdlib.h>

int main()
{
    int grade = 50;

    if (grade >= 90){
        printf("A");
    }
    else if (grade >= 80) {
        printf("B");
    }
    else if (grade >= 70) {
        printf("C");
    }
    else if (grade >= 60) {
        printf("D");
    }
    else {
        printf("F");
    }

    return 0;
}
