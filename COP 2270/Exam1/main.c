#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float areaTriangle(float a, float b, float c);

int main()
{
    float a, b, c;
    float area;

    printf("Give me the first side (a): \n");
    scanf("%f", &a);

    printf("Give me the second side (b): \n");
    scanf("%f", &b);

    printf("Give me the third side (c): \n");
    scanf("%f", &c);

    area = areaTriangle(a, b, c);

    printf("The area of the triangle is: %.2f", area);
}

float areaTriangle(float a, float b, float c)
{

    float s, ar;

    s = (a + b + c)/2;
    ar = sqrt((s*(s-a)*(s-b)*(s-c)));

    return ar;
}
