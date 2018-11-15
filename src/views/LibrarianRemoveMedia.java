package views;

import jexer.*;

import java.util.ArrayList;
import java.util.List;

class LibrarianRemoveMedia extends ViewTemplate
{

    TField titleField = null;
    TComboBox libraryBox = null;

    public LibrarianRemoveMedia(final TApplication application)
    {
        super(application, "Remove Media");

        int row = 3;
        int col = 5;

        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;
        
        addLabel("Select Library:", col, row);
        // TODO: Controller should add this probably from LibraryInformation class
        List<String> libraries = new ArrayList<String>();
        libraries.add("Business");
        libraries.add("Engineering");
        libraries.add("Law");
        libraries.add("Music");
        libraries.add("Norlin");
        libraryBox = addComboBox(col + 16, row, 12, libraries, 0, 3, null);

        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    getApplication().messageBox("Testing",
                    "Library: " + libraryBox.getText() + 
                    "\n" + 
                    "Title: " + titleField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );

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
}