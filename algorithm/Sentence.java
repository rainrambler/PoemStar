
package poemstar.algorithm;

/**
 *
 * @author xinway
 */
public class Sentence {
    public Sentence(String val) {
        sentence_ = val;
        remains_ = val;
        result_ = "";
    }
    
    public void setChar(int charcount) {
        if (charcount <= 0) {
            return;
        }
        
        if (charcount > remains_.length()) {
            return;
        }
        
        curWord_ = remains_.substring(0, charcount);
        remains_ = remains_.substring(charcount);
        
        result_ += curWord_ + "-";
    }
    
    String sentence_;
    private String curWord_;
    private String remains_;
    private String result_;

    /**
     * @return the remains_
     */
    public String getRemains() {
        return remains_;
    }

    /**
     * @return the result_
     */
    public String getResult() {
        return result_;
    }
    
    public String getCurrentWord() {
        return curWord_;
    }
}
