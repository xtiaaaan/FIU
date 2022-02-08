#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]){
    int c, fFlag = 0;
    char name[] = "Christian\n";
    char* filename;
    static char usage[] = "Usage: writer [-f filename]\n";
    FILE *fp;

    while((c = getopt(argc, argv, "f:")) != -1){
        switch(c){
            case 'f':
                fFlag = 1;
                filename = strdup(optarg);
                break;
            case '?':
                printf("Missing arguments\n");
                printf(usage);
                exit(1);
                break;
        }
    }

    for(; optind < argc; optind++){
    }
    
    if(fFlag == 1){
        fp = fopen(filename, "w");
        fputs(name, fp);
        fclose(fp);
    }
    else{
        printf(name);
    }

    exit(0);
}