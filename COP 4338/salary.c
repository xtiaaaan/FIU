/*
Christian Angus
6197873
I affirm that I wrote this program myself without any help from any other people or sources from the internet.
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]){
	int c;
	int bInt = 0, rInt = 0, v = 0;
	int bflag, rflag, vflag;
	int base;
	static char usage[] = "Usage salary: [-b bnum] [-r rnum] [-v] base\n";

	while((c = getopt(argc, argv, "b:r:v")) != -1){
		switch(c){
		case 'b':
			bflag = 1;	// Set flag if -b is used
			bInt = atoi(optarg);
			break;
		case 'r':
			rflag = 1;	// Set flag if -r is used
			rInt = atoi(optarg);
			break;
		case 'v':
			v = 8000;	// Initialize v-value if -v is used
			break;
		case '?':
			printf("Missing arguments\n");
			printf(usage);
			exit(1);
			break;
		}
	}

	// Grab the last argument and set it as base
	for(; optind < argc; optind++){
		base = atoi(argv[optind]);
	}

	// Error if base is less than 50000 or more than 100000
	if(base < 50000 || base > 100000){
		printf("Base should be an integer between 50000 and 100000 inclusive\n");
		printf(usage);
		exit(1);
	}
	
	// Error if raise is less than 5 or more than 10
	else if(rflag == 1 && (rInt < 5 || rInt > 10)){
		printf("Raise should be a positive integer between 5 and 10 inclusive\n");
		printf(usage);
		exit(1);
	}
	
	// Error if bonus is less than 1% or more than 10%;
	else if(bflag == 1 && (bInt < 1 || bInt > 10)){
		printf("Bonus should be a positive integer between 1 and 10 inclusive\n");
		printf(usage);
		exit(1);
	}
	else{
		base += v;
		base += ((double)rInt/100)*base;
		base += bInt * 1000;

		// Cast base as a float to print out two decimal points
		printf("Result: %0.2f\n", (float)base);
	}
	
	
	exit(0);
}