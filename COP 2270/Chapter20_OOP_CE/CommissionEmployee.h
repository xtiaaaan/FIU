#include <string>
using namespace std;

class CommissionEmployee
{
public:
    // Constructor
    CommissionEmployee( const string &, const string &, const string &, double = 0.0, double = 0.0 );

    // Set and Get member functions
    void setFirstName( const string & );
    string getFirstName() const;

    void setLastName( const string & );
    string getLastName() const;

    void setSocialSecurityNumber( const string & );
    string getSocialSecurityNumber() const;

    void setGrossSales( double );
    double getGrossSales() const;

    void setCommissionRate( double );
    double getCommissionRate() const;

    // calculate earnings
    double earnings() const;

    // print CommissionEmployee object
    void print() const;

private:
    string firstName;
    string lastName;
    string socialSecurityNumber;
    double grossSales; // gross weekly sales
    double commissionRate; // commission percentage
};
