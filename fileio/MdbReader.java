package poemstar.fileio;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import poemstar.beans.Poem;
import poemstar.beans.Poems;

/**
 * Read from MS-Access Database
 * @author Xinway
 */
public class MdbReader {
    /**
     * Read from MS-Access Database
     * @param filename Access file name (.mdb)
     * @param poems Out param
     */
    public void readFile(String filename, Poems poems) {
        try {
            db_.load();
            try (Database mdb = Database.open(new File("G:\\Test\\Poem\\db.mdb"))) {
                Table tbAuthor = mdb.getTable("xiaozhuan");
                Table tbPoem = mdb.getTable("poem");
                            
                int curPos = 0;
                for (Map<String, Object> row : tbPoem) {
                    //for (Entry<String, Object> item : row.entrySet()) {
                    //    System.out.println(item.getKey() + " - " + item.getValue().toString());
                    //}
                    
                    Poem p = new Poem();
                    String content = row.get("neirong").toString();
                    p.setContent(content);
                    
                    String id = row.get("id").toString();
                    p.setoriginalId(id);
                    
                    poems_.addPoem(p);
                    db_.addPoem(p);
                    
                    curPos++;
                }
            }
            db_.save();
            System.out.println("Read from db complete! Poems: " + poems_.getCount());           
        } catch (IOException ex) {
            org.pmw.tinylog.Logger.error(ex);
        }
    }
        
    public Poems getPoems() {
        return poems_;
    }
    
    PoemDB db_ = new PoemDB();
    Poems poems_ = new Poems();
}
