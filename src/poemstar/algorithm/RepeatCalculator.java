package poemstar.algorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;

/**
 *
 * @author xinway
 */
public class RepeatCalculator {

    public void addSentence(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            String twochar = s.substring(i, i + 2);

            if (word2Count.containsKey(twochar)) {
                word2Count.put(twochar, word2Count.get(twochar) + 1);
            } else {
                word2Count.put(twochar, 1);
            }
        }
    }

    public void saveFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();

        for (String w : word2Count.keySet()) {
            Integer count = word2Count.get(w);

            if (count > 1) {
                String line = w + ":" + count.toString();

                lines.add(line);
            }
        }

        try {
            File resultfile = new File(filename);
            FileUtils.writeLines(resultfile, lines);
        } catch (IOException ex) {
            Logger.warn(ex);
        }
    }

    HashMap<String, Integer> word2Count = new HashMap<>();
}
