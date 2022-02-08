#include <iostream>
#include "GradeBook.h"
using namespace std;

int main()
{
    GradeBook gradebook1("CS101 Introduction to C++ Programming");
    GradeBook gradebook2("CS102 C++ Data Structures");

    cout << "gradeBook1's initial course name is: " << gradebook1.getCourseName()
        <<"\ngradeBook2's initial course name is: " << gradebook2.getCourseName()
        << endl;

    gradebook1.setCourseName("CS101 C++ Programming");

    cout << "\ngradeBook1's course name is: " << gradebook1.getCourseName()
        <<"\ngradeBook2's course name is: " << gradebook2.getCourseName()
        << endl;
}
