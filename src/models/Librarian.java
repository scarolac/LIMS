package models;

public class Librarian
{
    private String name;
    private int id;


    public Librarian(String name, int id)
    {
        this.setName(name);
        this.setId(id);
    }
    public Librarian()
    {
        this("INVALID", 0);
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) 
    {
        this.id = id;
    }


    /*******************************************
     * GETTERS
     *******************************************/

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

}