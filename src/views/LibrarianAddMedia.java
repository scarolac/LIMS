package views;

import jexer.*;

import java.util.ArrayList;
import java.util.List;

class LibrarianAddMedia extends ViewTemplate
{
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
        mediaBox = addComboBox((getWidth() / 2) + 13, row, 12, types, 0, 5, drawBottomHalf());     
        row += 4;

        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 30, false, "");
        row += 2;

        addLabel("Quantity:", col, row);
        // quantityField = addField(col + 10, row, 3, false, "");
        drawQuantity();
        row += 2;

        // TODO: the functions need to track the location without changing
        // global locations

        attributeOne = addLabel("Console:", col, row);
        attributeOne.setLabel("Author:");
        attributeOneField = addField(col + 8, row, 30, false, "");
        row += 2;

        attributeTwo = addLabel("Developer:", col, row);
        attributeTwo.setLabel("ISBN:");
        attributeTwoField = addField(20, row, 30, false, "");
        attributeTwoField.setX(6 + attributeTwo.getLabel().length());

        row += 2;

        attributeThree = addLabel("Publisher:", col, row);
        attributeThreeField = addField(col + 11, row, 30, false, "");
        row += 2;

        addButton("&Test",getWidth() / 2, getHeight() - 4,
            new TAction()
            {
                public void DO()
                {
                    String type = mediaBox.getText();
                    int amount = Integer.parseInt(quantityField.getText());
                    attributes.add(titleField.getText());
                    attributes.add(libraryBox.getText());
                    attributes.add(attributeOneField.getText());
                    attributes.add(attributeTwoField.getText());
                    attributes.add(attributeThreeField.getText());

                    String temp = "";
                    for (String i : attributes)
                        temp += i + "\n";

                    
                    getApplication().messageBox("Testing",
                    "Type: " + type 
                    + "\n" + 
                    "Amount: " + amount 
                    + "\n" +
                    temp,
                    TMessageBox.Type.OK);

                    attributes = new ArrayList<String>();
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

    public void drawQuantity()
    {
        quantityField = addField(col + 10, row, 3, false, "");
    }

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


}