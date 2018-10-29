package views;

import jexer.*;

import java.util.ArrayList;
import java.util.List;

class LibrarianAddMedia extends ViewTemplate
{
    TComboBox libraryBox = null;

    TRadioGroup mediaTypes = null;

    TField titleField = null;
    TField quantityField = null;

    MediaRadioButton bookRadio = null;
    MediaRadioButton dvdRadio = null;
    MediaRadioButton cdRadio = null;
    MediaRadioButton videoGameRadio = null;

    public LibrarianAddMedia(final TApplication application)
    {
        super(application, "Add Media");

        int row = 3;
        int col = 5;

        // Library selection
        addLabel("Select Library:", col, row);

        // TODO: Controller should add this probably from LibraryInformation class
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
        mediaTypes = addRadioGroup((getWidth() / 2) + 12, row - 1, "Media");
        bookRadio = new MediaRadioButton(mediaTypes,1,mediaTypes.getChildren().size() + 1,
                "Book",mediaTypes.getChildren().size()+1);
        dvdRadio = new MediaRadioButton(mediaTypes,1,mediaTypes.getChildren().size() + 1,
                "DVD",mediaTypes.getChildren().size()+1);
        cdRadio = new MediaRadioButton(mediaTypes,1,mediaTypes.getChildren().size() + 1,
                "CD",mediaTypes.getChildren().size()+1);
        videoGameRadio = new MediaRadioButton(mediaTypes,1,mediaTypes.getChildren().size() + 1,
                "Video Game",mediaTypes.getChildren().size()+1);
        
        row += 4;

        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;

        addLabel("Quantity:", col, row);
        quantityField = addField(col + 10, row, 3, false, "");
        row += 2;














        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    // ugly
                    int output = mediaTypes.getSelected();
                    String label = "";
                    if (output == 1) label = "Book";
                    if (output == 2) label = "DVD";
                    if (output == 3) label = "CD";
                    if (output == 4) label = "Video Game";


                    getApplication().messageBox("Testing",
                    "Library: " + libraryBox.getText() + 
                    "\n" + 
                    "Type: " + label + 
                    "\n" + 
                    "Title: " + titleField.getText() +
                    "\n"+
                    cdRadio.getLabel() +
                    "\n" + 
                    "quantityField: " + quantityField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LibrarianAddMedia.this);
                    new LibrarianMainMenu(getApplication());
                }
            } );
    }
}