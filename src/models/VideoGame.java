package models;

public class VideoGame extends Media
{
    private String console;
    private String developer;

    /**
     * Create Videogame
     * @param title of game
     * @param location - library kept at
     * @param console playable on
     * @param developer that created game
     */
    public VideoGame(String title, String location, String console, String developer)
    {
        super(title,location);
        this.setConsole(console);
        this.setDeveloper(developer);
    }

    /*******************************************
     * SETTERS
     *******************************************/
    /**
     * @param console the console to set
     */
    public void setConsole(String console) 
    {
        this.console = console;
    }
    /**
     * @param developer the developer to set
     */
    public void setDeveloper(String developer) 
    {
        this.developer = developer;
    }
    /*******************************************
     * GETTERS
     *******************************************/
    /**
     * @return the console
     */
    public String getConsole() 
    {
        return console;
    }
    /**
     * @return the developer
     */
    public String getDeveloper() 
    {
        return developer;
    }

    @Override
    public String toString() 
    {
        return getClass().getSimpleName() + ": " + getTitle() + 
        " [" + getConsole() + "] " + 
        ", library: " + getLocation();
    }
}