

import java.util.*;

import Reader;

public abstract class Media
{
    private String title;
    private static int STOCKED;
    private String location;
    private boolean isCheckedOut;
    private Reader assignedTo;
    private Date dueDate;
    private int daysOverdue;
    private LinkedList<Reader> waitlist;

    /*******************************************
     * SETTERS
     *******************************************/

    /**
     * @param title the title to set
     */
    public void setTitle(String title) 
    {
        this.title = title;
    }

    /**
     * @param stocked the STOCKED to set
     */
    public static void setSTOCKED(int stocked) 
    {
        STOCKED = stocked;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) 
    {
        this.location = location;
    }
    /**
     * @param isCheckedOut the isCheckedOut to set
     */
    public void setCheckedOut(boolean isCheckedOut) 
    {
        this.isCheckedOut = isCheckedOut;
    }

    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(Reader assignedTo) 
    {
        this.assignedTo = assignedTo;
    }
    /**
     * @param daysOverdue the daysOverdue to set
     */
    public void setDaysOverdue(int daysOverdue) 
    {
        this.daysOverdue = daysOverdue;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) 
    {
        this.dueDate = dueDate;
    }
    /**
     * @param waitlist the waitlist to set
     */
    public void setWaitlist(LinkedList<Reader> waitlist) 
    {
        this.waitlist = waitlist;
    }

    /*******************************************
     * GETTERS
     *******************************************/

    /**
     * @return the title
     */
    public String getTitle() 
    {
        return title;
    }
    /**
     * @return the sTOCKED
     */
    public static int getSTOCKED() 
    {
        return STOCKED;
    }

    /**
     * @return the location
     */
    public String getLocation() 
    {
        return location;
    }

    /**
     * @return the isCheckedOut
     */
    public boolean isCheckedOut() 
    {
        return isCheckedOut;
    }


    // TODO: cant have numStocked and single reader
    /**
     * @return the assignedTo
     */
    public Reader getAssignedTo() 
    {
        return assignedTo;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() 
    {
        return dueDate;
    }

    /**
     * @return the daysOverdue
     */
    public int getDaysOverdue() 
    {
        return daysOverdue;
    }

    /**
     * @return the waitlist
     */
    public LinkedList<Reader> getWaitlist() 
    {
        return waitlist;
    }

    /*******************************************
     * MODIFIERS
     *******************************************/
    public void addToWaitlist(Reader reader)
    {
        waitlist.add(reader);
    }

    public void checkOut(Reader reader)
    {
        // TODO: maybe in constructor
        final DateFormat sdf = new SimpleDateFormat("d MMM yyyy");
        // https://stackoverflow.com/questions/23307324/how-do-i-add-2-weeks-to-a-date-in-java


        assignedTo = reader;
        reader.checkOutMedia(this);
        // TODO: remove stocked? maybe use a loop somewhere?
        this.setSTOCKED(getSTOCKED() - 1);
        dueDate = Date();
    }
}