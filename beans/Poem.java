package poemstar.beans;

import java.util.ArrayList;
import java.util.Arrays;
import poemstar.util.StringUtil;

/**
 * A poem
 * @author Xinway
 */
public class Poem {     
    public String getoriginalId() {
        return originalId_;
    }
    
    public void setoriginalId(String id) {
        originalId_ = id;
    }
    
    public Integer getId() {
        return PoemId_;
    }
    
    public void setId(Integer id) {
        PoemId_ = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content_;
    }

    /**
     * @param content_ the content to set
     */
    public void setContent(String content_) {
        this.content_ = content_;
        
        parseSentence();
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author_;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author_ = author;
    }

    /**
     * @return the dynasty
     */
    public String getDynasty() {
        return dynasty_;
    }

    /**
     * @param dynasty_ the dynasty to set
     */
    public void setDynasty(String dynasty_) {
        this.dynasty_ = dynasty_;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc_;
    }

    /**
     * @param desc_ the desc to set
     */
    public void setDesc(String desc_) {
        this.desc_ = desc_;
    }
    
    public void setTitle(String v) {
        Title_ = v;
    }
    
    public String getTitle() {
        return Title_;
    }
    
    private boolean findInSentence(String fragment, SearchResults results) {
        boolean founded = false;
        final int totalCount = subSentences_.size();
        for (int i = 0; i < totalCount; i++) {
            String s = subSentences_.get(i);
            if (s.indexOf(fragment) != -1) {
                
                SearchResult sr = new SearchResult();
                sr.setAuthorName(author_.getAuthorName());
                sr.setDynasty(getDynasty());
                sr.setCurrentSentence(s);
                
                if ((i + 1) < totalCount) {
                    sr.setNextSentence(subSentences_.get(i + 1));
                }
                else {
                    sr.setNextSentence("");
                }
                if (i == 0) {
                    sr.setPrevSentence("");
                }
                else {
                    sr.setPrevSentence(subSentences_.get(i - 1));
                }
                
                //sr.setPoem(this);
                sr.setAllSentences(getAllSentences());
                
                results.addResult(sr);
                
                founded = true;
            }
        }
        
        return founded;
    }
    
    public boolean match(QueryCondition qc, SearchResults results) {
        if (!StringUtil.isNullOrEmpty(qc.getAuthor())) {
            if (!qc.getAuthor().equals(author_.getAuthorName())) {
                return false;
            }
        }
        
        if (!StringUtil.isNullOrEmpty(qc.getDynasty())) {
            if (!qc.getDynasty().equals(dynasty_)) {
                return false;
            }
        }
        
        if (StringUtil.isNullOrEmpty(qc.getKeyword())) {
            return false;
        }
        
        return findInSentence(qc.getKeyword(), results);
    }
    
    public String getAllSentences() {
        String allContent = "";
        for (String s : subSentences_) {
            if (!StringUtil.isNullOrEmpty(s)){
                allContent += s + "\r\n";
            }
        }
        
        return allContent;
    }
    
    public ArrayList<String> getAllSubSentences() {
        return subSentences_;
    }
    
    public String getSentence(int pos) {
        if ((pos < 0) || (pos >= subSentences_.size())) {
            return "";
        }
        
        return subSentences_.get(pos);
    }

    private void parseSentence() {
        String[] arr = content_.split("[【】：:，。？\r\n]");
        subSentences_.addAll(Arrays.asList(arr));        
    }
        
    private String originalId_;
    private Integer PoemId_;
    private Author author_;
    private String dynasty_;
    private String content_;
    private String desc_;
    private String Title_;
    ArrayList<String> subSentences_ = new ArrayList<>();
}
