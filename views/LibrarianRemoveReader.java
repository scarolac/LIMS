package views;

import jexer.*;

class LibrarianRemoveReader extends ViewTemplate
{
    TField nameField = null;
    TField idField = null;

    public LibrarianRemoveReader(final TApplication application)
    {
        super(application, "Remove Reader");

        int row = 3;
        int col = 5;

        addLabel("Name:", col, row);
        nameField = addField(col + 6, row, 40, false, "");
        addButton("&Search", col + 47, row,
            new TAction()
            {
                public void DO()
                {
                    getApplication().messageBox("Search",
                    "name:" + 
                    nameField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );
        row += 2;
        row += 2;
        
        addLabel("Remove Reader by ID number below", col, row);
        row += 2;

        addLabel("ID:", col, row);
        idField = addField(col + 4, row, 10, false, "");
        row += 2;

        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    getApplication().messageBox("Testing",
                    "ID: " + idField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );

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
}