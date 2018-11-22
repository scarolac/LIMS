package models;

import java.util.*;

// This is a singleton because I wanted to see how it worked
// not because it's a good idea.
public class LibraryInformation
{
    private static LibraryInformation LibraryInformation;
    private ArrayList<Library> libraries;
    private ArrayList<Librarian> librarians;
    private ArrayList<Reader> readers;

    private LibraryInformation()
    {
        this.setLibraries(new ArrayList<Library>());
        this.setLibrarians(new ArrayList<Librarian>());
        this.setReaders(new ArrayList<Reader>());
    }
    
    public static LibraryInformation grab()
    {
        if (LibraryInformation == null)
            LibraryInformation = new LibraryInformation();
        return LibraryInformation;
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param librarians the librarians to set
     */
    private void setLibrarians(ArrayList<Librarian> librarians) 
    {
        this.librarians = librarians;
    }

    /**
     * @param libraries the libraries to set
     */
    private void setLibraries(ArrayList<Library> libraries) 
    {
        this.libraries = libraries;
    }

    /**
     * @param readers the readers to set
     */
    private void setReaders(ArrayList<Reader> readers) 
    {
        this.readers = readers;
    }
    /*******************************************
     * GETTERS
     *******************************************/
    /**
     * @return the libraries
     */
    public ArrayList<Library> getLibraries() 
    {
        return libraries;
    }
    /**
     * @return the librarians
     */
    public ArrayList<Librarian> getLibrarians() 
    {
        return librarians;
    }
    /**
     * @return the readers
     */
    public ArrayList<Reader> getReaders() 
    {
        return readers;
    }
    /*******************************************
     * MODIFIERS
     *******************************************/
    /**
     * Adds a reader to list of readers for the entire library system
     * @param reader the reader to add
     */
    public void addReader(Reader reader)
    {
        readers.add(reader);
    }

    /**
     * Remove reader based on id, does nothing if not found
     * @param id the id of the reader to be removed
     */
    public void removeReader(int id)
    {
        readers.removeIf(reader -> (reader.getId() == id && reader.getCheckedOut() == null));
    }
}