package views;

import jexer.*;
import java.util.ArrayList;

import controllers.*;
import models.*;

class LibrarianCheckoutMedia extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    MediaController mc = new MediaController(li);

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
        ArrayList<String> libraries = mc.getLibraryNames();
        libraryBox = addComboBox(col + 16, row, 12, libraries, 0, 3, null);
        
        // Type selection on same row but to the right
        addLabel("Select Type:", getWidth() / 2, row);
        ArrayList<String> types = new ArrayList<String>();
        types.add("Book");
        types.add("DVD");
        types.add("CD");
        types.add("VideoGame");
        mediaBox = addComboBox((getWidth() / 2) + 13, row, 12, types, 0, 5, null);     
        row += 4;

        // Title input area
        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;

        // Reader Id input area
        addLabel("Reader ID:", col, row);
        idField = addField(col + 11, row, 3, false, "");
        row += 2;

        // button to call controller to checkout media
        addButton("&Checkout Media",getWidth() / 2, getHeight() - 4, checkoutMediaButton());

        // return to previous menu
        addButton("&Return", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianCheckoutMedia.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }

    /**
     * call media controller to checkout item between media object and reader
     * @return an action event -> checkout media button pressed
     */
    private TAction checkoutMediaButton()
    {
       return new TAction()
            {
                public void DO()
                {
                    String type = mediaBox.getText();
                    String library = libraryBox.getText();
                    String title = titleField.getText();
                    String id_num = idField.getText();
                    int id = (id_num.matches("-?\\d+(\\.\\d+)?")) ? Integer.parseInt(id_num) : -1;

                    // ensure non empty fields
                    if (title.equals("") ||
                        id < 1)
                    {
                        getApplication().messageBox("Fields Missing",
                        "Fill out all fields", TMessageBox.Type.OK);
                        return;
                    }
                    
                    getApplication().messageBox("Testing",
                        mc.checkoutMedia(type, library, title, id),
                        TMessageBox.Type.OK);
                }
            };
    }
}
