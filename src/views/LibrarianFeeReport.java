package views;

import controllers.*;
import models.*;
import jexer.*;

class LibrarianFeeReport extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    ReportController rc = new FeeReport(li);

    private TText reportField = null;

    public LibrarianFeeReport(final TApplication application)
    {
        super(application, "Fee Report");

        int row = 3;
        int col = 5;

        reportField = addText(rc.processReport(), col, row, 57, 13);


        // return to previous menu
        addButton("&Return", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianFeeReport.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
}