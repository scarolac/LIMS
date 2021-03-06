package models;

import java.util.*;

public class Library
{
    private String name;
    private ArrayList<Media> inventory;

    public Library(String name)
    {
        this.setName(name);
        this.setInventory(new ArrayList<Media>());
    }

    /*******************************************
     * SETTERS
     *******************************************/
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param inventory the inventory to set
     */
    public void setInventory(ArrayList<Media> inventory) {
        this.inventory = inventory;
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
     * @return the inventory
     */
    public ArrayList<Media> getInventory() 
    {
        return inventory;
    }
    /*******************************************
     * MODIFIERS
     *******************************************/
    /**
     * 
     * @param media add media item into this libraries inventory list
     */
    public String addMedia(Media media)
    {
        this.inventory.add(media);
        return "Added " + 
            media.getClass().getSimpleName() + 
            " -> " +
            media.getTitle() + 
            " to library " + 
            this.getName();
    }

    public void removeMedia(Media media)
    {
        if (!media.isCheckedOut())
            this.inventory.remove(media);
    }

    public ArrayList<Media> searchMedia(String title, String type)
    {
        ArrayList<Media> searchList= new ArrayList<Media>();
        for (Media m : this.inventory)
            if (m.getTitle().equals(title) && m.getClass().getSimpleName().equals(type))
                searchList.add(m);
        return searchList;
    }
}