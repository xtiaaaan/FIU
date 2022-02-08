#include <iostream>

using namespace std;

class Invoice
{
public:
    Invoice(string pN, string pD, int q, float p)
    {
        setPartNumber(pN);
        setPartDescription(pD);
        setQuantity(q);
        setPrice(p);
    }

    void setPartNumber(string pN)
    {
        partNumber = pN;
    }

    string getPartNumber()
    {
        return partNumber;
    }

    void setPartDescription(string pD)
    {
        partDescription = pD;
    }

    string getPartDescription()
    {
        return partDescription;
    }

    void setQuantity(int q)
    {
        if(q > 0)
            quantity = q;
        if(q <= 0)
            quantity = 0;
    }

    int getQuantity()
    {
        return quantity;
    }

    void setPrice(float p)
    {
        if(p > 0)
            price = p;
        if(p <= 0)
            price = 0;
    }

    float getPrice()
    {
        return price;
    }

    float getInvoiceAmount()
    {
        return getQuantity() * getPrice();
    }

    void displayData()
    {
        cout << "partNumber: " << getPartNumber() << endl;
        cout << "Description: " << getPartDescription() << endl;
        cout << "Item Quantity: " << getQuantity() << endl;
        cout << "Item Price: " << getPrice() << endl;
        cout << "Item Invoice: " << getInvoiceAmount() << endl;
    }

private:
    string partNumber;
    string partDescription;
    int quantity;
    float price;
};

int main()
{
    Invoice firstItem("1A", "Hammer", 4, 400.00);
    Invoice secondItem("2A", "Screwdriver Set", 0, 0.00);

    cout << "First Item" << endl;
    firstItem.displayData();
    cout << "\nSecond Item" << endl;
    secondItem.displayData();
}
