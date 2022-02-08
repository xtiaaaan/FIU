#include <stdio.h>

int main(void){
	char letter;
    	char str[20];
    	int num;
    	float fl;

	char* pletter = &letter;
    	char* pstr = str;
     	int* pnum = &num;
     	float* pfl = &fl;

    	printf("Enter a single character: \n");
    	scanf("%c", &letter);
	printf("Enter a string: \n");
	scanf("%s", &str);
	printf("Enter an integer: \n");
	scanf("%d", &num);
	printf("Enter a floating point number: \n");
	scanf("%f", &fl);

    	printf("Value: %c, Address: %p\n", *pletter, pletter);
	
	printf("Value: ");
	while(*pstr != '\0'){
		printf("%c", *pstr++, pstr);
	}
	printf(", Address: %p\n", pstr);
	printf("Value: %d, Address: %p\n", *pnum, pnum);
	printf("Value: %f, Address: %p\n", *pfl, pfl);

    return 0;
}