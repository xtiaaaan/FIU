#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Books{
    char title[50];
    char author[50];
    char ISBN[15];
    int book_id;
};

void printBook(struct Books bk);

int main()
{
    struct Books Bk1;
    struct Books Bk2;

    strcpy(Bk1.title, "C How to Program");
    strcpy(Bk1.author, "Paul Deitel");
    strcpy(Bk1.ISBN, "9780133976892");
    Bk1.book_id = 6495407;

    strcpy(Bk2.title, "Data and Computer Communications");
    strcpy(Bk2.author, "William Stallings");
    strcpy(Bk2.ISBN, "9780133506488");
    Bk2.book_id = 6495700;

    printBook(Bk1);
    printBook(Bk2);

    return 0;
}

void printBook(struct Books bk){

    puts("");
    printf("Book Title: %s\n", bk.title);
    printf("Book Author: %s\n", bk.author);
    printf("Book ISBN: %s\n", bk.ISBN);
    printf("Book ID: %d\n", bk.book_id);
}
