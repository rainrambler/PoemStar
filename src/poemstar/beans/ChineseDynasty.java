package poemstar.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Xinway
 */
public enum ChineseDynasty {
    INSTANCE;
    
    public final String ALLDYNASTY = "先秦|汉|魏晋|南北朝|隋|唐|宋|辽|金|元|明|清|近现代|不详";
    
    public List<String> getAll() {
        String[] arr = ALLDYNASTY.split("\\|");
        List<String> allDynasty = new ArrayList<>();        
        allDynasty.addAll(Arrays.asList(arr));
        
        return allDynasty;
    }
    
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
}
