import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student 
{
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) 
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getMarks() 
    {
        return marks;
    }

    public void setMarks(double marks) 
    {
        this.marks = marks;
    }

    public String toString() 
    {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

// Main class
public class StudentManager 
{
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int choice;

        do 
        {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }

    private static void addStudent() 
    {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No students found!");
        } 
        else 
        {
            System.out.println("----- Student List -----");
            for (Student s : students) 
            {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() 
    {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();

        for (Student s : students) 
        {
            if (s.getId().equals(id)) 
            {
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    private static void deleteStudent() 
    {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        for (Student s : students) 
        {
            if (s.getId().equals(id)) 
            {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}

