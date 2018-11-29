package controllers;

import models.*;
import java.util.ArrayList;

public class CheckoutReport extends ReportController
{
    ArrayList<Media> media;

    /**
     * Create Checkout report instance to hold media items to display
     * @param libraryInformation holds all data in library system
     */
    public CheckoutReport(LibraryInformation libraryInformation)
    {
        super(libraryInformation);
        this.media = new ArrayList<Media>();
    }

    /**
     * Loads the data from the library information area
     */
    public void loadData()
    {      
        for (Library library : libraryInformation.getLibraries())
            for (Media m : library.getInventory())
                if(m.isCheckedOut())
                    media.add(m);

    }

    /**
     * format data into string for outputting 
     * @return string of checked out items
     */
    public String formatData()
    {
        String report = "Item -----------------------------------------> Reader\n";

        if(media.size() == 0)
            report += "Nothing checked out by any reader";
        else
        {
            for (Media m : media)
                report += m.toString() + " --> " + m.getAssignedTo().getName();
        }
        return report;
    }
}