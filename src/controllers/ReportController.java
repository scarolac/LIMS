package controllers;

import models.*;

public abstract class ReportController
{
    LibraryInformation libraryInformation;
    public ReportController(LibraryInformation libraryInformation)
    {
        this.libraryInformation = libraryInformation;
    }

    /**
     * Template method to make reports
     * @return the string to print
     */
    public final String  processReport()
    {
        loadData();
        formatData();
        return displayData();
    }

    abstract void loadData();
    abstract String formatData();

    public String displayData()
    {
        return formatData();
    }
}