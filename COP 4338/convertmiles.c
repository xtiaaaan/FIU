#include <stdio.h>
int main(void){
 float mi1 = 2;
 float mi2 = 5.65;
 float mi3 = 300;
 float mi4 = 1845;

 float toKm = 1.60934;

 float km1 = mi1 * toKm;
 float km2 = mi2 * toKm;
 float km3 = mi3 * toKm;
 float km4 = mi4 * toKm;

 printf("\t      Converting Miles\n");
 printf("\t    Miles\t     Kilometers\n");
 printf("\t%10.5f\t    %10.5f\n", mi1, km1);
 printf("\t%10.5f\t    %10.5f\n", mi2, km2);
 printf("\t%10.5f\t    %10.5f\n", mi3, km3);
 printf("\t%10.5f\t    %10.5f\n", mi4, km4);
} 
