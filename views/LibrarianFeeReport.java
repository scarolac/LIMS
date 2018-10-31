package views;

import jexer.*;

class LibrarianFeeReport extends ViewTemplate
{
    private TText reportField = null;

    public LibrarianFeeReport(final TApplication application)
    {
        super(application, "Fee Report");

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
                    getApplication().closeWindow(LibrarianFeeReport.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }

    public String testString()
    {
        String temp;
        temp = "Reader\tFees\n";
        temp += "-------------------------------------------------------\n";
        temp += "Jim\t$17284.54\n";
        return temp;
    }
}