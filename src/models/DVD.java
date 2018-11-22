package models;

public class DVD extends Media
{
    private int year;
    private String genre;

    public DVD(String title, String location, int year, String genre)
    {
        super(title,location);
        this.setYear(year);
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
}