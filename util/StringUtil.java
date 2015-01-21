/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        if (s.length() == 0) {
            return true;
        }
        
        return false;
    }
}
