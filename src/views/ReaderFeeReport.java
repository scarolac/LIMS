package views;

import jexer.*;

import models.*;
import controllers.*;

class ReaderFeeReport extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();

    private TText reportField = null;

    public ReaderFeeReport(final TApplication application)
    {
        super(application, "Personal Fee Report");

        int row = 3;
        int col = 5;

        Reader r = li.findReader(1);
        reportField = addText(r.toString() + " --> " + r.getFees(), col, row, 57, 13);

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderFeeReport.this);
                    new ReaderMainMenu(getApplication());
                }
            } );
    }
}