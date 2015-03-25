package poemstar.fileio;

import poemstar.beans.PoemIndex;
import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import java.io.*;
import poemstar.beans.Author;
import poemstar.beans.Poem;
import poemstar.beans.Poems;
import poemstar.util.StringUtil;

/**
 * Poem database using leveldb
 *
 * @author xinway
 */
public final class PoemLevelDB {

    /**
     * Open leveldb database
     *
     * @return Opened successfully
     */
    public boolean openDatabase() {
        try {
            Options options = new Options();
            options.createIfMissing(true);
            db_ = factory.open(new File("poemleveldb"), options);

            return true;
        } catch (IOException ex) {
            org.pmw.tinylog.Logger.error(ex);
            return false;
        }
    }
    
    /**
     * Open leveldb database
     *
     * @return Opened successfully
     */
    public boolean openSnappyDatabase() {
        try {
            Options options = new Options();
            options.createIfMissing(true);
            options.compressionType(CompressionType.SNAPPY);
            db_ = factory.open(new File("poemsnappydb"), options);

            return true;
        } catch (IOException ex) {
            org.pmw.tinylog.Logger.error(ex);
            return false;
        }
    }

    /**
     * Add a poem by index and content
     *
     * @param pi Poem index
     * @param content Content as value in KV database
     */
    public void addPoem(PoemIndex pi, String content) {
        if (!pi.isValid()) {
            org.pmw.tinylog.Logger.warn("AddPoem: Key is invalid!");
            return;
        }

        if (StringUtil.isNullOrEmpty(content)) {
            org.pmw.tinylog.Logger.warn("AddPoem: Content is invalid!");
            return;
        }

        db_.put(index2bytes(pi), bytes(content));
    }

    /**
     * Delete a poem
     *
     * @param pi Poem index
     */
    public void deletePoem(PoemIndex pi) {
        db_.delete(index2bytes(pi));
    }

    /**
     * Find a poem
     *
     * @param pi Poem index
     * @return Poem content. Empty string means not found.
     */
    public String findPoem(PoemIndex pi) {
        byte[] val = db_.get(index2bytes(pi));

        if (val == null) {
            return ""; // not find
        }

        if (val.length == 0) {
            return ""; // not find
        }

        String content = asString(val);
        return content;
    }

    private byte[] index2bytes(PoemIndex pi) {
        return bytes(pi.toDescription());
    }

    public void close() {
        try {
            db_.close();
        } catch (IOException ex) {
            org.pmw.tinylog.Logger.error(ex);
        }
    }

    public Poems getAllPoems() {
        Poems allPoems = new Poems();
        DBIterator iterator = db_.iterator();
        try {
            for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                String key = asString(iterator.peekNext().getKey());
                String value = asString(iterator.peekNext().getValue());
                
                Poem p = makePoem(key, value);
                
                if (p != null) {
                    allPoems.addPoem(p);
                }
                else {
                    org.pmw.tinylog.Logger.warn("Poem format error: {}-{}", key, value);
                }
            }
        } finally {
            try {
                // Make sure you close the iterator to avoid resource leaks.
                iterator.close();
            } catch (IOException ex) {
                org.pmw.tinylog.Logger.error(ex);
            }
        }
        
        return allPoems;
    }
    
    public Poem makePoem(String poemKey, String content) {
        PoemIndex pi = makePoemIndex(poemKey);
        if (pi == null) {
            return null;
        }
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
    
    private PoemIndex makePoemIndex(String poemKey) {
        String[] arr = poemKey.split("\\|");
        if (arr.length != 3) {
            return null;
        }
        
        PoemIndex pi = new PoemIndex();
        pi.setDynasty(arr[0]);
        pi.setAuthor(arr[1]);
        pi.setTitle(arr[2]);
        
        return pi;
    }

    DB db_;
}
