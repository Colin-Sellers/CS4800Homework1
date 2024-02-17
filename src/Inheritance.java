public class Inheritance {

    public static void main(String[] args)
    {
        SalariedEmployee employee1 = new SalariedEmployee(2500, "Joe", "Jones", "111-11-1111");
        HourlyEmployee employee2 = new HourlyEmployee(25, 32, "Stephanie", "Smith", "222-22-2222");
        HourlyEmployee employee3 = new HourlyEmployee(19, 47, "Mary", "Quinn", "333-33-3333");
        CommisionEmployee employee4 = new CommisionEmployee(15, 50000, "Nicole", "Dior", "444-44-4444");
        SalariedEmployee employee5 = new SalariedEmployee(1700, "Renwa", "Chanel", "555-55-5555");
        BaseEmployee employee6 = new BaseEmployee(95000, "Mike", "Davenport", "666-66-6666");
        CommisionEmployee employee7 = new CommisionEmployee(22, 40000, "Mahnaz", "Vaziri", "777-77-7777");

        System.out.printf("%-14s%-14s%-14s%-14s%-14s%-14s%-14s%-14s%-14s\n", "First Name", "Last Name", "Social Sec #", "Weekly Salary", "Wage", "Hours Worked", "Com rate", "Gross Salary", "Base Salary");
        printEmployee(employee1);
        printEmployee(employee2);
        printEmployee(employee3);
        printEmployee(employee4);
        printEmployee(employee5);
        printEmployee(employee6);
        printEmployee(employee7);
    }

    public static void printEmployee(Employee employee)
    {
        System.out.printf("%-14s%-14s%-14s", employee.getFirstName(), employee.getLastName(), employee.getSocialSecurtiyNumber());
    }
    public static void printEmployee(SalariedEmployee employee)
    {
        System.out.printf("%-14s%-14s%-14s", employee.getFirstName(), employee.getLastName(), employee.getSocialSecurtiyNumber());
        System.out.println("$" + employee.getWeeklySalary());
    }
    public static void printEmployee(HourlyEmployee employee)
    {
        System.out.printf("%-14s%-14s%-14s", employee.getFirstName(), employee.getLastName(), employee.getSocialSecurtiyNumber());
        System.out.printf("%15s%s%13s\n", "$", employee.getWage(), employee.getHoursWorked());
    }
    public static void printEmployee(CommisionEmployee employee)
    {
        System.out.printf("%-14s%-14s%-14s", employee.getFirstName(), employee.getLastName(), employee.getSocialSecurtiyNumber());
        System.out.printf("%44s%14s\n", employee.getCommisionRate() + "%", "$" + employee.getGrossSales());
    }
    public static void printEmployee(BaseEmployee employee)
    {
        System.out.printf("%-14s%-14s%-14s", employee.getFirstName(), employee.getLastName(), employee.getSocialSecurtiyNumber());
        System.out.printf("%71s%s\n", "$", employee.getBaseSalary());
    }


}

class Employee
{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    //Constructors

    public Employee()
    {
        firstName = "John";
        lastName = "Doe";
        socialSecurityNumber = "000-00-0000";
    }
    public Employee(String firstNameEntered, String lastNameEntered, String socialSecurityNumberEntered)
    {
        firstName = firstNameEntered;
        lastName = lastNameEntered;
        socialSecurityNumber = socialSecurityNumberEntered;
    }

    //Set methods

    public void setFirstName(String enteredName)
    {
        firstName = enteredName;
    }
    public void setLastName(String enteredName)
    {
        lastName = enteredName;
    }
    public void setFullName(String firstNameEntered, String lastNameEntered)
    {
        firstName = firstNameEntered;
        lastName = lastNameEntered;
    }
    public void setSocialSecurityNumber(String ssNumber)
    {
        socialSecurityNumber = ssNumber;
    }

    //Get methods

    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    public String getSocialSecurtiyNumber()
    {
        return socialSecurityNumber;
    }

}

class SalariedEmployee extends Employee
{
    private int weeklySalary;

    //Constructors

