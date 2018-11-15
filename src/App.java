
import views.*;

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
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}