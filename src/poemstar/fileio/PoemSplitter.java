
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
        
        for (String keyword : results.getKeywords()) {

            Collection<SearchResult> srs = results.getResults(keyword);
            for (SearchResult sr : srs) {
                //results.addIndextoResult(curPos, sr);
                Poem p = findPoem(sr);
                
                if (p != null) {
                    splitPoem(p);
                }
            }
        }
    }
    
    public void removeCompositePoems() {
        QueryCondition qc = QueryCondition.createQueryCondition("以上");
        Poems pms = PoemsDBManager.INSTANCE.getPoems();
        
        ISearchResults results = pms.findPoems(qc);
        
        for (String keyword : results.getKeywords()) {

            Collection<SearchResult> srs = results.getResults(keyword);
            for (SearchResult sr : srs) {
                //results.addIndextoResult(curPos, sr);
                Poem p = findPoem(sr);
                
                if ((p != null) && (p.getContent().contains("作品"))){
                    PoemsDBManager.INSTANCE.deletePoem(p.getDynasty(), p.getAuthor().getAuthorName(), p.getTitle());
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
                PoemsDBManager.INSTANCE.addPoemContent(p.getDynasty(), p.getAuthor().getAuthorName(), titlenew, s);
                //System.out.println(titlenew);
                //System.out.println(s);
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
        "其九十五", "其九十六", "其九十七", "其九十八", "其九十九",
        "其一百", "其一零一", "其一零二", "其一零三", "其一零四",
        "其一零五", "其一零六", "其一零七", "其一零八", "其一零九",
        "其一一零", "其一一一", "其一一二", "其一一三", "其一一四",
        "其一一五", "其一一六", "其一一七", "其一一八", "其一一九",
        "其一二零", "其一二一", "其一二二", "其一二三", "其一二四",
        "其一二五", "其一二六", "其一二七", "其一二八", "其一二九",
        "其一三零", "其一三一", "其一三二", "其一三三", "其一三四",
        "其一三五", "其一三六", "其一三七", "其一三八", "其一三九",
        "其一四零", "其一四一", "其一四二", "其一四三", "其一四四",
        "其一四五", "其一四六", "其一四七", "其一四八", "其一四九",
        "其一五零", "其一五一", "其一五二", "其一五三", "其一五四",
        "其一五五", "其一五六", "其一五七", "其一五八", "其一五九",
        "其一六零", "其一六一", "其一六二", "其一六三", "其一六四",
        "其一六五", "其一六六", "其一六七", "其一六八", "其一六九",
        "其一七零", "其一七一", "其一七二", "其一七三", "其一七四",
        "其一七五", "其一七六", "其一七七", "其一七八", "其一七九",
        "其一八零", "其一八一", "其一八二", "其一八三", "其一八四",
        "其一八五", "其一八六", "其一八七", "其一八八", "其一八九",
        "其一九零", "其一九一", "其一九二", "其一九三", "其一九四",
        "其一九五", "其一九六", "其一九七", "其一九八", "其一九九",
        "其二零零", "其二零一", "其二零二", "其二零三", "其二零四",
        "其二零五", "其二零六", "其二零七", "其二零八", "其二零九",
        "其二一零", "其二一一", "其二一二", "其二一三", "其二一四",
        "其二一五", "其二一六", "其二一七", "其二一八", "其二一九",
        "其二二零", "其二二一", "其二二二", "其二二三", "其二二四",
        "其二二五", "其二二六", "其二二七", "其二二八", "其二二九",
        "其二三零", "其二三一", "其二三二", "其二三三", "其二三四",
        "其二三五", "其二三六", "其二三七", "其二三八", "其二三九",
        "其二四零", "其二四一", "其二四二", "其二四三", "其二四四",
        "其二四五", "其二四六", "其二四七", "其二四八", "其二四九",
        "其二五零", "其二五一", "其二五二", "其二五三", "其二五四",
        "其二五五", "其二五六", "其二五七", "其二五八", "其二五九",
        "其二六零", "其二六一", "其二六二", "其二六三", "其二六四",
        "其二六五", "其二六六", "其二六七", "其二六八", "其二六九",
        "其二七零", "其二七一", "其二七二", "其二七三", "其二七四",
        "其二七五", "其二七六", "其二七七", "其二七八", "其二七九",
        "其二八零", "其二八一", "其二八二", "其二八三", "其二八四",
        "其二八五", "其二八六", "其二八七", "其二八八", "其二八九",
        "其二九零", "其二九一", "其二九二", "其二九三", "其二九四",
        "其二九五", "其二九六", "其二九七", "其二九八", "其二九九",
        "其三零零", "其三零一", "其三零二", "其三零三", "其三零四",
        "其三零五", "其三零六", "其三零七", "其三零八", "其三零九",
        "其三一零", "其三一一", "其三一二", "其三一三", "其三一四",
        "其三一五", "其三一六", "其三一七", "其三一八", "其三一九",
        "其三二零", "其三二一", "其三二二", "其三二三", "其三二四",
        "其三二五", "其三二六", "其三二七", "其三二八", "其三二九",
        "其三三零", "其三三一", "其三三二", "其三三三", "其三三四",
        "其三三五", "其三三六", "其三三七", "其三三八", "其三三九",
        "其三四零", "其三四一", "其三四二", "其三四三", "其三四四",
        "其三四五", "其三四六", "其三四七", "其三四八", "其三四九",
        "其三五零", "其三五一", "其三五二", "其三五三", "其三五四",
        "其三五五", "其三五六", "其三五七", "其三五八", "其三五九",
        "其三六零", "其三六一", "其三六二", "其三六三", "其三六四",
        "其三六五", "其三六六", "其三六七", "其三六八", "其三六九",
        "其三七零", "其三七一", "其三七二", "其三七三", "其三七四",
        "其三七五", "其三七六", "其三七七", "其三七八", "其三七九"
    };
}
