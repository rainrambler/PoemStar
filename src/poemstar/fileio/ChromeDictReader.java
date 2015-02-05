
package poemstar.fileio;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;
import poemstar.beans.PoemWords;

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
        //openFile("data/cc_cedict.txt");
        openFile("allwords.txt");
        
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
            Logger.error(ex);
        }
    }
    
    boolean parseLine(String line) {
        if ((line == null) || (line.length() == 0)) {
            return false;
        }
        
        if (line.startsWith("#")) {
            return false;
        }
        
        boolean res = AllWords.add(line);
        if (!res) {
            Logger.info("Repeat word: {0}", line);
        }
        
        return true;
    }
        
    HashSet<String> AllWords = new HashSet<>();
}
