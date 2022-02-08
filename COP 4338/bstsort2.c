#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h>

int stringCompare(char *s1, char *s2){
    while(*s1 && *s2 && *s1 == *s2){
        ++s1;
        ++s2;
    }
    return(*s1 - *s2);
}

int stringCompare2(char const *s1, char const *s2){
    for(;;s1++, s2++){
        int d = toupper(*s1) - toupper(*s2);
        if(d != 0 || !*s1){
            return d;
        }
    }
}

struct NODE{
    char string[100];
    int count;
    struct NODE* left;
    struct NODE* right;
};

insert(char word[100], struct NODE **leaf, int caseflag){
    if(caseflag == 1){
        if(*leaf == NULL){
            *leaf = (struct NODE*) malloc(sizeof(struct NODE*));
            strcpy((*leaf)->string, word);
            (*leaf)->count = 1;
            (*leaf)->left = NULL;
            (*leaf)->right = NULL;
        }
        else if(stringCompare(word, (*leaf)->string) == 0){
            (*leaf)->count++;
        }
        else if(stringCompare(word, (*leaf)->string) > 0){
            insert(word, &(*leaf)->right, caseflag);
        }
        else if(stringCompare(word, (*leaf)->string) < 0){
            insert(word, &(*leaf)->left, caseflag);
        }
    }
    else{
        if(*leaf == NULL){
            *leaf = (struct NODE*) malloc(sizeof(struct NODE*));
            strcpy((*leaf)->string, word);
            (*leaf)->count = 1;
            (*leaf)->left = NULL;
            (*leaf)->right = NULL;
        }
        else if(stringCompare2(word, (*leaf)->string) == 0){
            (*leaf)->count++;
        }
        else if(stringCompare2(word, (*leaf)->string) > 0){
            insert(word, &(*leaf)->right, caseflag);
        }
        else if(stringCompare2(word, (*leaf)->string) < 0){
            insert(word, &(*leaf)->left, caseflag);
        }
    }
}

void inOrder(struct NODE *leaf, FILE* outFile){
    int temp;

    if(leaf != NULL){
        inOrder((leaf)->left, outFile);

        for(temp = 0; temp < (leaf->count); temp++){
            fprintf(outFile, "%s\n", (leaf->string));
        }
        inOrder((leaf)->right, outFile);
    }
}

void clearTree(struct NODE* leaf){
    if(leaf != NULL){
        clearTree(leaf->left);
        clearTree(leaf->right);
        free(leaf->string);
        free(leaf);
    }
}

int main(int argc, char **argv){
    extern char *optarg;
    extern int optind;
    int c, err = 0;
    int cflag = 0, lflag = 0, oflag = 0;
    FILE* inFile = stdin;
    FILE* outFile = stdout;
    char word[100];
    char *sentence;
    struct NODE* root = NULL;
    
    static char usage[] = "Usage: bstsort [-c] [-o output_file_name] [input_file_name]\n";

    while((c = getopt(argc, argv, "co:")) != -1){
        switch(c){
            case 'c':
                cflag = 1;
                break;
            // case 'l':
            //     lflag = 1;
            //     break;
            case 'o':
                oflag = 1;
                outFile = fopen(optarg, "w");
                break;
            case '?':
                err = 1;
                printf("%s", usage);
                break;
        }
    }

    if(argv[optind] != NULL){
        inFile = fopen(argv[optind], "r");

        if(inFile == NULL){
            printf("File not found.\n");
            exit(0);
        }
    }

    while(fgets(word, sizeof(word), inFile) != NULL){
        sentence = (char*) malloc(strlen(word));
        strcpy(sentence, word);
        insert(sentence, &root, cflag);
    }

    inOrder(root, outFile);
    clearTree(root);

}