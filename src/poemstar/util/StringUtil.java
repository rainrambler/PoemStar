
package poemstar.util;

/**
 *
 * @author Xinway
 */
public class StringUtil {
    /**
     * Check string
     * @param s string to be checked
     * @return is null or empty
     */
    public static boolean isNullOrEmpty(String s) {
        if (s == null) {
            return true;
        }
        
        return s.length() == 0;
    }
}
