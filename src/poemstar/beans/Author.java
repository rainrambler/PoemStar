package poemstar.beans;

/**
 *
 * @author Xinway
 */
public class Author {
    private int AuthorId_;
    private String AuthorName_;
    private String AuthorDesc_;
    private String Dynasty_;

    /**
     * @return the AuthorId_
     */
    public int getAuthorId() {
        return AuthorId_;
    }

    /**
     * @param AuthorId
     */
    public void setAuthorId(int AuthorId) {
        this.AuthorId_ = AuthorId;
    }

    /**
     * @return the AuthorName_
     */
    public String getAuthorName() {
        return AuthorName_;
    }

    /**
     * @param AuthorName
     */
    public void setAuthorName(String AuthorName) {
        this.AuthorName_ = AuthorName;
    }

    /**
     * @return the AuthorDesc_
     */
    public String getAuthorDesc() {
        return AuthorDesc_;
    }

    /**
     * @param AuthorDesc
     */
    public void setAuthorDesc(String AuthorDesc) {
        this.AuthorDesc_ = AuthorDesc;
    }
    
    public String getDynasty() {
        return Dynasty_;
    }
    
    public void setDynasty(String val) {
        this.Dynasty_ = val;
    }
}
