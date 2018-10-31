package views;

import jexer.*;

class LibrarianAddReader extends ViewTemplate
{
    TField nameField = null;
    TField emailField = null;

    public LibrarianAddReader(final TApplication application)
    {
        super(application, "Add Reader");

        int row = 3;
        int col = 5;

        addLabel("Name:", col, row);
        nameField = addField(col + 6, row, 20, false, "");
        row += 2;

        addLabel("Email:", col, row);
        emailField = addField(col + 7, row, 20, false, "");
        
        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    getApplication().messageBox("Testing",
                    "name: " + nameField.getText() + 
                    "\n" + 
                    "email: " + emailField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianAddReader.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
}

