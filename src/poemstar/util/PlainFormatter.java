
package poemstar.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author xinway
 */
public class PlainFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return millisToTime(record.getMillis()) + ": " + record.getLevel() + ":" + record.getMessage()+"\r\n" ; 
    }    
    
    public static String millisToTime(long millis) {
        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(millis));
    }
}
