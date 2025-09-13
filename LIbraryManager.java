package librarymanager;
import java.util.HashMap;
import java.util.ArrayList;


public class LibraryManager implements Issueable 
{
    
    private HashMap<String, Book> books;
    

    public LibraryManager() 
    {
        books = new HashMap<String, Book>();
    }
    

    public void addBook(Book book) 
    {
        if (book != null && book.getIsbn() != null) 
        {
            books.put(book.getIsbn(), book);
            System.out.println("Book added: " + book.getTitle());
        }
    }
    

    @Override
    public boolean issueBook(String isbn, String studentName) 
    {

        if (isbn == null || studentName == null) 
        {
            return false;
        }
        

        Book book = books.get(isbn);
        if (book == null) 
        {
            return false; 

        }
        

        if (!book.isAvailable()) 
        {
            return false; 

        }
        

        book.setAvailable(false);
        book.setBorrowerName(studentName);
        return true;
    }
    

    @Override
    public boolean returnBook(String isbn, String studentName) 
    {

        if (isbn == null || studentName == null) 
        {
            return false;
        }
        

        Book book = books.get(isbn);
        if (book == null)
        {
            return false; 

        }
        

        if (book.isAvailable()) 
        {
            return false; 

        }
        
        if (!book.getBorrowerName().equals(studentName)) 
        {
            return false;

        }
        

        book.setAvailable(true);
        book.setBorrowerName("");
        return true;
    }
    

    @Override
    public boolean isAvailable(String isbn) 
    {
        if (isbn == null) 
        {
            return false;
        }
        
        Book book = books.get(isbn);
        if (book == null) 
        {
            return false; 

        }
        
        return book.isAvailable();
    }
    

    public ArrayList<Book> getAllBooks() 
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (Book book : books.values()) 
        {
            bookList.add(book);
        }
        return bookList;
    }
    

    public void showAllBooks() 
    {
        System.out.println(" All Books ");
        if (books.isEmpty()) 
        {
            System.out.println("No books in library");
            return;
        }
        
        int count = 1;
        for (Book book : books.values())
        {
            System.out.println(count + ". " + book);
            if (book.isAvailable()) 
            {
                System.out.println("   Status: Available");
            } 
            else 
            {
                System.out.println("   Status: Issued to " + book.getBorrowerName());
            }
            count++;
        }
    }
    

    public int getTotalBooks()
    {
        return books.size();
    }
}