package librarymanager ;
public class Book 
{
    protected String title;
    protected String author; 
    protected String isbn;
    protected boolean available;
    protected String borrowerName;
    
    public Book(String title, String author, String isbn) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.borrowerName = "";
    }
    
    public String getTitle() 
    {
        return title;
    }
    
    public String getAuthor() 
    {
        return author;
    }
    
    public String getIsbn() 
    {
        return isbn;
    }
    
    public boolean isAvailable() 
    {
        return available;
    }
    
    public String getBorrowerName() 
    {
        return borrowerName;
    }
    
    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
    
    public void setBorrowerName(String borrowerName) 
    {
        this.borrowerName = borrowerName;
    }
    
    public String toString() 
    {
        return "Book: " + title + " by " + author + " (ISBN:" + isbn + ")";
    }
}