package views;

import jexer.*;

class ReaderSearchMedia extends ViewTemplate
{
    TField titleField = null;

    public ReaderSearchMedia(final TApplication application)
    {
        super(application, "Search for item");

        int row = 3;
        int col = 5;

        addLabel("Title:", col, row);
        titleField = addField(col + 7, row, 40, false, "");
        addButton("&Search", col + 48, row,
            new TAction()
            {
                public void DO()
                {
                    getApplication().messageBox("Search",
                    "title:" + 
                    titleField.getText(),
                    TMessageBox.Type.OK);
                }
            }
        );

        addButton("&Cancel", getWidth()-14, getHeight() - 4, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(ReaderSearchMedia.this);
                    new ReaderMainMenu(getApplication());
                }
            } );
    }
}