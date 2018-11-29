package views;

import jexer.*;

import models.*;
import controllers.*;

class ReaderCheckoutReport extends ViewTemplate
{

    LibraryInformation li = LibraryInformation.getInstance();

    private TText reportField = null;

    public ReaderCheckoutReport(final TApplication application)
    {
        super(application, "Personal Checkout Report");

        int row = 3;
        int col = 5;

        Reader r = li.findReader(1);
        String media = "";
        if (r.getCheckedOut().size() == 0) media += "Nothing checked out";
        for (Media m : r.getCheckedOut())
            media += m.toString() + "\n";
        reportField = addText(media, col, row, 57, 13);

        addButton("&Return", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderCheckoutReport.this);
                    new ReaderMainMenu(getApplication());
                }
            } );
    }
}