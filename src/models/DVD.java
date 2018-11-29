package models;

public class DVD extends Media
{
    private int year;
    private String genre;

    /**
     * Create DVD instance
     * @param title of DVD
     * @param location - which library it is kept
     * @param year of release
     * @param genre of DVD
     */
    public DVD(String title, String location, String year, String genre)
    {
        super(title,location);
        this.setYear(Integer.parseInt(year));
        this.setGenre(genre);
    }

    /*******************************************
     * SETTERS
     *******************************************/
    /**
     * @param year the year to set
     */
    public void setYear(int year) 
    {
        this.year = year;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) 
    {
        this.genre = genre;
    }
    /*******************************************
     * GETTERS
     *******************************************/
    /**
     * @return the year
     */
    public int getYear() 
    {
        return year;
    }
    /**
     * @return the genre
     */
    public String getGenre() 
    {
        return genre;
    }

    @Override
    public String toString() 
    {
        return getClass().getSimpleName() + ": " + getTitle() + 
        " released: " + getYear() + 
        ", library: " + getLocation();
    }
}