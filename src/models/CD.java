package models;

public class CD extends Media
{
    private String artist;
    private int year;
    private String genre;

    public CD(String title, String location, String artist, int year, String genre)
    {
        super(title,location);
        this.setArtist(artist);
        this.setYear(year);
        this.setGenre(genre);
    }

    /*******************************************
     * SETTERS
     *******************************************/
    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) 
    {
        this.artist = artist;
    }

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
     * @return the artist
     */
    public String getArtist() 
    {
        return artist;
    }
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