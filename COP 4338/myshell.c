#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

#define MAX_ARGS 20
#define BUFFSIZ 1024

int get_args(char *cmdline, char *args[])
{
    int i = 0;

    /* if no args */
    if ((args[0] = strtok(cmdline, "\n\t ")) == NULL)
        return 0;

    while ((args[++i] = strtok(NULL, "\n\t ")) != NULL)
    {
        if (i >= MAX_ARGS)
        {
            printf("Too many arguments!\n");
            exit(1);
        }
    }
    /* the last one is always NULL */
    return i;
}

void execute(char *cmdline)
{
    int pid, async, index, pipeIndex;
    char *args[MAX_ARGS];
    char oflag = 0, aflag = 0, iflag = 0, pflag = 0, ischild = 0;

    char *ofile;
    char *ifile;
    char *argsCopy[MAX_ARGS];
    int ofileNo, ifileNo;
    FILE *outfp, *infp;

    memset(argsCopy, 0, sizeof(argsCopy));

    // Get the number of arguments
    int nargs = get_args(cmdline, args);
    if (nargs <= 0)
        return;

    // Check if user wants to exit shell
    if (!strcmp(args[0], "quit") || !strcmp(args[0], "exit"))
    {
        exit(0);
    }

    /* check if async call */
    if (!strcmp(args[nargs - 1], "&"))
    {
        async = 1;
        args[--nargs] = 0;
    }
    else
        async = 0;

    index = pipeIndex = 0;

    // Cycle through arguments until a shell redirect is found
    while (!ischild && index < nargs)
    {
        pipeIndex = 0;
        oflag = 0;
        aflag = 0;
        iflag = 0;
        pflag = 0;
        ischild = 0;

        while (index < nargs)
        {
            // Check if output is being rerouted\]
            if (!strcmp(args[index], ">") || !strcmp(args[index], ">>"))
            {
                //check for error conditions
                if (oflag || aflag)
                {
                    printf("ERROR: too many output redirects\n");
                    return;
                }

                // assign correct output file name
                if (!strcmp(args[index], ">"))
                {
                    oflag = 1;
                    ofile = args[index + 1];
                }
                else if (!strcmp(args[index], ">>"))
                {
                    aflag = 1;
                    ofile = args[index + 1];
                }

                args[index] = 0;
                args[++index] = 0;
            }
            else if (!strcmp(args[index], "<"))
            {
                if (iflag)
                {
                    printf("ERROR: too many input redirects\n");
                }

                // Assign correct input file name
                iflag = 1;
                ifile = args[index + 1];
                args[index] = 0;
                args[++index] = 0;
            }
            else if (!strcmp(args[index], "|"))
            {
                pflag = 1;
            }

            index++;
        }

        pid = fork();
        if (pid == 0)
        { /* child process */
            ischild = 1;
            // Output is redirected
            if (oflag)
            {
                if ((outfp = fopen(ofile, "w")) == NULL)
                {
                    return;
                }
                else
                {
                    ofileNo = fileno(outfp);
                    dup2(ofileNo, STDOUT_FILENO);
                }
            }

            // Output is appended
            if (aflag)
            {
                if ((outfp = fopen(ofile, "a")) == NULL)
                {
                    return;
                }
                else
                {
                    ofileNo = fileno(outfp);
                    dup2(ofileNo, STDOUT_FILENO);
                }
            }

            // Input is redirected
            if (iflag)
            {
                if ((infp = fopen(ifile, "r")) == NULL)
                {
                    return;
                }
                else
                {
                    ifileNo = fileno(infp);
                    dup2(ifileNo, STDIN_FILENO);
                }
            }

            execvp(args[0], args);

            /* return only when exec fails */
            perror("exec failed");
            exit(-1);
        }
        else if (pid > 0)
        { /* parent process */
            if (!async)
                waitpid(pid, NULL, 0);
            else
                printf("this is an async call\n");
        }
        else
        { /* error occurred */
            perror("fork failed");
            exit(1);
        }
    }
}

int main(int argc, char *argv[])
{
    char cmdline[BUFSIZ];

    for (;;)
    {
        printf("COP4338$ ");
        if (fgets(cmdline, BUFSIZ, stdin) == NULL)
        {
            perror("fgets failed");
            exit(1);
        }
        execute(cmdline);
    }
    return 0;
}