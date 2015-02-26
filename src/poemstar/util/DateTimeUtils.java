
package poemstar.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date and time utilities
 * @author xinway
 */
public class DateTimeUtils {
    /**
     * Get string description of current time
     * @return String description of current time
     */
    public static String getTimeDesc() {
        Date d = Calendar.getInstance().getTime();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String s = formatter.format(d);
        return s;
    }
}
