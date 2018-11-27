package models;

public class Book extends Media
{
    private String author;
    private String isbn;
    private String publisher;

    public Book(String title, String location, String author, String isbn, String publisher)
    {
        super(title,location);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublisher(publisher);
    }

    public Book(String title, String location)
    {
        super(title,location);
        this.setAuthor("");
        this.setIsbn("");
        this.setPublisher("");
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) 
    {
        this.publisher = publisher;
    }

    /*******************************************
     * GETTERS
     *******************************************/

    /**
     * @return the author
     */
    public String getAuthor() 
    {
        return author;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() 
    {
        return isbn;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() 
    {
        return publisher;
    }
}