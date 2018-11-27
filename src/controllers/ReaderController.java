package controllers;

import models.*;


public class ReaderController
{
    private LibraryInformation libraryInformation;
    
    public ReaderController(LibraryInformation libraryInformation)
    {
        this.libraryInformation = libraryInformation;
    }
    /**
     * Adds a new reader to the library system
     * @param name
     * @param email
     */
    public void addReader(String name, String email)
    {
        libraryInformation.addReader(new Reader(name,email));
    }
    /**
     * Removes reader based on id
     * @param id
     */
    public void removeReader(int id)
    {
        libraryInformation.removeReader(id);
    }

    /**
     * Returns String formatted list of names and IDs
     * @param name  of reader that an ID is needed
     * @return list of names and IDs
     */
    public String findReader(String name)
    {
        String namesList = "";
        for (Reader r : libraryInformation.findReader(name))
            namesList += "Name: " + r.getName() + " - ID: " + r.getId() + "\n";

        return namesList;
    }
}