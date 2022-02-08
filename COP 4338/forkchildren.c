#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

void main(){
  int n1 = fork();
  int n2 = fork();
  if (n1 == 0 && n2 > 0){ //checking if child1
      system("ls -l");
      exit(0);
  }else{
      pid_t cpid;
      cpid = wait(NULL);
  }

  if (n1 > 0 && n2 == 0){ //checking if child2
      system("cat forkchildren.c");
      exit(0);
  }else{
      pid_t cpid;
      cpid = wait(NULL);
  }
}