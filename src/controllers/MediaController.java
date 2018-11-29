package controllers;

import models.*;
import views.*;

import jexer.*;

import java.util.ArrayList;

public class MediaController
{
    private LibraryInformation libraryInformation;
    
    public MediaController(LibraryInformation libraryInformation)
    {
        this.libraryInformation = libraryInformation;
    }

    /**
     * Adds a media item with given attributes from input
     * @param type the type of item, eg. Book, or DVD
     * @param amount the amount to add
     * @param attributes the attributes for the item from view
     * @return a message about the number added to which library
     */
    public String addMedia(String type, int amount, ArrayList<String> attributes)
    {
        for (int i = 0; i < amount; ++i)
            libraryInformation.addMedia(
                    MediaFactory.getNewMedia(type, attributes.toArray(new String[0])), 
                    attributes.get(1)  // name of library always second item
                    );
        return "Added " + amount + " " + type + "(s)" + " - " + "title: " +
            attributes.get(0) + "\nto " + attributes.get(1) + " Library";
    }

    /**
     * Gets list of current names of all libraries
     * @return names of libraries in list
     */
    public ArrayList<String> getLibraryNames()
    {
        ArrayList<String> names = new ArrayList<String>();
        for (Library library : libraryInformation.getLibraries())
            names.add(library.getName());
        return names;
    }

    /**
     * Remove selected media
     * @param library from this location
     * @param type of item to remove
     * @param title of item
     * @return status message
     */
    public String removeMedia(String library, String type, String title)
    {
        ArrayList<Media> searchList;
        for (Library l : libraryInformation.getLibraries())
            if (l.getName().equals(library))
            {
                searchList = l.searchMedia(title, type);
                for (Media m : searchList)
                    if (!m.isCheckedOut())
                        {
                            l.removeMedia(m);
                            return "Removed " + title + " from " + library + " Library";
                        }
                return "Item not found (possibly checked out)";
            }
        return "Library not found"; 
    }

    /**
     * Checkout item for some reader
     * @param type of item
     * @param library item located in
     * @param title of item
     * @param id of reader
     * @return status of checking out
     */
    public String checkoutMedia(String type, String library, String title, int id)
    {
        // searchmedia
        ArrayList<Media> searchList;
        for (Library l : libraryInformation.getLibraries())
            if (l.getName().equals(library))
            {
                searchList = l.searchMedia(title, type);
                for (Media m : searchList)
                    if (!m.isCheckedOut())
                        {
                            Reader r = libraryInformation.findReader(id);
                            if (r == null) return "ID invalid";
                            r.checkOutMedia(m);
                            m.checkOut(r);
                            return "Checked out " + title + " from " + library + " Library\nto" + r;
                        }
                return "Item not found (possibly checked out)";
            }
        return "Library not found"; 
    }

    /**
     * Return all the media of a user
     * @return status message
     */
    public String returnMedia()
    {
        Reader r = libraryInformation.findReader(1);
        ArrayList<Media> items = r.getCheckedOut();
        if (items.size() == 0) return "Nothing to return";
        for(Media m : items)
            m.returnItem();
        r.returnItems();
        return "Items returned";
    }

    /**
     * For testing, checks data in library after adding
     * @param name of library to search
     */
    public void printMedia(String name)
    {
        ArrayList<Library> lists = libraryInformation.getLibraries();
        for (Library l : lists)
            if(l.getName().equals(name))
                System.out.println(l.getInventory());
    }   
}