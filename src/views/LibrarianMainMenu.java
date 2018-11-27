package views;

import jexer.*;
        
class LibrarianMainMenu extends ViewTemplate
{
    public LibrarianMainMenu(final TApplication application)
    {
        super(application, "Librarian Main Menu");

        int row = 3;
        
        addButton("&1 Add Media", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianAddMedia(getApplication());
                }
            } );
        row += 2;

        addButton("&2 Remove Media", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianRemoveMedia(getApplication());
                }
            } );
        row += 2;
        addButton("&3 Add Reader", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianAddReader(getApplication());
                }
            } );
        row += 2;
        addButton("&4 Remove Reader", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianRemoveReader(getApplication());
                }
            } );
        row += 2;
        addButton("&5 Generate Checkout Report", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianCheckoutReport(getApplication());
                }
            } );
        row += 2;
        addButton("&6 Generate Fees Report", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianFeeReport(getApplication());
                }
            } );
        row += 2;
        addButton("&7 Checkout Media for Reader", 5, row, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LibrarianCheckoutMedia(getApplication());
                }
            } );
        row += 2;

        addButton("&Logout", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianMainMenu.this);
                    new LoginScreen(getApplication());
                }
            } );

    }
}