package models;

import java.util.*;

abstract class Media
{
    private String title;
    private int numStocked;
    private String location;
    private boolean isCheckedOut;
    private Reader assignedTo;
    private Date dueDate;
    private int daysOverdue;
    private LinkedList<Reader> waitlist;

    // TODO: need getters/setters

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
        dueDate = Date();
    }
}