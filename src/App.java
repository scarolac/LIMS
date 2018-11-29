
import models.*;
import views.*;
import controllers.*;

import jexer.*;

public class App extends TApplication {

    public App() throws Exception {
        super(BackendType.SWING); // Use Swing Frames instead of terminal

        // Title for frame
        getBackend().setTitle("LIMS");

        // Start on "login" page
        new LoginScreen(this);      
    }

    public static void main(String [] args) {
        try {
            App app = new App();
            (new Thread(app)).start();

            LibraryInformation libraryInformation = LibraryInformation.getInstance();
            
            Library libNorlin = new Library("Norlin");
            Library libBusiness = new Library("Business");
            Library libEngineering = new Library("Engineering");
            Library libLaw = new Library("Law");
            Library libMusic = new Library("Music");
            libraryInformation.addLibrary(libNorlin);
            libraryInformation.addLibrary(libBusiness);
            libraryInformation.addLibrary(libEngineering);
            libraryInformation.addLibrary(libLaw);
            libraryInformation.addLibrary(libMusic);
            libNorlin.addMedia(new Book("trees", "Norlin", "Me","ABC345","McGraw"));
            Media m1 = new Book("trees", "Engineering", "Me","ABC345","McGraw");
            libEngineering.addMedia(m1);
        

            Reader r1 = new Reader("Chris Scarola", "scarolac@colorado.edu");
            r1.setFees(23.13);
            libraryInformation.addReader(r1);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}