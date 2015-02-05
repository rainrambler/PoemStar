
package poemstar.fileio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;
import poemstar.util.DateTimeUtils;

/**
 *
 * @author xinway
 */
public class SplitResultWriter {  
    public void writeLogFiles() {
        File allfile = new File("PoemSentences_" + DateTimeUtils.getTimeDesc() + ".txt");
        File unmatchedfile = new File("UnmatchSentences_" + DateTimeUtils.getTimeDesc() + ".txt");
        try {
            FileUtils.writeLines(allfile, allSentences_);
            FileUtils.writeLines(unmatchedfile, unmatchedSentences_);
        } catch (IOException ex) {
            Logger.error(ex);
        }
    }
    
    public void addSentence(String sentence) {
        allSentences_.add(sentence);
    }
    
    public void addUnmatchedSentence(String sentence) {
        unmatchedSentences_.add(sentence);
    }
    
    List<String> allSentences_ = new ArrayList<>();
    List<String> unmatchedSentences_ = new ArrayList<>();
}
