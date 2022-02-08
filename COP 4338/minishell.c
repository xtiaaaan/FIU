#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>

// Commands to run
char *cat_cmd[] = { "/bin/cat", "minishell.c", 0 };
char *grep_cmd[] = { "/bin/grep", "main", 0 };

int main() {
	
	int pid, status;
	int fd[2];
	
	// Open the pipe
	pipe(fd);
	
	// Opens a new fork
	switch (pid = fork()) {
		
		// Child case
		case 0: 
			dup2(fd[1], 1);
			close(fd[0]);
			execvp(cat_cmd[0], cat_cmd);
			fprintf(stderr, "%s failed\n", cat_cmd[0]);
		
		// Error forking
		case -1:
			fprintf(stderr, "fork failed for %s\n", cat_cmd[0]);
			exit(-1);
			
		// Parent case
		default:
			break;
		
	}
	
	// Opens a new fork
	switch (pid = fork()) {
		
		// Child case
		case 0: 
			dup2(fd[0], 0);
			close(fd[1]);
			execvp(grep_cmd[0], grep_cmd);
			fprintf(stderr, "%s failed\n", grep_cmd[0]);
		
		// Error forking
		case -1:
			fprintf(stderr, "fork failed for %s\n", grep_cmd[0]);
			exit(-1);
			
		// Parent case
		default:
			break;
			
	}
	
	// Parent closes the pipe on both ends
	close(fd[0]);
	close(fd[1]);
	
	// Parent waits for each process to end
	while ((pid = wait(&status)) != -1) {
		fprintf(stderr, "process %d exits with %d\n", pid, status);
	}
	
	exit(0);

}
