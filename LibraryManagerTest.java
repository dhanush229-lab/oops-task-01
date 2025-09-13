package librarymanager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LibraryManagerTest 
{
    
    private LibraryManager library;
    private Book book1;
    private PhysicalBook book2;  
    private DigitalBook book3;
    
 
    @BeforeEach
    public void setup() 
    {
        library = new LibraryManager();
        book1 = new Book("Java Programming", "John Doe", "123");
        book2 = new PhysicalBook("C++ Basics", "Jane Smith", "456", "Shelf A");
        book3 = new DigitalBook("Python Guide", "Bob Johnson", "789", "http://example.com");
        

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }
    
    @Test
    public void testIssueBookSuccess() 
    {
        boolean result = library.issueBook("123", "Alice");
        assertTrue(result);
        assertFalse(book1.isAvailable());
        assertEquals("Alice", book1.getBorrowerName());
    }
    
    @Test  
    public void testIssueBookNotFound() 
    {
        boolean result = library.issueBook("999", "Alice");
        assertFalse(result);
    }
    
    @Test
    public void testIssueBookAlreadyIssued() 
    {
        library.issueBook("123", "Alice");
        boolean result = library.issueBook("123", "Bob");
        assertFalse(result);
    }
    
    @Test
    public void testReturnBookSuccess() 
    {
        library.issueBook("123", "Alice");
        boolean result = library.returnBook("123", "Alice");
        assertTrue(result);
        assertTrue(book1.isAvailable());
        assertEquals("", book1.getBorrowerName());
    }
    
    @Test
    public void testReturnBookNotIssued() 
    {
        boolean result = library.returnBook("123", "Alice");
        assertFalse(result);
    }
    
    @Test
    public void testReturnBookWrongStudent() 
    {
        library.issueBook("123", "Alice");
        boolean result = library.returnBook("123", "Bob");
        assertFalse(result);
    }
    
    @Test
    public void testIsAvailableTrue() 
    {
        boolean result = library.isAvailable("123");
        assertTrue(result);
    }
    
    @Test
    public void testIsAvailableFalse() 
    {
        library.issueBook("123", "Alice");
        boolean result = library.isAvailable("123");
        assertFalse(result);
    }
    
    @Test
    public void testIsAvailableBookNotFound() 
    {
        boolean result = library.isAvailable("999");
        assertFalse(result);
    }
    
    @Test
    public void testPhysicalBookInheritance() 
    {
        assertTrue(book2 instanceof Book);
        assertTrue(book2 instanceof PhysicalBook);
        assertEquals("Shelf A", book2.getShelfLocation());
    }
    
    @Test
    public void testDigitalBookInheritance() 
    {
        assertTrue(book3 instanceof Book);
        assertTrue(book3 instanceof DigitalBook);
        assertEquals("http://example.com", book3.getDownloadUrl());
    }
    
    @Test
    public void testCompleteWorkflow() 
    {
        assertTrue(library.isAvailable("456"));
        
        assertTrue(library.issueBook("456", "Student1"));
        assertFalse(library.isAvailable("456"));
        
        assertTrue(library.returnBook("456", "Student1"));
        assertTrue(library.isAvailable("456"));
    }
}