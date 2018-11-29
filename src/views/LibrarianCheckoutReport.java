package views;

import controllers.*;
import models.*;
import jexer.*;

class LibrarianCheckoutReport extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    ReportController rc = new CheckoutReport(li);

    private TText reportField = null;

    public LibrarianCheckoutReport(final TApplication application)
    {
        super(application, "Checkout Report");

        int row = 3;
        int col = 5;

        reportField = addText(rc.processReport(), col, row, 57, 13);

        addButton("&Return", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianCheckoutReport.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
}