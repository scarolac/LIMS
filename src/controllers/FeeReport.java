package controllers;

import models.*;
import java.util.ArrayList;

public class FeeReport extends ReportController
{
    ArrayList<Reader> readers;

    /**
     * Create fee instance
     * @param libraryInformation holds data on the library system
     */
    public FeeReport(LibraryInformation libraryInformation)
    {
        super(libraryInformation);
        this.readers = new ArrayList<Reader>();
    }

    /**
     * Load data into readers list to show later
     */
    public void loadData()
    {      
        for (Reader r : libraryInformation.getReaders())
            if (r.getFees() > 0.0)
                readers.add(r);

    }

    /**
     * Arrange data to view fees with correct format
     * @return the fees Spring
     */
    public String formatData()
    {
        String fees = "Reader -------------------------------------------- Fees\n";

        if(readers.size() == 0)
            fees += "No outstanding fees by any reader";
        else
        {
            for (Reader r : readers)
                fees += r.toString() + " ---- " + String.format("$%,.2f", r.getFees());
        }
        return fees;
    }
}