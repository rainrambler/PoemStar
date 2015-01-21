
package poemstar.beans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author xinway
 */
public enum ChineseWords {
    INSTANCE;
    
    public void addWord(String val) {
        if ((val == null) || (val.length() <= 0)) {
            return;
        }
        
        if (allWords_.contains(val)) {
            return;
        }
        
        allWords_.add(val);
    }
    
    public void saveToFile(String xmlFileName) {
        
        Collections.sort(allWords_);
        
        try {
            File file = new File(xmlFileName);
            FileUtils.writeLines(file, allWords_);
        } catch (IOException ex) {
            Logger.getLogger(ChineseWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadFromFile(String xmlFileName) {
        try {
            File file = new File(xmlFileName);
            allWords_.addAll(FileUtils.readLines(file));
        } catch (IOException ex) {
            Logger.getLogger(ChineseWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ArrayList<String> allWords_ = new ArrayList<>();
}
