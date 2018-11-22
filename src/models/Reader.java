package models;

import java.util.*;

public class Reader
{
    private String name;
    private int id;
    private static int GLOBAL_ID = 1;
    private ArrayList <Media> checkedOut;
    private String email;
    private double fees;

    public Reader(String name, String email)
    {
        this.setName(name);
        this.setEmail(email);
        this.setId(); // TODO: No destructor, put in info class?
        this.setCheckedOut();
        this.setFees();
    }
    
    public Reader()
    {
        // should never be called
        this("INVALID","CHECK@CODE.please");
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
     * @param checkedOut initialize the arraylist of Media
     */
    public void setCheckedOut() 
    {
        this.checkedOut = new ArrayList<Media>();
    }

    /**
     * @param fees initialize fees to 0 on new reader
     */
    public void setFees() 
    {
        this.fees = 0.0;
    }

    /**
     * @param id Assign new ID
     */
    public void setId() 
    {
        this.id = GLOBAL_ID++;
    }
    
    /**
     * @param email the email to set
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }

    /*******************************************
     * GETTERS
     *******************************************/


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the checkedOut media
     */
    public ArrayList<Media> getCheckedOut() {
        return checkedOut;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the fees
     */
    public double getFees() {
        return fees;
    }

    /**
     * @return the gLOBAL_ID
     */
    public static int getGLOBAL_ID() {
        return GLOBAL_ID;
    }

    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

    /*******************************************
     * MODIFIERS
     *******************************************/

    /**
     * @param fee The amount to add to existing fees
    */
    public void addFees(double fee)
    {
        this.fees += fee;
    }

    /**
     * 
     * @param media The media to add to the list of checked out items
     */
    public void checkOutMedia(Media media)
    {
        if(!media.isCheckedOut())
        {    
            this.checkedOut.add(media);
        }
        else
            System.out.println(this.getClass().getSimpleName() + " - item not available");
    }
}