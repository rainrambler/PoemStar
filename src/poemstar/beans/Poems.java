package poemstar.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * All poems
 * @author Xinway
 */
public class Poems {
    public ISearchResults findPoems(QueryCondition qc) {
        SearchResults srs = new SearchResults();
        
        for (Poem p : allPoems_) {
            p.match(qc, srs);
        }
        
        return srs;
    }
    
    public void addPoem(Poem val) {
        allPoems_.add(val);
    }
    
    public int getCount() {
        return allPoems_.size();
    }
    
    public Collection<Poem> getAll() {
        return allPoems_;
    }
    
    public Poem getAt(int pos) {
        if ((pos < 0) || (pos >= allPoems_.size())) {
            return null;
        }
        
        return allPoems_.get(pos);
    }
    
    public Poem getRandom() {
        if (allPoems_.isEmpty()) {
            return null;
        }
        
        int pos = (int)(Math.random() * getCount());
        
        return allPoems_.get(pos);
    }
    
    List<Poem> allPoems_ = new ArrayList<>();
}
