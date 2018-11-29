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

    /**
     * Create Reader instance, these are the ones who check out books, people
     * @param name of person
     * @param email or person to contact
     */
    public Reader(String name, String email)
    {
        this.setName(name);
        this.setEmail(email);
        this.setId(); 
        this.setCheckedOut(new ArrayList<Media>());
        this.setFees(0.0);
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param name the name to set
     */
    private void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @param checkedOut the checkedOut to set
     */
    private void setCheckedOut(ArrayList<Media> checkedOut) 
    {
        this.checkedOut = checkedOut;
    }

    /**
     * @param fees the fees to set
     */
    public void setFees(double fees) 
    {
        this.fees = fees;
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
     * @return the readers name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the list of checked out media objects
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

    @Override
    public String toString() 
    {
        return "ID: " + getId() + " - " + getName() + ": " + getEmail();
    }
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

    /**
     * Resets the checkout list, "returns" the items, called after the items are actually put back
     */
    public void returnItems()
    {
        this.checkedOut = new ArrayList<Media>();
    }
}