package views;

import jexer.*;
import controllers.*;
import models.*;

import java.util.ArrayList;

class LibrarianAddMedia extends ViewTemplate
{
    LibraryInformation li = LibraryInformation.getInstance();
    MediaController mc = new MediaController(li);

    int row;
    int col;

    ArrayList<String> attributes = new ArrayList<String>();

    TComboBox libraryBox = null;
    TComboBox mediaBox = null;

    TField titleField = null;
    TField quantityField = null;

    TLabel attributeOne = null;
    TLabel attributeTwo = null;
    TLabel attributeThree = null;

    TField attributeOneField = null;
    TField attributeTwoField = null;
    TField attributeThreeField = null;

    public LibrarianAddMedia(final TApplication application)
    {
        super(application, "Add Media");        

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
        mediaBox = addComboBox((getWidth() / 2) + 13, row, 12, types, 0, 5, drawBottomHalf());     
        row += 4;

        // Title input area
        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;

        // Quantity input area
        addLabel("Quantity:", col, row);
        quantityField = addField(col + 10, row, 3, false, "");
        row += 2;

        // First attribute
        attributeOne = addLabel("Console:", col, row);
        attributeOne.setLabel("Author:");
        attributeOneField = addField(col + 8, row, 30, false, "");
        row += 2;

        // Second Attribute
        attributeTwo = addLabel("Developer:", col, row);
        attributeTwo.setLabel("ISBN:");
        attributeTwoField = addField(20, row, 30, false, "");
        attributeTwoField.setX(6 + attributeTwo.getLabel().length());
        row += 2;

        // Third Attribute (hopefully last, not easily extendable)
        attributeThree = addLabel("Publisher:", col, row);
        attributeThreeField = addField(col + 11, row, 30, false, "");
        row += 2;

        // Button to call the controller to add the media
        addButton("&Add Media",getWidth() / 2, getHeight() - 4, addMediaButton());

        // Cancel button, return to previous menu
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

    /**
     * Dynamically change the view based on the type selected
     * @return an Action event -> dynamic redraw of view
     */
    private TAction drawBottomHalf()
    {
        return new TAction()
        {
            public void DO()
            {
                if (mediaBox.getText().equals("Book"))
                {
                    attributeOne.setLabel("Author:");                    
                    attributeTwo.setLabel("ISBN:");
                    attributeThree.setLabel("Publisher:");
                    if(!attributeThreeField.isVisible() || !attributeThree.isVisible())
                    {
                        attributeThree.setVisible(true);
                        attributeThreeField.setVisible(true);
                    }

                }

                if (mediaBox.getText().equals("DVD"))
                {
                    attributeOne.setLabel("Year:");                    
                    attributeTwo.setLabel("Genre:");

                    attributeThree.setVisible(false);
                    attributeThreeField.setText("");
                    attributeThreeField.setVisible(false);                    
                }

                if (mediaBox.getText().equals("CD"))
                {
                    attributeOne.setLabel("Artist:");                    
                    attributeTwo.setLabel("Year:");
                    attributeThree.setLabel("Genre:");
                    if(!attributeThreeField.isVisible() || !attributeThree.isVisible())
                    {
                        attributeThree.setVisible(true);
                        attributeThreeField.setVisible(true);
                    }
                        
                }

                if (mediaBox.getText().equals("VideoGame"))
                {
                    attributeOne.setLabel("Console:");                    
                    attributeTwo.setLabel("Developer:");

                    attributeThree.setVisible(false);
                    attributeThreeField.setText("");
                    attributeThreeField.setVisible(false);   
                }

                attributeOneField.setX(6 + attributeOne.getLabel().length());
                attributeTwoField.setX(6 + attributeTwo.getLabel().length());
                attributeThreeField.setX(6 + attributeThree.getLabel().length());
            }
            
        };
    }

    /**
     * Calls the media controller to add an item to a library
     * @return an action event -> add media button pressed
     */
    private TAction addMediaButton()
    {
        return new TAction()
        {
            public void DO()
            {
                String type = mediaBox.getText();
                String quantity = quantityField.getText();
                // prevents app from collapsing, makes sure string is a number, otherwise gives it 1
                int amount = (quantity.matches("-?\\d+(\\.\\d+)?")) ? Integer.parseInt(quantity) : 1;

                // get the data
                String title = titleField.getText();
                String library = libraryBox.getText();
                String attrOne = attributeOneField.getText();
                String attrTwo = attributeTwoField.getText();
                String attrThree = attributeThreeField.getText(); 

                // ensure non empty fields
                if (title.equals("") ||
                    attrOne.equals("") ||
                    attrTwo.equals(""))
                    {
                        getApplication().messageBox("Fields Missing",
                        "Fill out all fields", TMessageBox.Type.OK);
                        return;
                    }

                // build attributes list
                attributes.add(title);
                attributes.add(library);
                attributes.add(attrOne);
                attributes.add(attrTwo);
                attributes.add(attrThree);

                // popup and call the addmedia function to get status
                getApplication().messageBox("Testing",
                    mc.addMedia(type, amount, attributes),
                    TMessageBox.Type.OK);

                //reset the attributes for next run
                attributes = new ArrayList<String>();
            }
        };
    }

}