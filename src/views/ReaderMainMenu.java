package views;

import jexer.*;
        
class ReaderMainMenu extends ViewTemplate
{
    public ReaderMainMenu(final TApplication application)
    {
        super(application, "Reader Main Menu");

        int row = 3;
        
        addButton("&1 Checkout Media", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderMainMenu.this);
                    new ReaderSelfCheckout(getApplication());
                }
            } );
        row += 2;

        addButton("&2 Check overdue Fees", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderMainMenu.this);
                    new ReaderCheckoutReport(getApplication());
                }
            } );
        row += 2;
        addButton("&3 View Checked out media", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderMainMenu.this);
                    new ReaderFeeReport(getApplication());
                }
            } );
        row += 2;
        addButton("&4 Search item", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderMainMenu.this);
                    new ReaderSearchMedia(getApplication());
                }
            } );

        addButton("&Logout", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderMainMenu.this);
                    new LoginScreen(getApplication());
                }
            } );

    }
}