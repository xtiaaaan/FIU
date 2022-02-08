#include <iostream>

using namespace std;

class Vehicle
{
public:
    Vehicle(int wh, float wg)
    {
        setWheel(wh);
        setWeight(wg);
    }

    void setWheel(int wh)
    {
        wheel = wh;
    }

    int getWheel()
    {
        return wheel;
    }

    void setWeight(float wg)
    {
        weight = wg;
    }

    float getWeight()
    {
        return weight;
    }

    virtual void displayData() = 0;

private:
    int wheel;
    float weight;
};

class Car:public Vehicle
{
public:
    Car(int wh, float wg, int pl):Vehicle(wh, wg)
    {
        setPassangerLoad(pl);
    }

    void setPassangerLoad(int pl)
    {
        passangerLoad = pl;
    }

    int getPassangerLoad()
    {
        return passangerLoad;
    }

    virtual void displayData()
    {
        cout << "Car Information" << endl;
        cout << "Wheels: " << getWheel() << endl;
        cout << "Weight: " << getWeight() << endl;
        cout << "Passenger load: " << getPassangerLoad() << endl;
    }
private:
    int passangerLoad;
};

class Truck:public Vehicle
{
public:
    Truck(int wh, float wg, float pl):Vehicle(wh, wg)
    {
        setPayLoad(pl);
    }

    void setPayLoad(float pl)
    {
        payLoad = pl;
    }

    float getPayLoad()
    {
        return payLoad;
    }

    virtual void displayData()
    {
        cout << "Truck Information" << endl;
        cout << "Wheels: " << getWheel() << endl;
        cout << "Weight: " << getWeight() << endl;
        cout << "Pay load: " << getPayLoad() << endl;
    }
private:
    float payLoad;
};

int main()
{
    Car myCar(4, 2.5, 5);
    Truck myTruck(8, 4.4, 9.5);

    Vehicle *myVehiclePtr = 0;

    myVehiclePtr = &myCar;
    myVehiclePtr->displayData();

    cout << " " << endl;

    myVehiclePtr = &myTruck;
    myVehiclePtr->displayData();

}
