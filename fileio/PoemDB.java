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

    public void save() {
        mapdb_.commit();
        mapdb_.close();
    }

    public void load() {
        // configure and open database using builder pattern.
        // all options are available with code auto-completion.
        mapdb_ = DBMaker.newFileDB(new File("AllPoems.db"))
                .closeOnJvmShutdown()
                .encryptionEnable("password")
                .make();

        // open existing an collection (or create new)
        poemIndexToPoemMap_ = mapdb_.getTreeMap("Poems");
        
        constructPoems();
    }

    public void addPoem(Poem p) {
        PoemIndex idx = new PoemIndex();

        idx.setAuthor(p.getAuthor().getAuthorName());
        idx.setDynasty(p.getDynasty());
        idx.setTitle(p.getTitle());

        addPoem(idx, p.getContent());
    }

    public void addPoem(PoemIndex pi, String content) {
        poemIndexToPoemMap_.put(pi, content);
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
            
            poems_.addPoem(p);
        }
    }

    public ISearchResults findPoems(QueryCondition qc) {
        return poems_.findPoems(qc);
    }
        
    DB mapdb_;
    ConcurrentNavigableMap<PoemIndex, String> poemIndexToPoemMap_;

    public Poems getPoems() {
        return poems_;
    }
    Poems poems_ = new Poems();
}
