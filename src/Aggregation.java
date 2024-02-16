import java.util.ArrayList;

public class Aggregation
{

    public static void main(String[] args)
    {
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor instructor2 = new Instructor("Rick","Moderna","3-1252");

        Textbook textbook1 = new Textbook("Clean Code","Robert Martin","Pearson Education Inc.");
        Textbook textbook2 = new Textbook("Crazy Code","Banard Franklin","Pearson Education Inc.");

        Course course1 = new Course("Systems Programming");
        course1.addInstructor(instructor1);
        course1.addInstructor(instructor2);
        course1.addTextbook(textbook1);
        course1.addTextbook(textbook2);

        course1.printCourse();
    }

}

class Course
{
    private String courseName;
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Textbook> textbooks = new ArrayList<>();

    public Course(String courseName)
    {
        this.courseName = courseName;
    }

    public void addInstructor(Instructor instructor)
    {
        instructors.add(instructor);
    }
    public void addTextbook(Textbook textbook)
    {
        textbooks.add(textbook);
    }

    public void printCourse()
    {
        System.out.print(courseName + " ");
        printInstructors();
        printTextbooks();

    }

    public void printInstructors()
    {
        for (int instructorNum = 0; instructorNum < instructors.size(); instructorNum++)
        {
            if (instructorNum != 0)
            {
                System.out.print(", and ");
            }
            Instructor thisInstructor = instructors.get(instructorNum);
            System.out.print(thisInstructor.getFullName() + ", office " + thisInstructor.getOfficeNumber());
        }
    }
    public void printTextbooks()
    {
        for (int textbookNum = 0; textbookNum < instructors.size(); textbookNum++)
        {
            if (textbookNum != 0)
            {
                System.out.print(", and ");
            }
            Textbook thisTextbook = textbooks.get(textbookNum);
            System.out.print(" Textbook: " + thisTextbook.getTitle() + " by " + thisTextbook.getAuthor());
        }
    }
}

class Instructor
{
    private String firstName;
    private String lastName;
    private String officeNumber;

    //Constructor

    public Instructor (String firstName, String lastName, String officeNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    //Set methods

    public void setFirstName(String name)
    {
        firstName = name;
    }
    public void setLastName(String name)
    {
        lastName = name;
    }
    public void setFullName(String fName, String lName)
    {
        firstName = fName;
        lastName = lName;
    }
    public void setOfficeNumber(String roomNumber)
    {
        officeNumber = roomNumber;
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
    public String getOfficeNumber()
    {
        return officeNumber;
    }
}

class Textbook
{
    private String title;
    private String author;
    private String publisher;

    //Constructor

    public Textbook(String title, String author, String publisher)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    //Set methods

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    //Get methods

    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPublisher()
    {
        return publisher;
    }

}