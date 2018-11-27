
import models.*;
import views.*;
import controllers.*;

import java.util.*;
import jexer.*;

public class AppTest extends TApplication
{

    public static <T> void print(T s)
    {
        System.out.println(s);
    }

    public static void testOne()
    {
        Media m = new Book("trees", "Norlin", "Me","ABC345","McGraw");
        // Media m2 = new Media("car", "place");
        Reader r = new Reader();
        Reader r2 = new Reader("joe", "no@no.com");
        Librarian l = new Librarian("John", 0);
        print(l.getName());
        print(m.getTitle());
        print(m.getLocation());
        print(r.getEmail());
        r.addFees(55.76);
        print(r.getFees());
        r.checkOutMedia(m);
        m.checkOut(r);
        r2.checkOutMedia(m);
        m.checkOut(r2);
        // r.checkOutMedia(m2);
        print(r.getId());
        print(r2.getId());
        for(Media i : r.getCheckedOut())
        {
            print(i);
        }

        for(Media i : r2.getCheckedOut())
        {
            print(i);
        }
    }

    public static void testTwo()
    {
        LibraryInformation lI = new LibraryInformation();
        Reader r = new Reader("Joe", "email");
        lI.addReader(r);
        print(lI.getReaders().get(0).getId());
        lI.removeReader(1);
    }

    public static void testThree()
    {
        Library lib = new Library("Norlin");
        Library libBusiness = new Library("Business");
        Library libEngineering = new Library("Engineering");
        Library libLaw = new Library("Law");
        Library libMusic = new Library("Music");

        String args2[] = new String[] {"trees", "Norlin", "Me","ABC345","McGraw"};
        print(Arrays.toString(args2));
        print(lib.addMedia(new Book(args2[0], args2[1], args2[2], args2[3], args2[4])));
        lib.addMedia(new Book("trees", "Norlin", "Me","ABC345","McGraw"));
        lib.addMedia(new Book("trees", "Norlin", "Me","ABC345","McGraw"));
        lib.addMedia(new Book("cats", "Norlin", "Me","ABC345","McGraw"));
        lib.addMedia(new Book("trees", "Norlin", "Me","ABC345","McGraw"));


        ArrayList<Media> temp = lib.searchMedia("trees", "Book");
        // temp.asArray();
        print(temp);
    }

    public AppTest() throws Exception {
        super(BackendType.SWING); // Use Swing Frames instead of terminal

        // Title for frame
        getBackend().setTitle("LIMS");

        // Start on "login" page
        new LoginScreen(this);      
    }

    public static void main(String[] args) 
    {
        // testOne();
        // testTwo();
        // testThree();
        
        try 
        {
            AppTest app = new AppTest();
            

            LibraryInformation libraryInformation = new LibraryInformation();
            MediaController mc = new MediaController(libraryInformation, app);
           



            (new Thread(app)).start();







        } 
        catch (Throwable t) 
        {
            t.printStackTrace();
        }
        
        


    }
}