package poemstar.fileio;

import poemstar.beans.PoemIndex;
import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import java.io.*;
import poemstar.util.StringUtil;

/**
 * Poem database using leveldb
 *
 * @author xinway
 */
public class PoemLevelDB {

    /**
     * Open leveldb database
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
     * Add a poem by index and content
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

        db_.put(bytes(pi.toDescription()), bytes(content));
    }
    
    /**
     * Delete a poem
     * @param pi Poem index
     */
    public void deletePoem(PoemIndex pi) {
        db_.delete(bytes(pi.toDescription()));
    }
    
    /**
     * Find a poem
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

    DB db_;
}
