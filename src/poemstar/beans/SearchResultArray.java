
package poemstar.beans;

import java.util.ArrayList;

/**
 *
 * @author xinway
 */
public class SearchResultArray {
    ArrayList<SearchResult> results = new ArrayList<>();
    
    public int size() {
        return results.size();
    }
    
    public SearchResult getAt(int idx) {
        if (idx >= results.size()) {
            return null;
        }
        
        return results.get(idx);
    }
    
    public void add(SearchResult sr) {
        results.add(sr);
    }
}
