
package poemstar.beans;

import java.util.ArrayList;

/**
 *
 * @author xinway
 */
public class ChineseWords {
    public void add(String wd) {
        allWords.add(wd);
    }
    
    public int getSize() {
        return allWords.size();
    }
    
    public String getAt(int pos) {
        return allWords.get(pos);
    }
    
    ArrayList<String> allWords = new ArrayList<>();
}
