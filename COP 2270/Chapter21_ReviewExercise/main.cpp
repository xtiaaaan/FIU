#include <iostream>
#include <string>

using namespace std;

class Polygon
{
public:

    Polygon(int w, int h)
    {
        setWidth(w);
        setHeight(h);
    }

    void setWidth(int w)
    {
        width = w;
    }

    int getWidth()
    {
        return width;
    }

    void setHeight(int h)
    {
        height = h;
    }

    int getHeight()
    {
        return height;
    }

    void displayMessage()
    {
        cout << "Polygon's width is: " << getWidth() << endl;
        cout << "Polygon's height is: " << getHeight() << endl;
    }

    virtual int area()
    {
        return 0;
    }

private:
    int height;
    int width;
};

class Rectangle:public Polygon
{
public:
    Rectangle(int w, int h):Polygon(w, h)
    {

    }

    virtual int area()
    {
        return getWidth() * getHeight();
    }
};

class Triangle:public Polygon
{
public:
    Triangle(int w, int h):Polygon(w, h)
    {

    }

    virtual int area()
    {
        return (getWidth() * getHeight())/2;
    }
};

int main()
{
    Polygon myPolygon(5, 4);
    Rectangle myRectangle(5, 4);
    Triangle myTriangle(5, 4);

    Polygon *myPolygonPtr = 0;

    myPolygonPtr = &myPolygon;
    cout << myPolygonPtr->area() << endl;

    myPolygonPtr = &myRectangle;
    cout << "The area of the rectangle: " << myPolygonPtr->area() << endl;

    myPolygonPtr = &myTriangle;
    cout << "The area of the triangle: " << myPolygonPtr->area() << endl;
}