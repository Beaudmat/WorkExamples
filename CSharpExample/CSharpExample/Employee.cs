using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpExample
{
    internal class Employee
    {

        //Stores Employees Name. Validates the Name isn't blank.
        private String _name;

        public String Name
        {
            get { return _name; }
            set 
            { 
                if(value != "")
                    _name = value;
                else
                    Console.WriteLine("Name can't be blank");
            }
        }

        //Stores Employees Employee ID. Validates its not less then 0.
        private int _empID;

        public int EmpID
        {
            get { return _empID; }
            set 
            {
                if (value >= 0)
                    _empID = value;
                else
                    Console.WriteLine("EmpID can't be less then 0");
            }
        }

        //Stores Employees Phonenumber. Validates its not less then 0.
        private long _phoneNumber;

        public long PhoneNumber
        {
            get { return _phoneNumber; }
            set 
            {
                if (value >= 0)
                    _phoneNumber = value;
                else
                    Console.WriteLine("Phonenumber can't be less then 0");
            }
        }

        //Stores Employees Yearly Salary. Validates its not less then 0.
        private double _yearlySalary;

        public double YearlySalary
        {
            get { return _yearlySalary; }
            set 
            {
                if (value >= 0)
                    _yearlySalary = value;
                else
                    Console.WriteLine("YearlySalary can't be less then 0");
            }
        }

        //Constructor
        public Employee(string name, int empID, long phoneNumber, double yearlySalary)
        {
            _name = name;
            _empID = empID;
            _phoneNumber = phoneNumber;
            _yearlySalary = yearlySalary;
        }

        //Prints Employees salary
        public void printYearlyEarnings()
        {
            Console.WriteLine("\n{0} earns {1} yearly.", _name, _yearlySalary.ToString("C"));
        }

        //Prints Employee
        public void toString()
        {
            Console.WriteLine("\nEmployee Name: {0}\nEmployee ID: {1}\nPhoneNumber: {2}\nYearly Salary: {3}", 
                _name, _empID, _phoneNumber, _yearlySalary);
        }
    }
}
