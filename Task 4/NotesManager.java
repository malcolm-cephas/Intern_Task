import java.io.*;
import java.util.*;

public class NotesManager 
{
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\n===== Text-Based Notes Manager =====");
            System.out.println("1: Write a Note");
            System.out.println("2: View All Notes");
            System.out.println("3: Clear All Notes");
            System.out.println("4: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) 
            {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    clearNotes();
                    break;
                case 4:
                    System.out.println("Exiting Notes Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    private static void writeNote(Scanner sc) 
    {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) 
        {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    private static void readNotes() 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) 
        {
            System.out.println("\n--- Saved Notes ---");
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null)
            {
                System.out.println("- " + line);
                empty = false;
            }
            if (empty) System.out.println("No notes found.");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("No notes file found. Create one by writing a note first.");
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    private static void clearNotes() 
    {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) 
        {
            writer.write("");
            System.out.println("All notes cleared.");
        } catch (IOException e) 
        {
            System.out.println("Error clearing notes: " + e.getMessage());
        }
    }
}
