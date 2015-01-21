
package poemstar.fileio;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import poemstar.beans.PoemWords;
import poemstar.util.AppLogger;

/**
 * Read Chinese words file in Chromium code
 * src\third_party\icu\source\data\brkitr\cc_cedict.txt
 * @author xinway
 */
public class ChromeDictReader {
    /**
     * Add all words from file to poemwords
     * @param pw All Words
     */
    public void init(PoemWords pw) {
        openFile("data/cc_cedict.txt");
        
        pw.addWords(AllWords);
    }
    
    void openFile(String filename) {
        File file = new File(filename);
        try {
            List<String> lines = FileUtils.readLines(file);
            for (String line : lines) {
                parseLine(line);
            }
        } catch (IOException ex) {
            AppLogger.INSTANCE.getLogger().log(Level.SEVERE, null, ex);
        }
    }
    
    boolean parseLine(String line) {
        if ((line == null) || (line.length() == 0)) {
            return false;
        }
        
        if (line.startsWith("#")) {
            return false;
        }
        
        AllWords.add(line);
        
        return true;
    }
        
    HashSet<String> AllWords = new HashSet<>();
}
