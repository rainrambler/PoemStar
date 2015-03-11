
package poemstar.fileio;

import poemstar.beans.Author;
import poemstar.beans.Poem;
import poemstar.beans.PoemIndex;
import poemstar.beans.Poems;
import poemstar.util.StringUtil;

/**
 * Wrapper of poem database
 * @author xinway
 */
public enum PoemsDBManager {
    INSTANCE;
    
    public void init() {
        if (!dbLoaded_) {
            poemDB_.loadconvert();
            dbLoaded_ = true;
        }
    }
        
    public void close() {
        poemDB_.close();
    }
    
    public Poems getPoems() {
        return poemDB_.getPoems();
    }
    
    public Poem findPoem(String dynasty, String author, String title) {
        PoemIndex pi = new PoemIndex();
        pi.setAuthor(author);
        pi.setDynasty(dynasty);
        pi.setTitle(title);
        return poemDB_.findPoem(pi);
    }
    
    public boolean deletePoem(String dynasty, String author, String title) {
        PoemIndex pi = new PoemIndex();
        pi.setAuthor(author);
        pi.setDynasty(dynasty);
        pi.setTitle(title);
        return poemDB_.deletePoem(pi);
    }
    
    public boolean modifyPoemContent(Poem p) {        
        if (!p.isValid()) {
            return false;
        }
        return poemDB_.modifyPoemContent(p);
    }
    
    public boolean modifyPoemContent(String dynasty, String authorName, String title, String content) {
        if (StringUtil.isNullOrEmpty(title) || StringUtil.isNullOrEmpty(dynasty)
                || StringUtil.isNullOrEmpty(authorName)
                || StringUtil.isNullOrEmpty(content)) {
            return false;
        }
        Poem p = new Poem();
        Author author = new Author();
        author.setAuthorName(authorName);
        p.setAuthor(author);
        p.setDynasty(dynasty);
        p.setTitle(title);
        p.setContent(content);
        p.setoriginalId("NA");              
        
        return modifyPoemContent(p);
    }
        
    /**
     * Add a poem to database
     * @param dynasty
     * @param authorName
     * @param title
     * @param content 
     * @return Result
     */
    public String addPoemContent(String dynasty, String authorName, String title, String content) {
        if (StringUtil.isNullOrEmpty(title) || StringUtil.isNullOrEmpty(dynasty)
                || StringUtil.isNullOrEmpty(authorName)
                || StringUtil.isNullOrEmpty(content)) {
            return "Parameter is null or empty. Add poem failure!";
        }
        
        Poem p = new Poem();
        Author author = new Author();
        author.setAuthorName(authorName);
        author.setAuthorDesc("NA");
        author.setAuthorId(100);
        author.setDynasty(dynasty);
        p.setAuthor(author);
        p.setDynasty(dynasty);
        p.setTitle(title);
        p.setContent(content);
        p.setoriginalId("NA");              
        p.setId(100);
        p.setDesc("NA");
        
        return poemDB_.addPoem(p);        
    }
        
    PoemDB poemDB_ = new PoemDB();    
    boolean dbLoaded_ = false;
}
