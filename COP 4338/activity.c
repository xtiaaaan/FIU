/*
	example of command line parsing via getopt
	usage: getopt [-dmp] -f fname [-s sname] name [name ...]

	Paul Krzyzanowski
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int debug = 0;

int
main(int argc, char **argv)
{
	extern char *optarg;
	extern int optind;
	int cint, total, argVal;
	int c, err = 0; 
	int bflag=0, cflag = 0;
	char *sname = "default_sname", *cname;
	static char usage[] = "usage: %s [-b] -c cname value\n";

	while ((c = getopt(argc, argv, "bc:")) != -1)
		switch (c) {
		case 'b':
			bflag = 1;
			break;
		case 'c':
			cflag = 1;
			cname = optarg;
			cint = atoi(cname);
			break;
		case '?':
			err = 1;
			break;
		}
	if (cflag == 0) {	/* -f was mandatory */
		fprintf(stderr, "%s: missing -f option\n", argv[0]);
		fprintf(stderr, usage, argv[0]);
		exit(1);
	} else if ((optind+1) > argc) {	
		/* need at least one argument (change +1 to +2 for two, etc. as needeed) */

		printf("optind = %d, argc=%d\n", optind, argc);
		fprintf(stderr, "%s: missing name\n", argv[0]);
		fprintf(stderr, usage, argv[0]);
		exit(1);
	} else if (err) {
		fprintf(stderr, usage, argv[0]);
		exit(1);
	}
	/* see what we have */
	
	if (optind < argc)	/* these are the arguments after the command-line options */
		for (; optind < argc; optind++)
		  argVal = atoi(argv[optind]);
	else {
		printf("no arguments left to process\n");
	}
	total = cint + argVal;
	printf("Total = %d\n", total); 
	exit(0);
}
