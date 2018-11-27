package controllers;

import models.*;
import views.*;

import jexer.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MediaController
{
    private LibraryInformation libraryInformation;
    private TApplication app;
    
    public MediaController(LibraryInformation libraryInformation, TApplication app)
    {
        this.libraryInformation = libraryInformation;
        this.app = app;
    }

    public void addMedia(String type, int amount, ArrayList<String> attributes)
    {
        for (int i = 0; i < amount; ++i)
            libraryInformation.addMedia(
                    MediaFactory.getNewMedia(type, attributes.toArray(new String[0])), 
                    attributes.get(1)  // name of library always second item
                    );
    }

    public void removeMedia()
    {

    }

    public void checkoutMedia()
    {

    }

    public void returnMedia()
    {

    }

    public void searchMedia()
    {

    }

    public TAction test()
    {
        return new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LoginScreen.this);
                    LoginScreen.this.messageBox("Login Accepted", "Welcome Librarian");
                    new LibrarianMainMenu(getApplication());
                }
            }; 
    }
}