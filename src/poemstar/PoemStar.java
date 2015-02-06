package poemstar;

import java.io.IOException;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.FileWriter;
import org.pmw.tinylog.writers.Writer;

/**
 *
 * @author Xinway
 */
public class PoemStar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configurator.defaultConfig()
                .writer(new FileWriter("poemstarlog.txt"))
                .level(Level.INFO)
                .activate();
        
        MainJDialog dlg = new MainJDialog(null, true);
        
        dlg.setVisible(true);
    }
}
