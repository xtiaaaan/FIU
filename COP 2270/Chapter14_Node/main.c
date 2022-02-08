#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node* nextPtr;
};

int main()
{
    struct node myList;

    myList.nextPtr = NULL;
    myList.data = 10;

    struct node* new_node = malloc(sizeof(struct node));
    new_node -> data = 30;
    new_node -> nextPtr = NULL;

    myList.nextPtr = new_node;

    struct node* tempNode = &myList;
    while(tempNode != NULL){
        printf(" %d -> ", tempNode -> data);
        tempNode = tempNode -> nextPtr;
    }

    puts("NULL");

    return 0;
}
