/* 
**                            CHRISTIAN ANGUS
**                                6197873
**  I certify that this program is written and programmed by me and me alone
**  
**  A program which will provide a multithreaded solution to the circuit-satisfiability problem  
**  which will compute for what combinations of input values will the circuit output the value 1.
**
**  If a thread finds a combination that satisfies the circuit, it should print out the combination 
**  (like in the given sequential version), along with the thread id (a number between 0 and 3 (p-1)).
*/

#include <stdio.h>
#include <sys/time.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>

// Count is shared between threads
int count = 0;
pthread_mutex_t locked;

// Minimum and maximum values for check_circuit function for passing to each thread
// Thread ID value for identify which thread solution is found
typedef struct arg_struct
{
    int min;
    int max;
    int tid;
} arg_struct;

/* Return 1 if 'i'th bit of 'n' is 1; 0 otherwise */
#define EXTRACT_BIT(n, i) ((n & (1 << i)) ? 1 : 0)
int check_circuit(int z, int tid)
{
    int v[16]; /* Each element is a bit of z */
    int i;
    for (i = 0; i < 16; i++)
        v[i] = EXTRACT_BIT(z, i);
    if ((v[0] || v[1]) && (!v[1] || !v[3]) && (v[2] || v[3]) && (!v[3] || !v[4]) && (v[4] || !v[5]) && (v[5] || !v[6]) && (v[5] || v[6]) && (v[6] || !v[15]) && (v[7] || !v[8]) && (!v[7] || !v[13]) && (v[8] || v[9]) && (v[8] || !v[9]) && (!v[9] || !v[10]) && (v[9] || v[11]) && (v[10] || v[11]) && (v[12] || v[13]) && (v[13] || !v[14]) && (v[14] || v[15]))
    {
        printf("%d) %d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d\n", tid,
               v[0], v[1], v[2], v[3], v[4], v[5], v[6], v[7], v[8], v[9],
               v[10], v[11], v[12], v[13], v[14], v[15]);
        return 1;
    }
    return 0;
}

// Thread function
void *check_circuit_thread_function(void *arg)
{
    pthread_mutex_lock(&locked);
    arg_struct *argmt;

    // Convert argument to data structure
    argmt = (arg_struct *)arg;
    for (int i = argmt->min; i <= argmt->max; i++)
        count += check_circuit(i, argmt->tid);

    pthread_mutex_unlock(&locked);
}

int main(int argc, char *argv[])
{
    int thread_count = 4, th;
    pthread_t threads[4];
    void *thread_result;
    int z = 65536 / thread_count;
    arg_struct argmt;
    int start, end = 0;

    start = 0;
    end = z;

    pthread_mutex_init(&locked, NULL);

    // Create threads
    for (int i = 0; i < thread_count; i++)
    {
        // Set min, max data and thread ID
        argmt.min = start;
        argmt.max = end;
        argmt.tid = i;

        // Create thread
        th = pthread_create(&threads[i], NULL, check_circuit_thread_function, (void *)&argmt);
        if (th != 0)
        {
            printf("Thread creation error %d\n", i);
            return 1;
        }

        // Sleep for giving thread time to get its parameters
        sleep(1);
        start = end + 1;
        end = end + z;
    }

    // Join all threads to this main thread to get result from it
    for (int i = 0; i < thread_count; i++)
    {
        th = pthread_join(threads[i], &thread_result);
        if (th != 0)
        {
            printf("Thread join error %d\n", i);
            return 1;
        }
    }

    pthread_mutex_destroy(&locked);

    printf("There are %d solutions\n", count);
    return 0;
}