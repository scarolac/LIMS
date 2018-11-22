
import models.*;
public class AppTest
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
        Reader r = new Reader("Joe", "email");
        LibraryInformation.grab().addReader(r);
        print(LibraryInformation.grab().getReaders().get(0).getId());
        LibraryInformation.grab().removeReader(1);
    }

    public static void main(String[] args) 
    {
        testOne();
        testTwo();
        

    }
}