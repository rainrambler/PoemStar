package poemstar.beans;

import java.util.Collection;

/**
 * Search results of poems
 * @author xinway
 */
public interface ISearchResults {
    /**
     * All search results
     * @return search results
     */
    Collection<SearchResult> getAllResults();
    
    /**
     * Results size
     * @return Results size
     */
    int size();
    
    /**
     * Get the search result in specified index
     * @param idx the array index
     * @return if index is out of range, return null, otherwise the search result.
     */
    SearchResult getAt(int idx);
}
