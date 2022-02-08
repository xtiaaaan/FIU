#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

typedef struct bst_node{
    char *word;
    int count;
    struct bst_node *left;
    struct bst_node *right;
} node;

//case sensitive compare
int stringCompareUpper(char *str1, char *str2){
    int i = 0;
    char c1, c2;
    while(str1[i] != '\0' && str2[i] != '\0'){
        c1 = str1[i];
        c2 = str2[i];

        if(c1 != c2){
            return -1;
        }
        i++;
    }

    if(str1[i] == '\0' && str2[i] != '\0'){
        return 0;
    }
    else if(str1[i] != '\0' && str2[i] == '\0'){
        return 1;
    }
    else{
        return -1;
    }
}

int stringCompareLower(char *str1, char *str2){
    int i = 0;
    char c1, c2;
    while(str1[i] != '\0' && str2[i] != '\0'){
        c1 = str1[i];
        c2 = str2[i];

        if(c1 >= 'a' && c1 <= 'z'){
            c1 = c1 - 'a' + 'z';
        }
        if(c2 >= 'a' && c2 <= 'z'){
            c2 = c2 - 'a' + 'z';
        }
        if(c1 != c2){
            return -1;
        }
        i++;
    }
    if(str1[i] == '\0' && str2[i] != '\0'){
        return 0;
    }
    else if(str1[i] != '\0' && str2[i] == '\0'){
        return 1;
    }
    else{
        return -1;
    }
}

int stringCompare(char *str1, char *str2){
    int i = 0;
    char c1, c2;
    while(str1[i] != '\0' && str2[i] != '\0'){
        c1 = str1[i];
        c2 = str2[i];

        if(c1 >= 'A' && c1 <= 'Z'){
            c1 = c1 - 'A' + 'Z';
        }
        if(c2 >= 'A' && c2 <= 'Z'){
            c2 = c2 - 'A' + 'Z';
        }
        if(c1 != c2){
            return -1;
        }
        i++;
    }
    if(str1[i] == '\0' && str2[i] != '\0'){
        return 0;
    }
    else if(str1[i] != '\0' && str2[i] == '\0'){
        return 1;
    }
    else{
        return -1;
    }
}

node* createNode(char *str){
    node* n = (node*) malloc(sizeof(node));
    n->word = (char*) malloc(strlen(str)+1); // Add 1 here as it needs one char to put end of string, that is 0
    n->count = 1;
    strcpy(n->word, str);
        
    n->left = NULL;
    n->right = NULL;
    return n;
}


void insert(node **root, char *str, int caseSensitive){
    node *current;
    int compare;

    if(*root == NULL){
        *root = createNode(str);
    }
    
    if(caseSensitive == 1){
        if(stringCompareUpper(str, (*root)->word) == 0){
            (*root)->count++;
        }
        else if(stringCompareUpper(str, (*root)->word) > 0){
            insert(str, &(*root)->right, caseSensitive);
        }
        else if(stringCompareUpper(str, (*root)->word) < 0){
            insert(str, &(*root)->left, caseSensitive);
        }
    }
    else if(caseSensitive == 0){
        if(stringCompare(str, (*root)->word) == 0){
            (*root)->count++;
        }
        else if(stringCompare(str, (*root)->word) > 0){
            insert(str, &(*root)->right, caseSensitive);
        }
        else if(stringCompare(str, (*root)->word) < 0){
            insert(str, &(*root)->left, caseSensitive);
        }
    }
}

void inOrder(FILE *outFile, node *node){
    if(node == NULL){
        return;
    }
    inOrder(outFile, node->left);
    fprintf(outFile, "%s[%d]\n", node->word, node->count);
    inOrder(outFile, node->right);
}

void freeNode(node *root){
    if(root == NULL){
        return;
    }

    freeNode(root->left);
    freeNode(root->right);
    free(root->word);
    free(root);
}


int main(int argc, char **argv){
    extern char *optarg;
    extern int optind;
    int c, err = 0;
    int cflag = 0, oflag = 0, lflag = 0;
    int caseSensitive = 0;
    char string[100];
    node *root = NULL;
    char *output_file_name, *input_file_name;
    FILE* inFile = stdin;
    FILE* outFile = stdout;
    static char usage[] = "usage: %bstsort [-c] [-l] [-o output_file_name][input_file_name]\n";

    while ((c = getopt(argc, argv, "clo:")) != -1){
        switch (c) {
        case 'c':
            cflag = 1;
            break;
        case 'l':
            lflag = 1;
            break;
        case 'o':
            oflag = 1;
            output_file_name = optarg;
            break;
        case '?':
            err = 1;
            break;
        }
    }

    if(cflag == 1 && lflag == 1){
        printf("You cannot use -c and -l at the same time \n");
        printf("%s \n", usage);
        exit(1);
    }
    else if(cflag == 1){
        caseSensitive = 1;
    }
    else if(lflag == 1){
        caseSensitive = -1;
    }

    if(oflag == 1){
        if((outFile = fopen(output_file_name, "w")) == NULL){
            //...the user is promted of the error
            printf("\aCould not open file.\n");
            //...the user is also promted to make sure the proper file extension was included
            printf("\aMake sure the file's extension is included in file name.\n");
            //... the progam is exited
            exit(1);
        }
    }

    if(optind > argc){
        input_file_name = argv[optind];
    
        if((inFile = fopen(input_file_name, "r")) == NULL){
            //...the user is promted of the error
            printf("\aCould not open file.\n");
            //...the user is also promted to make sure the proper file extension was included
            printf("\aMake sure the file's extension is included in file name.\n");
            //... the progam is exited
            exit(1);
        }
    }

    while(fgets(string, 100, inFile) != NULL){
        if(stringCompare("\n", string) == 0){
            break;
        }
        //remove newline from the end of line
        string[strlen(string) - 1] = '\0';
        insert(&root, string, caseSensitive);
    }

    fclose(inFile);
    inOrder(outFile, root);
    fclose(outFile);
    freeNode(root);
    exit(0);
}