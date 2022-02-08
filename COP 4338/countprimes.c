/* 
**                            CHRISTIAN ANGUS
**                                6197873
**  I certify that this program is written and programmed by me and me alone
**  
**              A program that emulates a bash terminal
*/

#include "mpi.h"
#include <stdio.h>
#include <unistd.h>

#define N 50000

int checkPrime(int id, int n)
{

    // Check if n is 1 or 0.
    if (n == 0 || n == 1)
    {
        return 0;
    }

    int i;

    // Checks all even numbers
    for (i = 2; i <= n / 2; i++)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }

    printf("%d) %d\n", id, n);
    fflush(stdout);
    return 1;
}

int main(int argc, char *argv[])
{
    int count;
    double timeElapsed;
    int total;
    int i;
    int id;
    int p;
    char hostname[1024];

    MPI_Init(&argc, &argv);

    MPI_Comm_rank(MPI_COMM_WORLD, &id);
    MPI_Comm_size(MPI_COMM_WORLD, &p);

    hostname[1023] = '\0';
    gethostname(hostname, 1023);
    printf("MPI ranked: %d on host %s\n", id, hostname);

    MPI_Barrier(MPI_COMM_WORLD);
    timeElapsed = -MPI_Wtime();

    count = 0;
    for (i = id; i < N; i += p)
        count += checkPrime(id, i);

    MPI_Reduce(&count, &total, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    timeElapsed += MPI_Wtime();

    if (!id)
    {
        printf("Executed in %8.6f seconds\n", timeElapsed);
        fflush(stdout);
    }
    MPI_Finalize();
    if (!id)
    {
        printf("Total prime numbers: %d\n", total);
        return 0;
    }
}