import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book 
{
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public boolean isIssued() 
    {
        return isIssued;
    }

    public void issueBook() 
    {
        isIssued = true;
    }

    public void returnBook() 
    {
        isIssued = false;
    }

    public String toString() 
    {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

// User class
class User 
{
    private String userId;
    private String name;

    public User(String userId, String name) 
    {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() 
    {
        return userId;
    }

    public String getName() 
    {
        return name;
    }

    public String toString() 
    {
        return "User ID: " + userId + ", Name: " + name;
    }
}

// Library class (main controller)
class Library 
{
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<User>();

    // Add a new book
    public void addBook(String id, String title, String author) 
    {
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // Add a new user
    public void addUser(String userId, String name) 
    {
        users.add(new User(userId, name));
        System.out.println("User added successfully!");
    }

    // View all books
    public void viewBooks() 
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books available!");
        } 
        else 
        {
            System.out.println("----- Book List -----");
            for (Book b : books) 
            {
                System.out.println(b);
            }
        }
    }

    // View all users
    public void viewUsers() 
    {
        if (users.isEmpty()) 
        {
            System.out.println("No users available!");
        } 
        else 
        {
            System.out.println("----- User List -----");
            for (User u : users) 
            {
                System.out.println(u);
            }
        }
    }

    // Issue a book
    public void issueBook(String bookId, String userId) 
    {
        Book foundBook = null;
        for (Book b : books) 
        {
            if (b.getId().equals(bookId)) 
            {
                foundBook = b;
                break;
            }
        }

        if (foundBook == null) 
        {
            System.out.println("Book not found!");
            return;
        }

        if (foundBook.isIssued()) 
        {
            System.out.println("Book is already issued!");
            return;
        }

        for (User u : users) 
        {
            if (u.getUserId().equals(userId)) 
            {
                foundBook.issueBook();
                System.out.println("Book issued to " + u.getName());
                return;
            }
        }

        System.out.println("User not found!");
    }

    // Return a book
    public void returnBook(String bookId) 
    {
        for (Book b : books) {
            if (b.getId().equals(bookId)) 
            {
                if (b.isIssued()) 
                {
                    b.returnBook();
                    System.out.println("Book returned successfully!");
                } 
                else 
                {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

// Main system class
public class LibrarySystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do 
        {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View All Books");
            System.out.println("4. View All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(bookId, title, author);
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    library.addUser(userId, name);
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    library.viewUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookId = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String issueUserId = sc.nextLine();
                    library.issueBook(issueBookId, issueUserId);
                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = sc.nextLine();
                    library.returnBook(returnBookId);
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
