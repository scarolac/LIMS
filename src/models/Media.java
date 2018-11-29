package models;

import java.util.*;

abstract public class Media
{
    private String title;
    private String location;
    private boolean isCheckedOut;
    private Reader assignedTo;


    public Media(String title, String location)
    {
        this.setTitle(title);
        this.setLocation(location);
        this.setCheckedOut(false);
        this.setAssignedTo(null);
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param title the title to set
     */
    public void setTitle(String title) 
    {
        this.title = title;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) 
    {
        this.location = location;
    }
    /**
     * @param isCheckedOut the isCheckedOut to set
     */
    public void setCheckedOut(boolean isCheckedOut) 
    {
        this.isCheckedOut = isCheckedOut;
    }

    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(Reader assignedTo) 
    {
        this.assignedTo = assignedTo;
    }


    /*******************************************
     * GETTERS
     *******************************************/

    /**
     * @return the title
     */
    public String getTitle() 
    {
        return title;
    }

    /**
     * @return the location
     */
    public String getLocation() 
    {
        return location;
    }

    /**
     * @return the isCheckedOut
     */
    public boolean isCheckedOut() 
    {
        return isCheckedOut;
    }

    /**
     * @return the assignedTo
     */
    public Reader getAssignedTo() 
    {
        return assignedTo;
    }


    /*******************************************
     * MODIFIERS
     *******************************************/
    public String checkOut(Reader reader)
    {
        if (!this.isCheckedOut())
        {
            this.setAssignedTo(reader);
            this.setCheckedOut(true);
            return this.getTitle() + 
                " checked out by " + 
                reader.getName();
        }
        else
            return this.getClass().getSimpleName() + 
            " - item already checked out:" + 
            this.isCheckedOut();
    }

    public String returnItem()
    {
        if (this.isCheckedOut())
        {
            this.setAssignedTo(null);
            this.setCheckedOut(false);
            return this.getTitle() + " returned";
        }
        else
            return this.getClass().getSimpleName() + 
            " - item not checked out";
        
    }

    public abstract String toString();
}