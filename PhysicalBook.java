package librarymanager;
public class PhysicalBook extends Book
{
    private String shelfLocation;
    
    public PhysicalBook(String title, String author, String isbn, String shelfLocation) 
    {
        super(title, author, isbn);

        this.shelfLocation = shelfLocation;
    }
    
    public String getShelfLocation() 
    {
        return shelfLocation;
    }
    
    public void setShelfLocation(String shelfLocation)
    {
        this.shelfLocation = shelfLocation;
    }
    
    @Override
    public String toString()
    {
        return "Physical " + super.toString() + " at " + shelfLocation;
    }
}