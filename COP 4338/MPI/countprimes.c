#include <stdio.h>
#include "mpi.h"
#include <math.h>
#include <unistd.h>
#define N 50000 //set the vallue of N as a constant

/*
Counts the number of prime numbers from 1 to n inclusive
where n is a long integer.
*/
int isPrime(int n, int id){
	/*the only even number in prime is 2, so we start the for
	 loop at 2 and after make sure that there is no other number divisible by*/
	int cNum = n/2;

	//not prime nums
	if(n == 0 || n == 1){
		return 0;
	}

	for(int count = 2; count < cNum; count++){
		if(n % count == 0){
			return 0;
		}
	}

	fflush(stdout); // clear output buffer and move to console
	return 1;
}

int main (int argc, char *argv[]) {

	int i;
	int myid;/* Process rank*/
	int numprocs;	/*Number of processes*/

	int count = 0, totalTime, totalPrimes;//counter,time to find sol,total num of primes
	char hostname[1024];

	/*  MPI_Init always takes &argc and &argv and looks for
	MPI specific arguements like -np <num processors> */
	MPI_Init(&argc,&argv);

	/* this says how processes are running - related to
	the -np ; if don't specify then just get 1  */
	MPI_Comm_size(MPI_COMM_WORLD,&numprocs);

	/* each process 0 to <numprocesses -1> gets a unique id */
	MPI_Comm_rank(MPI_COMM_WORLD,&myid);
	hostname[1023] = '\0';

	gethostname(hostname, 1023);

	printf("ID: %d of Process: %d total\n", myid, hostname);

	//this will start to  count the time
	MPI_Barrier (MPI_COMM_WORLD);
	totalTime += MPI_Wtime();

	count = 0;
	for(i = myid + 1; i <= N; i += numprocs){
		count += isPrime(i,myid);
	}


      /* this sums together every processes count variable and
         puts it into the the totalPrimes variable */
	MPI_Reduce(&count, &totalPrimes, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

	totalTime += MPI_Wtime(); //this will stop to count the time

	MPI_Finalize();//terminates MIP exectutions

	if(!myid){
		printf("Total amount of time taken to find all the primes: %f s\n", totalTime);
		fflush(stdout);
		printf("Total prime numbers found: %d \n", totalPrimes);
	}

	return 0;
}

