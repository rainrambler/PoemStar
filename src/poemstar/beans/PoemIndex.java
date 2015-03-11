package poemstar.beans;

import com.google.common.collect.ComparisonChain;
import java.io.Serializable;
import poemstar.util.StringUtil;

/**
 * Lookup index (Author name, Dynasty, Title)
 * @author xinway
 */
public final class PoemIndex implements Comparable<PoemIndex>, Serializable {
    private String Author;
    private String Dynasty;
    private String Title;

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the Dynasty
     */
    public String getDynasty() {
        return Dynasty;
    }

    /**
     * @param Dynasty the Dynasty to set
     */
    public void setDynasty(String Dynasty) {
        this.Dynasty = Dynasty;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    public String toDescription() {
        return Dynasty + "|" + Author + "|" + Title;
    }
    
    public boolean isValid() {
        return !StringUtil.isNullOrEmpty(Title) && !StringUtil.isNullOrEmpty(Author)
                && !StringUtil.isNullOrEmpty(Dynasty);
    }

    @Override
    public int compareTo(PoemIndex o) {
        return ComparisonChain.start().compare(o.Title, Title)
                .compare(o.Author, Author)
                .compare(o.Dynasty, Dynasty)
                .result();
    }
}
