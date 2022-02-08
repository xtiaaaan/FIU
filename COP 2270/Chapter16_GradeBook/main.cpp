#include <iostream>
#include <string>

using namespace std;

class GradeBook
{
public:

    void setProfessorName(string name)
    {
        professorName = name;
    }

    string getProfessorName()
    {
        return professorName;
    }

    GradeBook(string name1, string name2)
    {
        setCourseName(name1);
        setProfessorName(name2);
    }

    void setCourseName(string name)
    {
        courseName = name;
    }

    string getCourseName()
    {
        return courseName;
    }

    void displayMessage()
    {
        cout << "Welcome to the grade book for: " << getCourseName() << "!" << endl;
        cout << "This course is presented by; " << getProfessorName() << endl;
    }

private:
    string courseName;

    string professorName;

};

int main()
{
    GradeBook gradeBook1("CS101 Introduction to C++ Programming", "The firsts professor");
    GradeBook gradeBook2("CS102 Data Structures in C++", "The second professor");

    cout << "gradebook1 created for course: " << gradeBook1.getCourseName()
        << "\nThis course is presented by: " << gradeBook1.getProfessorName()
        << "\ngradebook2 created for course: " << gradeBook2.getCourseName()
        << "\nThis course is presented by: " << gradeBook2.getProfessorName()
        <<  endl;
}
