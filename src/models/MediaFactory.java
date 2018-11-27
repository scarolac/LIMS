package models;

public class MediaFactory 
{
    public static Media getNewMedia(String type, String [] args)
    {
        Media media = null;

        if(type.equals("Book"))
            media = new Book(args[0], args[1], args[2], args[3], args[4]);
        if(type.equals("CD"))
            media = new CD(args[0], args[1], args[2], args[3], args[4]);
        if(type.equals("DVD"))
            media = new DVD(args[0], args[1], args[2], args[3]);
        if(type.equals("VideoGame"))
            media = new VideoGame(args[0], args[1], args[2], args[3]);

        return media;
    }
}