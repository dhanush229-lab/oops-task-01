package librarymanager;


public interface Issueable
{
    boolean issueBook(String isbn, String studentName);
    boolean returnBook(String isbn, String studentName);  
    boolean isAvailable(String isbn);
}