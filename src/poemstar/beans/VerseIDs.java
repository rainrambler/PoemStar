
package poemstar.beans;

import java.util.HashMap;

/**
 *
 * @author xinway
 */
public class VerseIDs {
    public void addVerse(String s) {
        if (word2Id_.containsKey(s)) {
            return;
        }
        
        word2Id_.put(s, curId_);
        curId_++;
    }
    
    public int findVerseID(String s) {
        if (word2Id_.containsKey(s)) {
            return word2Id_.get(s);
        }
        return -1;
    }
    
    HashMap<String, Integer> word2Id_ = new HashMap<>();
    int curId_ = 100;
}
