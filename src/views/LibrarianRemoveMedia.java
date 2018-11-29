package views;

import jexer.*;
import controllers.*;
import models.*;

import java.util.ArrayList;
import java.util.List;

class LibrarianRemoveMedia extends ViewTemplate
{   
    LibraryInformation li = LibraryInformation.getInstance();
    MediaController mc = new MediaController(li);

    int row;
    int col;

    TField titleField = null;

    TComboBox libraryBox = null;
    TComboBox mediaBox = null;

    public LibrarianRemoveMedia(final TApplication application)
    {
        super(application, "Remove Media");

        row = 3;
        col = 5;

        // title input area
        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;
        
        // library selection
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

        // button to remove items
        addButton("&Remove Media",getWidth() / 2, getHeight() - 4, removeMediaButton());

        // Cancel button, return to previous menu
        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianRemoveMedia.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
    /**
     * Calls media controller to remove an item from a library
     * @return an action event -> remove media button pressed
     */
    private TAction removeMediaButton()
    {
        return new TAction()
            {
                public void DO()
                {
                    String title = titleField.getText();
                    String library = libraryBox.getText();
                    String type = mediaBox.getText();
                    
                    // ensure non empty fields
                    if (title.equals(""))
                    {
                        getApplication().messageBox("Fields Missing",
                        "Need a title to search", TMessageBox.Type.OK);
                        return;
                    }
                    
                    getApplication().messageBox("Remove Media",
                    mc.removeMedia(library, type, title),
                    TMessageBox.Type.OK);
                }
            };
    }
}