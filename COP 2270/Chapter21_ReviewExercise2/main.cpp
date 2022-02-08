#include <iostream>
#include <string>

using namespace std;

class Date
{
public:

    Date(int m, int d, int y)
    {
        setMonth(m);
        setDay(d);
        setYear(y);
    }

    void setMonth(int m)
    {
        if((m > 1) && (m < 12))
            month = m;
        if(m < 1)
            month = 1;
        if(m > 12)
            month = 12;
    }

    double getMonth()
    {
        return month;
    }

    void setDay(int d)
    {
        day = d;
    }

    double getDay()
    {
        return day;
    }

    void setYear(int y)
    {
        year = y;
    }

    double getYear()
    {
        return year;
    }

    virtual void displayDate() = 0;

private:
    int month;
    int day;
    int year;
};

class DateEn:public Date
{
public:
    DateEn(int m, int d, int y):Date(m, d, y)
    {

    }

    virtual void displayDate()
    {
        cout << getMonth() << "/" << getDay() << "/" << getYear() << endl;
    }
};

class DateSp:public Date
{
public:
    DateSp(int d, int m, int y):Date(d, m, y)
    {

    }

    virtual void displayDate()
    {
        cout << getDay() << "/" << getMonth() << "/" << getYear() << endl;
    }
};

int main()
{
    DateEn myDateEn(11, 29, 2018);
    DateSp myDateSp(11, 29, 2018);

    Date *myDatePtr = 0;

    myDatePtr = &myDateEn;
    cout << "Date in English format is (mm/dd/yyyy): " << endl;
    myDatePtr->displayDate();

    myDatePtr = &myDateSp;
    cout << "Date in Spanish format is (dd/mm/yyyy): " << endl;
    myDatePtr->displayDate();
}
