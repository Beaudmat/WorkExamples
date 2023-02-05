namespace CSharpExample
{
    internal class Program
    {
        static void Main(string[] args)
        {

            //Creates instances of the two employees needed for the editor
            Employee one = new Employee("Fred", 304, 5195195199, 60000);
            Manager two = new Manager("Velma", 103, 8888888888, 120000, 3, 20000);

            //Controls which menu the user will be in
            int selected = 0;

            //Greetings
            Console.WriteLine("Welcome to employee editor. Please select an option by entering the number.\n");

            //Runs till user exits by going to selection 4 from the main menu
            while (true)
            {
                //Main menu allowing user to pick employee to edit, print employee info or exit the program
                if (selected == 0)
                {
                    Console.WriteLine("\n1. Edit employee one\n2. Edit employee two\n3. Print employee info\n4. Exit");
                    //Switch grabs input to check what the user wants to do
                    switch (Console.ReadLine())
                    {
                        case "1":
                            selected = 1;
                            break;
                        case "2":
                            selected = 2;
                            break;
                        case "3":
                            selected = 3;
                            break;
                        case "4":
                            selected = 4;
                            break;
                        default:
                            Console.WriteLine("Invalid Selection");
                            break;
                    }
                }
                //Menu for editing employee one. Allows editing of all employee characteristics and returning to previous menu
                else if (selected == 1)
                {
                    Console.WriteLine("\n1. Edit name\n2. Edit empID\n3. Edit phonenumber\n4. Edit yearlySalary\n" +
                        "5. Return to last menu");
                    switch (Console.ReadLine())
                    {
                        case "1":
                            Console.Write("Enter new name: ");
                            changeName(one);
                            break;
                        case "2":
                            Console.Write("Enter new empID: ");
                            changeEmpID(one);
                            break;
                        case "3":
                            Console.Write("Enter new phonenumber: ");
                            changePhoneNumber(one);
                            break;
                        case "4":
                            Console.Write("Enter new yearlySalary: ");
                            changeYearlySalary(one);
                            break;
                        case "5":
                            selected = 0;
                            break;
                        default:
                            Console.WriteLine("Invalid Selection");
                            break;
                    }
                }
                //Menu for editing employee two. Allows editing of all employee characteristics and returning to previous menu
                else if (selected == 2)
                {
                    Console.WriteLine("\n1. Edit name\n2. Edit empID\n3. Edit phonenumber\n4. Edit yearlySalary\n" +
                        "5. Edit managerLevel\n6. Edit managerBonus\n7. Return to last menu");
                    switch (Console.ReadLine())
                    {
                        case "1":
                            Console.Write("Enter new name: ");
                            changeName(two);
                            break;
                        case "2":
                            Console.Write("Enter new empID: ");
                            changeEmpID(two);
                            break;
                        case "3":
                            Console.Write("Enter new phonenumber: ");
                            changePhoneNumber(two);
                            break;
                        case "4":
                            Console.Write("Enter new yearlySalary: ");
                            changeYearlySalary(two);
                            break;
                        case "5":
                            Console.WriteLine("Enter new manager level: ");
                            changeManagerLevel(two);
                            break;
                        case "6":
                            Console.WriteLine("Enter new manager bonus: ");
                            changeManagerBonus(two);
                            break;
                        case "7":
                            selected = 0;
                            break;
                        default:
                            Console.WriteLine("Invalid Selection");
                            break;
                    }
                }
                //Prints out employee information
                else if (selected == 3)
                {
                    one.toString();
                    one.printYearlyEarnings();
                    two.toString();
                    two.printYearlyEarnings();
                    selected = 0;
                }
                //exits the program
                else if (selected == 4)
                {
                    break;
                }
                //triggers if user inputs anything other then the options
                else
                {
                    Console.WriteLine("Invalid Selection");
                    selected = 0;
                }
            }
            Console.WriteLine("Thanks for using the employee editor");
        }

        //Changes the name in a Employee object
        public static void changeName(Employee em) => em.Name = Console.ReadLine();

        //Changes the employee ID in a Employee object with a try catch incase a string is input
        public static void changeEmpID(Employee em)
        {
            try
            {
                em.EmpID = Convert.ToInt16(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("\nINVALID INPUT");
            }
        }

        //Changes the phonenumber in a Employee Object with a try catch incase a string is input
        public static void changePhoneNumber(Employee em)
        {
            try
            {
                em.PhoneNumber = Convert.ToInt64(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("\nINVALID INPUT");
            }
        }

        //Changes the YearlySalary in a Employee Object with a try catch incase a string is input
        public static void changeYearlySalary(Employee em)
        {
            try
            {
                em.YearlySalary = Convert.ToInt32(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("\nINVALID INPUT");
            }
        }

        //Changes the Manager Level in a Manager object with a try catch incase a string is input
        public static void changeManagerLevel(Manager em)
        {
            try
            {
                em.ManagerLevel = Convert.ToInt16(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("\nINVALID INPUT");
            }
        }

        //Changes the Manager Bonus in a Manager Object with a try catch incase a string is input
        public static void changeManagerBonus(Manager em)
        {
            try
            {
                em.ManagerBonus = Convert.ToInt32(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("\nINVALID INPUT");
            }
        }
    }
}