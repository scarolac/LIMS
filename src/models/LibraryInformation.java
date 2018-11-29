package models;

import java.util.*;

/**
 * Singleton, because it is easier than passing it through to each view
 */
public class LibraryInformation
{
    private static LibraryInformation li;
    private ArrayList<Library> libraries;
    private ArrayList<Librarian> librarians;
    private ArrayList<Reader> readers;

    private LibraryInformation()
    {
        this.setLibraries(new ArrayList<Library>());
        this.setLibrarians(new ArrayList<Librarian>());
        this.setReaders(new ArrayList<Reader>());
    }

    public static LibraryInformation getInstance()
    {
        if(li == null)
            li = new LibraryInformation();
        return li;
    }

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * Creates list of librarians to store "admins" or librarians
     * @param librarians the librarians to set
     */
    private void setLibrarians(ArrayList<Librarian> librarians) 
    {
        this.librarians = librarians;
    }

    /**
     * Creates libraries list to store the libraries
     * @param libraries the libraries to set
     */
    private void setLibraries(ArrayList<Library> libraries) 
    {
        this.libraries = libraries;
    }

    /**
     * Creates readers list to store readers into
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
    public boolean removeReader(int id)
    {
        return readers.removeIf(reader -> (reader.getId() == id && reader.getCheckedOut().size() == 0));
    }

    public Reader findReader(int id)
    {
        for (Reader r : this.readers)
            if (r.getId() == id)
                 return r;
        return null; 
    }
    
    public ArrayList<Reader> findReader(String email)
    {
        ArrayList<Reader> searchList= new ArrayList<Reader>();
        for (Reader r : this.readers)
            if (r.getEmail().equals(email))
                searchList.add(r);
        return searchList; 
    }

    public void addMedia(Media media, String name)
    {
        for (Library l : libraries)
            if (l.getName().equals(name))
                l.addMedia(media);
    }

    /* 
        These functions are not used by the App, only used to build the class
    */
    /**
     * Add library to track
     * @param library
     */
    public void addLibrary(Library library)
    {
        libraries.add(library);
    }
    /**
     * Add librarians to system
     * @param librarian
     */
    public void addLibrarian(Librarian librarian)
    {
        librarians.add(librarian);
    }
}