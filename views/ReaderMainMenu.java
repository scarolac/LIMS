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
                    // getApplication().closeWindow(ReaderMainMenu.this);
                    ReaderMainMenu.this.messageBox("Box Title", "1");
                }
            } );
        row += 2;

        addButton("&2 Check overdue Fees", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    // getApplication().closeWindow(ReaderMainMenu.this);
                    ReaderMainMenu.this.messageBox("Box Title", "2");
                }
            } );
        row += 2;
        addButton("&3 View Checked out media", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    // getApplication().closeWindow(ReaderMainMenu.this);
                    ReaderMainMenu.this.messageBox("Box Title", "3");
                }
            } );
        row += 2;
        addButton("&4 Search/Waitlist item", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    // getApplication().closeWindow(ReaderMainMenu.this);
                    ReaderMainMenu.this.messageBox("Box Title", "4");
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