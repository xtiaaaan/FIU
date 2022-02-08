#include <stdio.h>
#include <string.h>

typedef struct DOB{
    int month;
    int date;
    int year;
} DOB;

typedef struct STUDENT{
    char firstName[30];
    char lastName[30];
    char studentID[7];
    DOB dob;
    int standing;
    float GPA;
} STUDENT;


int main(void){
    STUDENT student1;
    STUDENT* student2 = &student1;

    strcpy(student1.firstName, "Christian");
    strcpy(student1.lastName, "Angus");
    strcpy(student1.studentID, "6197873");
    student1.dob.month = 7;
    student1.dob.date = 4;
    student1.dob.year = 1994;
    student1.standing = 3;
    student1.GPA = 3.8;

    printf("Name: %s %s\n", student1.firstName, student1.lastName);
    printf("Student ID: %s\n", student1.studentID);
    printf("DOB: %d/%d/%d\n", student1.dob.month, student1.dob.date, student1.dob.year);
    if(student1.standing == 1){
        printf("Standing: Freshman\n");
    }
    else if(student1.standing == 2){
        printf("Standing: Sophomore\n");
    }
    else if(student1.standing == 3){
        printf("Standing: Junior\n");
    }
    else if(student1.standing == 4){
        printf("Standing: Senior\n");
    }
    printf("GPA: %.1f\n", student1.GPA);

    printf("Name: %s %s\n", student2->firstName, student2->lastName);
    printf("Student ID: %s\n", student2->studentID);
    printf("DOB: %d/%d/%d\n", student2->dob.month, student2->dob.date, student2->dob.year);
    if(student2->standing == 1){
        printf("Standing: Freshman\n");
    }
    else if(student2->standing == 2){
        printf("Standing: Sophomore\n");
    }
    else if(student2->standing == 3){
        printf("Standing: Junior\n");
    }
    else if(student2->standing == 4){
        printf("Standing: Senior\n");
    }
    printf("GPA: %.1f\n", student2->GPA);

    return 0;
}