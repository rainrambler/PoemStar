
package poemstar.beans;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author xinway
 */
public class SearchResults implements ISearchResults {
    
    ArrayList<SearchResult> results = new ArrayList<>();
    
    public void addResult(SearchResult sr) {
        results.add(sr);
    }

    @Override
    public Collection<SearchResult> getAllResults() {
        return results;
    }

    @Override
    public int size() {
        return results.size();
    }

    @Override
    public SearchResult getAt(int idx) {
        if (idx >= results.size()) {
            return null;
        }
        
        return results.get(idx);
    }
}