    public SalariedEmployee()
    {
        weeklySalary = 0;
    }
    public SalariedEmployee (int enteredWeeklySalary, Employee existingEmployee)
    {
        setFullName(existingEmployee.getFirstName(), existingEmployee.getLastName());
        setSocialSecurityNumber(existingEmployee.getSocialSecurtiyNumber());
        weeklySalary = enteredWeeklySalary;
    }
    public SalariedEmployee (int enteredWeeklySalary, String firstName, String lastName, String ssNum)
    {
        setFullName(firstName, lastName);
        setSocialSecurityNumber(ssNum);
        weeklySalary = enteredWeeklySalary;
    }

    //Set methods

    public void setWeeklySalary(int enteredWeeklySalary)
    {
        weeklySalary = enteredWeeklySalary;
    }
    //Get methods

    public int getWeeklySalary()
    {
        return weeklySalary;
    }

}

class HourlyEmployee extends Employee
{
    private int wage;
    private int numberOfHoursWorked;

    //Constructors

    public HourlyEmployee()
    {
        wage = 0;
        numberOfHoursWorked = 0;
    }
    public HourlyEmployee(int enteredWage, int enteredHoursWorked, Employee existingEmployee)
    {
        setFullName(existingEmployee.getFirstName(), existingEmployee.getLastName());
        setSocialSecurityNumber(existingEmployee.getSocialSecurtiyNumber());
        wage = enteredWage;
        numberOfHoursWorked = enteredHoursWorked;
    }
    public HourlyEmployee (int enteredWage, int enteredHoursWorked, String firstName, String lastName, String ssNum)
    {
        setFullName(firstName, lastName);
        setSocialSecurityNumber(ssNum);
        wage = enteredWage;
        numberOfHoursWorked = enteredHoursWorked;
    }

    //Set methods

    public void setWage(int enteredWage)
    {
        wage = enteredWage;
    }
    public void setNumberOfHoursWorked(int enteredHours)
    {
        numberOfHoursWorked = enteredHours;
    }

    //Get methods

    public int getWage()
    {
        return wage;
    }
    public int getHoursWorked()
    {
        return numberOfHoursWorked;
    }


}

class CommisionEmployee extends Employee
{
    private int commisionRate;
    private int grossSales;

    //Constructors

    public CommisionEmployee()
    {
        commisionRate = 0;
        grossSales = 0;
    }
    public CommisionEmployee(int enteredRate, int enteredGrossSales, Employee existingEmployee)
    {
        setFullName(existingEmployee.getFirstName(), existingEmployee.getLastName());
        setSocialSecurityNumber(existingEmployee.getSocialSecurtiyNumber());
        commisionRate = enteredRate;
        grossSales = enteredGrossSales;
    }
    public CommisionEmployee (int enteredRate, int enteredGrossSales, String firstName, String lastName, String ssNum)
    {
        setFullName(firstName, lastName);
        setSocialSecurityNumber(ssNum);
        commisionRate = enteredRate;
        grossSales = enteredGrossSales;
    }

    //Set methods

    public void setCommisionRate(int enteredRate)
    {
        commisionRate = enteredRate;
    }
    public void setGrossSales(int enteredGrossSales)
    {
        grossSales = enteredGrossSales;
    }

    //Get methods

    public int getCommisionRate()
    {
        return commisionRate;
    }
    public int getGrossSales()
    {
        return grossSales;
    }


}

class BaseEmployee extends Employee
{
    private int baseSalary;

    //Constructors

    public BaseEmployee()
    {
        baseSalary = 0;
    }
    public BaseEmployee (int enteredBaseSalary, Employee existingEmployee)
    {
        setFullName(existingEmployee.getFirstName(), existingEmployee.getLastName());
        setSocialSecurityNumber(existingEmployee.getSocialSecurtiyNumber());
        baseSalary = enteredBaseSalary;
    }
    public BaseEmployee (int enteredBaseSalary, String firstName, String lastName, String ssNum)
    {
        setFullName(firstName, lastName);
        setSocialSecurityNumber(ssNum);
        baseSalary = enteredBaseSalary;
    }

    //Set methods

    public void setBaseSalary(int enteredBaseSalary)
    {
        baseSalary = enteredBaseSalary;
    }

    //Get methods

    public int getBaseSalary()
    {
        return baseSalary;
    }

}
