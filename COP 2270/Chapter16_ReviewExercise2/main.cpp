#include <iostream>
#include <string>

using namespace std;

class Box
{
public:

    Box(double l, double b, double h)
    {
        setLength(l);
        setBreadth(b);
        setHeight(h);
    }

    void setLength(double l)
    {
        if((l < 5) && (l > 0.2))
            length = l;
        else
            length = 0;
    }

    double getLength()
    {
        return length;
    }

    void setBreadth(double b)
    {
        if((b < 5) && (b > 0.2))
            breadth = b;
        else
            breadth = 0;
    }

    double getBreadth()
    {
        return breadth;
    }

    void setHeight(double h)
    {
        if((h < 10) && (h > 0.2))
            height = h;
        else
            height = 0;
    }

    double getHeight()
    {
        return height;
    }

    void displayVolume()
    {
        cout << "The volume of the box is: " << getBreadth() * getHeight() * getLength() << "\n" << endl;
    }

private:
    double length;
    double breadth;
    double height;

};

int main()
{
    Box myBox1(4, 4, 8);
    Box myBox2(9, 4, 8);
    Box myBox3(4, 4, 15);

    myBox1.displayVolume();
    myBox2.displayVolume();
    myBox3.displayVolume();
}
