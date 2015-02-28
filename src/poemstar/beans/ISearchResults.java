package poemstar.beans;

import java.util.Collection;

/**
 * Search results of poems. Implements getall, size and getat function
 * @author xinway
 */
public interface ISearchResults {
    /**
     * All search results
     * @param key keyword
     * @return search results
     */
    Collection<SearchResult> getResults(String key);
    
    Collection<String> getKeywords();
    
    void addIndextoResult(int idx, SearchResult sr);
    
    SearchResult FindResult(int idx);
}
