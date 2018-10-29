package views;

import jexer.*;
import static jexer.TCommand.*;
import static jexer.TKeypress.*;

class ViewTemplate extends TWindow 
{
    private String subTitle;
    
    public ViewTemplate(final TApplication application, String subTitle) 
    {
        this(application, subTitle, CENTERED | RESIZABLE | NOCLOSEBOX);
    }

    private ViewTemplate(final TApplication application, String subTitle, final int flags) 
    {
        // All windows in LIMs have standard format, with centered subtitle
        super(application, "Library Inventory Management System", 0, 0, 70, 20, flags);
        this.setSubTitle(subTitle);
        addLabel(getSubTitle(), (getWidth() - getSubTitle().length()) / 2, 0);

        // status bar on bottom for easy exit
        statusBar = newStatusBar("LIMS");
        statusBar.addShortcutKeypress(kbF10, cmExit, "Exit");
    }
    /**
     * @return the subTitle
     */
    public String getSubTitle() 
    {
        return subTitle;
    }
    /**
     * @param subTitle the subTitle to set
     */
    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }
    
}
