package views;

import controllers.*;
import models.*;
import jexer.*;

class LibrarianRemoveReader extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    ReaderController rc = new ReaderController(li);

    int row;
    int col;

    TField emailField = null;
    TField idField = null;

    public LibrarianRemoveReader(final TApplication application)
    {
        super(application, "Remove Reader");

        row = 3;
        col = 5;

        // reader email to search
        addLabel("Email:", col, row);
        emailField = addField(col + 7, row, 40, false, "");
        addButton("&Search", col + 48, row, searchReaderButton());
        row += 4;
        
        // reader id to remove
        addLabel("Remove Reader by ID number below", col, row);
        row += 2;
        addLabel("ID:", col, row);
        idField = addField(col + 4, row, 10, false, "");
        row += 2;

        // button to call reader controller to remove reader
        addButton("&Remove Reader",getWidth() / 2, getHeight() - 4, removeReaderButton());

        // cancel button, retrun to previous menu
        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianRemoveReader.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
    
    /**
     * Calls reader controller to find a readers ID based on name
     * @return an action event -> search reader button pressed
     */
    private TAction searchReaderButton()
    {
        return new TAction()
        {
            public void DO()
            {
                String email = emailField.getText();

                getApplication().messageBox("Search",
                    rc.findReader(email),
                    TMessageBox.Type.OK);
            }
        };
    }

    /**
     * Calls reader controller to remove a reader from the library system
     * @return an action event -> remove reader button pressed
     */
    private TAction removeReaderButton()
    {
        return new TAction()
            {
                public void DO()
                {
                    String id_num = idField.getText();
                    int id = (id_num.matches("-?\\d+(\\.\\d+)?")) ? Integer.parseInt(id_num) : -1;

                    getApplication().messageBox("Remove Reader",
                        rc.removeReader(id),
                        TMessageBox.Type.OK);
                }
            };
    }
}