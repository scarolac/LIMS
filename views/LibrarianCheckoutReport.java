package views;

import jexer.*;

class LibrarianCheckoutReport extends ViewTemplate
{
    private TText reportField = null;

    public LibrarianCheckoutReport(final TApplication application)
    {
        super(application, "Checkout Report");

        int row = 3;
        int col = 5;

        reportField = addText("This should load automatically", col, row, 57, 13);

        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    reportField = addText(testString(), col, row, 57, 13);
                }
            }
        );

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianCheckoutReport.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }

    public String testString()
    {
        String temp;
        temp = "Library\tTitle (type)\tReader\tDue Date\n";
        temp += "-------------------------------------------------------\n";
        temp += "Norlin\tBook About Birds\tJim\t11/12/2018\n";
        return temp;
    }
}