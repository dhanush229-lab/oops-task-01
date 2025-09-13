package librarymanager;
import java.util.Scanner;


public class Main
{
    
    public static void main(String[] args)
    {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
      
        
        System.out.println("Welcome to Library Management System of NMAMIT");
        
        boolean running = true;
        while (running)
        {
            showMenu();
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) 
            {
                case 1:
                    addNewBook(library, scanner);
                    break;
                case 2:
                    issueBookToStudent(library, scanner);
                    break;
                case 3:
                    returnBookFromStudent(library, scanner);
                    break;
                case 4:
                    checkBookAvailability(library, scanner);
                    break;
                case 5:
                    library.showAllBooks();
                    break;
                case 6:
                    System.out.println("Thank you for using the NMAMIT Library Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (running) 
            {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void showMenu() {
        System.out.println("Enter your choice from the MENU ");
        System.out.println("1. Add New Book");
        System.out.println("2. Issue Book");
        System.out.println("3. Return Book");
        System.out.println("4. Check Availability");
        System.out.println("5. Show All Books");
        System.out.println("6. Exit");
    }
    
    private static void addNewBook(LibraryManager library, Scanner scanner) 
    {
        System.out.println(" Add New Book ");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.println("Select book type:");
        System.out.println("1. Regular Book");
        System.out.println("2. Physical Book");
        System.out.println("3. Digital Book");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        switch (type) 
        {
            case 1:
                library.addBook(new Book(title, author, isbn));
                break;
            case 2:
                System.out.print("Enter shelf location: ");
                String location = scanner.nextLine();
                library.addBook(new PhysicalBook(title, author, isbn, location));
                break;
            case 3:
                System.out.print("Enter download URL: ");
                String url = scanner.nextLine();
                library.addBook(new DigitalBook(title, author, isbn, url));
                break;
            default:
                System.out.println("Invalid type Adding as regular book.");
                library.addBook(new Book(title, author, isbn));
        }
        
        System.out.println("Book added successfully!");
    }
    
    private static void issueBookToStudent(LibraryManager library, Scanner scanner) 
    {
        System.out.println("Issue Book");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        
        if (library.issueBook(isbn, studentName)) 
        {
            System.out.println("Book issued successfully to " + studentName);
        } else 
        {
            System.out.println("Failed to issue book. Check ISBN and availability.");
        }
    }
    
    private static void returnBookFromStudent(LibraryManager library, Scanner scanner) 
    {
        System.out.println("Return Book");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        
        if (library.returnBook(isbn, studentName)) 
        {
            System.out.println("Book returned successfully from " + studentName);
        } else 
        {
            System.out.println("Failed to return book. Check ISBN and student name.");
        }
    }
    
    private static void checkBookAvailability(LibraryManager library, Scanner scanner) 
    {
        System.out.println("Check Availability");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        if (library.isAvailable(isbn))
        {
            System.out.println("Book is AVAILABLE for issue");
        } 
        else 
        {
            System.out.println("Book is NOT AVAILABLE (either issued or doesn't exist)");
        }
    }
}
