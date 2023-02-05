using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace CSharpExample
{
    internal class Manager : Employee
    {
        //Stores a Managers Manager Level. Validates its within the 3 acceptable levels.
        private int _managerLevel;

        public int ManagerLevel
        {
            get { return _managerLevel; }
            set 
            {
                if (value < 4 && value > 0)
                    _managerLevel = value;
                else
                    Console.WriteLine("Manager level must be 1,2 or 3");
            }
        }

        //Stores the Managers Bonus. Validates its greater then 0.
        private double _managerBonus;

        public double ManagerBonus
        {
            get { return _managerBonus; }
            set 
            {
                if (value >= 0)
                    _managerBonus = value;
                else
                    Console.WriteLine("Manager Bonus can't be less then 0");
            }
        }

        //Constructor
        public Manager(String name, int empID, long phoneNumber, double yearlySalary, int managerLevel, double managerBonus) 
            : base(name, empID, phoneNumber, yearlySalary)
        {
            _managerLevel = managerLevel;
            _managerBonus = managerBonus;
        }

        //Prints Employees salary and bonus combined for total yearlyEarnings. Also prints their bonus alongside. 
        public new void printYearlyEarnings()
        {
            Console.WriteLine("\n{0} earns {1} yearly with their {2} bonus included.", base.Name, 
                (base.YearlySalary + _managerBonus).ToString("C"), _managerBonus.ToString("C"));
        }

        //Prints Manager
        public new void toString()
        {
            base.toString();
            Console.WriteLine("Manager Level: {0}" + "\nManager Bonus: {1}", _managerLevel, _managerBonus);
        }
    }
}
