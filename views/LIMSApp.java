package views;

import jexer.*;

class LIMSApp extends TApplication {

    public LIMSApp() throws Exception {
        super(BackendType.SWING); // Use Swing Frames instead of terminal

        // Title for frame
        getBackend().setTitle("LIMS");

        // Start on "login" page
        new LoginScreen(this);      
    }

    public static void main(String [] args) {
        try {
            LIMSApp app = new LIMSApp();
            (new Thread(app)).start();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}