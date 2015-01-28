
package poemstar.beans;

import java.util.ArrayList;

/**
 * Verses of poem
 * @author xinway
 */
public class Verses {
    public void addVerse(String s) {
        contents_.add(s);
    }
    
    public int getCount() {
        return contents_.size();
    }
    
    public String getAt(int pos) {
        if ((pos < 0) || (pos >= getCount())) {
            return "";
        }
        
        return contents_.get(pos);
    }
    ArrayList<String> contents_ = new ArrayList<>();
}
