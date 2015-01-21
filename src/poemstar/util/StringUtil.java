
package poemstar.util;

/**
 *
 * @author Xinway
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String s) {
        if (s == null) {
            return true;
        }
        
        return s.length() == 0;
    }
}
