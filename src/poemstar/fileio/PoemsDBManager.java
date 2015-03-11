
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
            leveldb_.openDatabase();
            allPoems_ = leveldb_.getAllPoems();
            //PoemDB poemDB_ = new PoemDB();
            //poemDB_.loadconvert();
            dbLoaded_ = true;
        }
    }
        
    public void close() {
        leveldb_.close();
    }
    
    public Poems getPoems() {
        return allPoems_;
    }
    
    public Poem findPoem(String dynasty, String authorName, String title) {        
        PoemIndex pi = new PoemIndex();
        pi.setAuthor(authorName);
        pi.setDynasty(dynasty);
        pi.setTitle(title);
        String content = leveldb_.findPoem(pi); // find in db
        if (StringUtil.isNullOrEmpty(content)) {
            return null;
        }
        
        Poem p = new Poem();
        Author author = new Author();
        author.setAuthorName(authorName);
        p.setAuthor(author);
        p.setDynasty(dynasty);
        p.setTitle(title);
        p.setContent(content);
        p.setoriginalId("NA");
        
        return p;
    }
    
    public boolean deletePoem(String dynasty, String author, String title) {
        PoemIndex pi = new PoemIndex();
        pi.setAuthor(author);
        pi.setDynasty(dynasty);
        pi.setTitle(title);
        leveldb_.deletePoem(pi); // delete in db
        return true;
    }
    
    public boolean modifyPoemContent(String dynasty, String authorName, String title, String content) {
        addPoemContent(dynasty, authorName, title, content);
        return true;
    }
        
    /**
     * Add a poem to database
     * @param dynasty
     * @param authorName
     * @param title
     * @param content 
     * @return Result description for tips
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
        
        PoemIndex pi = new PoemIndex();
        pi.setAuthor(authorName);
        pi.setDynasty(dynasty);
        pi.setTitle(title);
        
        leveldb_.addPoem(pi, content);        
        return "Add poem complete.";
    }
        
    //PoemDB poemDB_ = new PoemDB();    
    PoemLevelDB leveldb_ = new PoemLevelDB();
    Poems allPoems_ = new Poems();
    boolean dbLoaded_ = false;
}
