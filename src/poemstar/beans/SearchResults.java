
package poemstar.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Search results of poems.
 * @author xinway
 */
public class SearchResults implements ISearchResults {
    
    HashMap<String, SearchResultArray> allResults = new HashMap<>();
    HashMap<Integer, SearchResult> idx2result = new HashMap<>();

    public void addResult(String keyword, SearchResult sr) {
        if (allResults.containsKey(keyword)) {
            allResults.get(keyword).add(sr);
        }
        else {
            SearchResultArray sra = new SearchResultArray();
            sra.add(sr);
            allResults.put(keyword, sra);
        }
    }

    @Override
    public Collection<SearchResult> getResults(String keyword) {
        if (allResults.containsKey(keyword)) {
            return allResults.get(keyword).results;
        }
        else {
            return null;
        }
    }

    @Override
    public Collection<String> getKeywords() {
        return allResults.keySet();
    }

    @Override
    public void addIndextoResult(int idx, SearchResult sr) {
        idx2result.put(idx, sr);
    }

    @Override
    public SearchResult FindResult(int idx) {
        if (idx2result.containsKey(idx)) {
            return idx2result.get(idx);
        }
        
        return null;
    }
}
