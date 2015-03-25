
package poemstar.fileio;

import java.util.Collection;
import poemstar.beans.ISearchResults;
import poemstar.beans.Poem;
import poemstar.beans.Poems;
import poemstar.beans.QueryCondition;
import poemstar.beans.SearchResult;
import poemstar.util.StringUtil;

/**
 * 
 * @author xinway
 */
public final class PoemSplitter {
    public void splitPoems() {
        QueryCondition qc = QueryCondition.createQueryCondition("以上");
        Poems pms = PoemsDBManager.INSTANCE.getPoems();
        
        ISearchResults results = pms.findPoems(qc);
        
        int count = 0;
        for (String keyword : results.getKeywords()) {

            Collection<SearchResult> srs = results.getResults(keyword);
            for (SearchResult sr : srs) {
                //results.addIndextoResult(curPos, sr);
                Poem p = findPoem(sr);
                
                if (p != null) {
                    splitPoem(p);
                    count++;
                }
                
                if (count > 5) {
                    break;
                }
            }
        }
    }
    
    private Poem findPoem(SearchResult sr) {
        Poem p = PoemsDBManager.INSTANCE.findPoem(sr.getDynasty(), sr.getAuthorName(), sr.getTitle());
        return p;
    }
    
    private void splitPoem(Poem p) {
        String content = p.getContent();
        
        String[] arr = content.split("\r\n");
        
        int pos = 0;
        for (String s : arr) {
            s = s.trim();
            
            if (!StringUtil.isNullOrEmpty(s)) {
                // valid content
                String titlenew = p.getTitle() + CHINESE_INDEX[pos];
                
                System.out.println(titlenew);
                System.out.println(s);
                pos++;
            }
        }
    }
    
    String[] CHINESE_INDEX = {"其一", "其二", "其三", "其四", 
        "其五", "其六", "其七", "其八", "其九", 
        "其十", "其十一", "其十二", "其十三", "其十四",
        "其十五", "其十六", "其十七", "其十八", "其十九", 
        "其二十", "其二十一", "其二十二", "其二十三", "其二十四",
        "其二十五", "其二十六", "其二十七", "其二十八", "其二十九",
        "其三十", "其三十一", "其三十二", "其三十三", "其三十四",
        "其三十五", "其三十六", "其三十七", "其三十八", "其三十九", 
        "其四十", "其四十一", "其四十二", "其四十三", "其四十四",
        "其四十五", "其四十六", "其四十七", "其四十八", "其四十九", 
        "其五十", "其五十一", "其五十二", "其五十三", "其五十四",
        "其五十五", "其五十六", "其五十七", "其五十八", "其五十九", 
        "其十", "其十一", "其十二", "其十三", "其十四",
        "其十五", "其十六", "其十七", "其十八", "其十九", 
        "其六十", "其六十一", "其六十二", "其六十三", "其六十四",
        "其六十五", "其六十六", "其六十七", "其六十八", "其六十九", 
        "其七十", "其七十一", "其七十二", "其七十三", "其七十四",
        "其七十五", "其七十六", "其七十七", "其七十八", "其七十九", 
        "其八十", "其八十一", "其八十二", "其八十三", "其八十四",
        "其八十五", "其八十六", "其八十七", "其八十八", "其八十九",
        "其九十", "其九十一", "其九十二", "其九十三", "其九十四",
        "其九十五", "其九十六", "其九十七", "其九十八", "其九十九"
    };
}
