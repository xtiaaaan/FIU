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

    void displayDate()
    {
        cout << getMonth() << "/" << getDay() << "/" << getYear() << endl;
    }

private:
    int month;
    int day;
    int year;
};

int main()
{
    Date myDate1(6, 11, 2019);
    Date myDate2(-1, 11, 2021);
    Date myDate3(13, 1, 2021);

    myDate1.displayDate();
    myDate2.displayDate();
    myDate3.displayDate();
}
