#include <iostream>
#include <string>

using namespace std;

class MathOperations
{
public:

    MathOperations(int x, int y)
    {
        setNum1(x);
        setNum2(y);
    }

    void setNum1(int x)
    {
        num1 = x;
    }

    int getNum1()
    {
        return num1;
    }

    void setNum2(int y)
    {
        num2 = y;
    }

    int getNum2()
    {
        return num2;
    }

    virtual void operation() = 0;

private:
    int num1;
    int num2;
};

class Addition:public MathOperations
{
public:
    Addition(int x, int y):MathOperations(x, y)
    {

    }

    virtual void operation()
    {
        cout << getNum1() + getNum2() << endl;
    }
};

class Subtraction:public MathOperations
{
public:
    Subtraction(int x, int y):MathOperations(x, y)
    {

    }

    virtual void operation()
    {
        cout << getNum1() - getNum2() << endl;
    }
};

int main()
{
    Addition myAdd(10, 5);
    Subtraction mySub(10, 5);

    MathOperations *myMathOpPtr = 0;

    myMathOpPtr = &myAdd;
    cout << "Addition: " << endl;
    myMathOpPtr->operation();

    myMathOpPtr = &mySub;
    cout << "Subtraction: " << endl;
    myMathOpPtr->operation();
}
