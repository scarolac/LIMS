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
    public String addReader(String name, String email)
    {
        Reader reader = new Reader(name,email);
        libraryInformation.addReader(reader);
        return "Added reader: " + reader + "\nto the library system";
    }
    /**
     * Removes reader based on id
     * @param id
     */
    public String removeReader(int id)
    {
        if(libraryInformation.removeReader(id))
            return "Reader with ID: " + id + " has been removed";
        return "Reader not found";
    }

    /**
     * Returns String formatted list of readers found
     * @param email of reader that an ID is needed
     * @return list of names, emails,  and IDs
     */
    public String findReader(String email)
    {
        String emailList = "";
        for (Reader r : libraryInformation.findReader(email))
            emailList += r.toString() + "\n";

        return (emailList.length() > 0) ? emailList : "Not Found";
    }
}