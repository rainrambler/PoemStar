package poemstar.beans;

import java.util.HashMap;

/**
 *
 * @author Xinway
 */
public class ChineseDynasty {

    public final String Dynasty_Xianqin = "先秦";
    public final String Dynasty_Han = "汉";
    public final String Dynasty_Weijin = "魏晋";
    public final String Dynasty_Nanbei = "南北朝";
    public final String Dynasty_Sui = "隋";
    public final String Dynasty_Tang = "唐";
    public final String Dynasty_Song = "宋";
    public final String Dynasty_Liao = "辽";
    public final String Dynasty_Jin = "金";
    public final String Dynasty_Yuan = "元";
    public final String Dynasty_Ming = "明";
    public final String Dynasty_Qing = "清";
    public final String Dynasty_XianDangDai = "近现代";
    public final String Dynasty_Unknown = "不详";

    private ChineseDynasty() {
        int pos = 1;
        Dynasties_.put(pos, Dynasty_Xianqin);
        pos++;
        Dynasties_.put(pos, Dynasty_Han);
        pos++;
        Dynasties_.put(pos, Dynasty_Weijin);
        pos++;
        Dynasties_.put(pos, Dynasty_Nanbei);
        pos++;
        Dynasties_.put(pos, Dynasty_Sui);
        pos++;
        Dynasties_.put(pos, Dynasty_Tang);
        pos++;
        Dynasties_.put(pos, Dynasty_Song);
        pos++;
        Dynasties_.put(pos, Dynasty_Liao);
        pos++;
        Dynasties_.put(pos, Dynasty_Jin);
        pos++;
        Dynasties_.put(pos, Dynasty_Yuan);
        pos++;
        Dynasties_.put(pos, Dynasty_Ming);
        pos++;
        Dynasties_.put(pos, Dynasty_Qing);
        pos++;
        Dynasties_.put(pos, Dynasty_XianDangDai);
        pos++;
        Dynasties_.put(pos, Dynasty_Unknown);
        pos++;
    }

    private static class LazyHolder {

        private static final ChineseDynasty INSTANCE = new ChineseDynasty();
    }

    public static ChineseDynasty getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    public String findDynastyById(Integer id) {
        if (!Dynasties_.containsKey(id)) {
            return Dynasty_Unknown;
        }
        
        return Dynasties_.get(id);
    }
    
    HashMap<Integer, String> Dynasties_ = new HashMap<Integer, String>();
}
