package poemstar.beans;

/**
 * Search result of poems
 * @author Xinway
 */
public class SearchResult {
    private String currentSentence;
    private String prevSentence;
    private String nextSentence;
    private String allSentences;
    private String authorName;
    private String Dynasty_;
    private String Title_;
    
    public void setAuthorName(String s) {
        authorName = s;
    }
    
    public String getAuthorName() {
        return authorName;
    }
    
    public void setDynasty(String s) {
        Dynasty_ = s;
    }
    
    public String getDynasty() {
        return Dynasty_;
    }

    /**
     * @return the currentSentence
     */
    public String getCurrentSentence() {
        return currentSentence;
    }

    /**
     * @param currentSentence the currentSentence to set
     */
    public void setCurrentSentence(String currentSentence) {
        this.currentSentence = currentSentence;
    }

    /**
     * @return the prevSentence
     */
    public String getPrevSentence() {
        return prevSentence;
    }

    /**
     * @param prevSentence the prevSentence to set
     */
    public void setPrevSentence(String prevSentence) {
        this.prevSentence = prevSentence;
    }

    /**
     * @return the nextSentence
     */
    public String getNextSentence() {
        return nextSentence;
    }

    /**
     * @param nextSentence the nextSentence to set
     */
    public void setNextSentence(String nextSentence) {
        this.nextSentence = nextSentence;
    }
    
    public String getDescription() {
        String s = "";
        if (prevSentence.length() != 0) {
            s += prevSentence + ", ";
        }
        
        s += currentSentence + ", ";
        if (nextSentence.length() != 0) {
            s += nextSentence + "...";
        }
        return s;
    }

    /**
     * @return the allSentences
     */
    public String getAllSentences() {
        return allSentences;
    }

    /**
     * @param allSentences the allSentences to set
     */
    public void setAllSentences(String allSentences) {
        this.allSentences = allSentences;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title_;
    } 

    /**
     * @param title the Title to set
     */
    public void setTitle(String title) {
        this.Title_ = title;
    }
    
    public String getDesc() {
        return getTitle() + "--" + getAuthorName() + "(" + getDynasty() + ")";
    }
}
