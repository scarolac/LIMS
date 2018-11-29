package views;

import jexer.*;
import models.*;
import controllers.*;

class LibrarianAddReader extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    ReaderController rc = new ReaderController(li);

    int row;
    int col;

    TField nameField = null;
    TField emailField = null;

    public LibrarianAddReader(final TApplication application)
    {
        super(application, "Add Reader");

        row = 3;
        col = 5;

        // reader name input area
        addLabel("Name:", col, row);
        nameField = addField(col + 6, row, 20, false, "");
        row += 2;

        // reader email input area
        addLabel("Email:", col, row);
        emailField = addField(col + 7, row, 20, false, "");
        
        // button to call reader controller to 
        addButton("&Add Reader",getWidth() / 2, getHeight() - 4, addReaderButton());

        // cancel button, return to previous menu
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

    private TAction addReaderButton()
    {
        return new TAction()
            {
                public void DO()
                {
                    String name = nameField.getText();
                    String email = emailField.getText();

                    // ensure non empty fields
                    if (name.equals("") ||
                    email.equals(""))
                    {
                        getApplication().messageBox("Fields Missing",
                        "Fill out all fields", TMessageBox.Type.OK);
                        return;
                    }

                    getApplication().messageBox("Add Reader",
                        rc.addReader(name, email),
                        TMessageBox.Type.OK);
                }
            };
    }
}

