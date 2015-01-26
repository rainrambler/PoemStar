
package poemstar.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author xinway
 */
public class DateTimeUtils {
    public static String getTimeDesc() {
        Date d = Calendar.getInstance().getTime();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String s = formatter.format(d);
        return s;
    }
}
