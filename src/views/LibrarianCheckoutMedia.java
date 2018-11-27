package views;

import jexer.*;
import java.util.ArrayList;
import java.util.List;

class LibrarianCheckoutMedia extends ViewTemplate
{
    int row;
    int col;
    
    TComboBox libraryBox = null;
    TComboBox mediaBox = null;

    TField titleField = null;
    TField idField = null;

    public LibrarianCheckoutMedia(final TApplication application)
    {
        super(application, "Checkout Media for reader");

        row = 3;
        col = 5;

        // Library selection
        addLabel("Select Library:", col, row);

        // TODO: Controller should add this probably from LibraryInformation class
        //foreach loop through libraryinformation list
        List<String> libraries = new ArrayList<String>();
        libraries.add("Business");
        libraries.add("Engineering");
        libraries.add("Law");
        libraries.add("Music");
        libraries.add("Norlin");

        libraryBox = addComboBox(col + 16, row, 12, libraries, 0, 3, null);

        // Type selection on same row but to the right
        // TODO: fix better
        addLabel("Select Type:", getWidth() / 2, row);
        List<String> types = new ArrayList<String>();
        types.add("Book");
        types.add("DVD");
        types.add("CD");
        types.add("VideoGame");
        mediaBox = addComboBox((getWidth() / 2) + 13, row, 12, types, 0, 5, null);     
        row += 4;

        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;

        addLabel("Reader ID:", col, row);
        idField = addField(col + 11, row, 3, false, "");
        row += 2;

        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    String type = mediaBox.getText();
                    String library = libraryBox.getText();
                    String title = titleField.getText();
                    String id = idField.getText();

                    
                    getApplication().messageBox("Testing",
                    "Type: " + type 
                    + "\n" + 
                    "Library: " + library 
                    + "\n" + 
                    "Title: " + title
                    + "\n" +
                    "ID: " + id,
                    TMessageBox.Type.OK);
                }
            }
        );

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianCheckoutMedia.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
}
