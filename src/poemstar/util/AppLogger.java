
package poemstar.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xinway
 */
public enum AppLogger {

    INSTANCE;

    private void initLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("G:/poemlog%g.log");
        fileHandler.setLevel(Level.INFO);
        fileHandler.setFormatter(new PlainFormatter()); 
        logger_.addHandler(fileHandler);
    }

    private AppLogger() {
        try {
            initLogger();
        } catch (IOException ex) {
            logger_.log(Level.SEVERE, null, ex);
        }
    }

    public Logger getLogger() {
        return logger_;
    }
    private Logger logger_ = Logger.getLogger("PoemStar");
}
