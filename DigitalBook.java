package librarymanager;
public class DigitalBook extends Book
{
    private String downloadUrl;
    
    public DigitalBook(String title, String author, String isbn, String downloadUrl)
    {
        super(title, author, isbn); 

        this.downloadUrl = downloadUrl;
    }
    

    public String getDownloadUrl()
    {
        return downloadUrl;
    }
    

    public void setDownloadUrl(String downloadUrl) 
    {
        this.downloadUrl = downloadUrl;
    }
    

    @Override 
    public String toString()
    {
        return "Digital " + super.toString() + " URL: " + downloadUrl;
    }
}