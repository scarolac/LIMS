package views;

import jexer.*;
        
public class LoginScreen extends ViewTemplate
{
    public LoginScreen(final TApplication application)
    {
        super(application, "LIMS Login");
        
        addButton("&1) Scan Librarian Card", 5, 6, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LoginScreen.this);
                    LoginScreen.this.messageBox("Login Accepted", "Welcome Librarian");
                    new LibrarianMainMenu(getApplication());
                }
            } );
            
        addButton("&2) Scan Reader Card", 5, 9, 
            new TAction() 
            {
                public void DO() 
                {
                    getApplication().closeWindow(LoginScreen.this);
                    LoginScreen.this.messageBox("Login Accepted", "Welcome Reader");
                    new ReaderMainMenu(getApplication());
                }
            } );
        // addButton("&Close Window", (getWidth() - 14) / 2, getHeight() - 4,
        //     new TAction() {
        //         public void DO() {
        //             getApplication().closeWindow(LoginScreen.this);
        //         }
        //     }
        // );
    }
}