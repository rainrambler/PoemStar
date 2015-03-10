package poemstar.fileio;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import poemstar.beans.Author;
import poemstar.beans.ISearchResults;
import poemstar.beans.Poem;
import poemstar.beans.PoemIndex;
import poemstar.beans.Poems;
import poemstar.beans.QueryCondition;

/**
 * Poem Serialization to mapdb
 *
 * @author xinway
 */
public final class PoemDB {

    private void save() {
        mapdb_.commit();        
    }
    
    public void close() {
        mapdb_.close();
    }

    public void load() {
        // configure and open database using builder pattern.
        // all options are available with code auto-completion.
        mapdb_ = DBMaker.newFileDB(new File("AllPoems.db"))
                .closeOnJvmShutdown()
                .encryptionEnable("password")
                .make();

        // open an existing collection (or create new)
        poemIndexToPoemMap_ = mapdb_.getTreeMap("Poems");

        constructPoems();
    }

    /**
     * Add a poem to mapdb database
     * @param p Poem
     * @return Result
     */
    public String addPoem(Poem p) {
        PoemIndex idx = p.toPoemIndex();

        if (poemIndexToPoemMap_.containsKey(idx)) {
            return "Poem already exists:" + idx.getAuthor() + "(" + idx.getDynasty() + "):" + idx.getTitle();
        }
        poemIndexToPoemMap_.put(idx, p.getContent());
        save();
        return "Added complete";
    }

    public void constructPoems() {
        for (PoemIndex pi : poemIndexToPoemMap_.keySet()) {
            Poem p = new Poem();
            Author author = new Author();
            author.setAuthorName(pi.getAuthor());
            p.setAuthor(author);
            p.setContent(poemIndexToPoemMap_.get(pi));
            p.setDynasty(pi.getDynasty());
            p.setTitle(pi.getTitle());
            p.setoriginalId("NA");

            //System.out.println(p.getDynasty() + ", " + p.getAuthor().getAuthorName() + "," + p.getTitle());
            poems_.addPoem(p);
        }
    }

    public ISearchResults findPoems(QueryCondition qc) {
        return poems_.findPoems(qc);
    }

    /**
     * Find a poem by its author, dynasty, title EXACTLY
     * @param pi keywords
     * @return Founded poem or null
     */
    public Poem findPoem(PoemIndex pi) {
        if (!poemIndexToPoemMap_.containsKey(pi)) {
            return null;
        }

        String content = poemIndexToPoemMap_.get(pi);
        Poem p = new Poem();
        Author author = new Author();
        author.setAuthorName(pi.getAuthor());
        p.setAuthor(author);
        p.setDynasty(pi.getDynasty());
        p.setTitle(pi.getTitle());
        p.setContent(content);
        p.setoriginalId("NA");

        return p;
    }
    
    public boolean deletePoem(PoemIndex pi) {
        if (!poemIndexToPoemMap_.containsKey(pi)) {
            return false; // nothing to delete
        }

        poemIndexToPoemMap_.remove(pi);
        return true;
    }
    
    public boolean modifyPoemContent(Poem p) {
        PoemIndex pi = p.toPoemIndex();
        
        if (!poemIndexToPoemMap_.containsKey(pi)) {
            return false;
        }
        
        poemIndexToPoemMap_.put(pi, p.getContent());
        save();
        return true;
    }
    
    DB mapdb_;
    ConcurrentNavigableMap<PoemIndex, String> poemIndexToPoemMap_;

    public Poems getPoems() {
        return poems_;
    }
    Poems poems_ = new Poems();
}
