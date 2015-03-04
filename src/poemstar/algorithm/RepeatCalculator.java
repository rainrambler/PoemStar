package poemstar.algorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;
import poemstar.beans.ChineseWords;
import poemstar.beans.PoemWords;

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

    /**
     * Save the automatic splitted words
     * @param filename
     * @param pw 
     */
    public void saveFile(String filename, PoemWords pw) {
        HashSet<Integer> repeatTimes = new HashSet<>();
        HashMap<Integer, ChineseWords> times2Words = new HashMap<>();
        
        for (String w : word2Count.keySet()) {
            Integer count = word2Count.get(w);                       

            if ((count > 1) && !pw.findWord(w)) {
                // Not found in the word collection
                if (!repeatTimes.contains(count)) {
                    repeatTimes.add(count);
                }
                if (times2Words.containsKey(count)) {
                    times2Words.get(count).add(w);
                }
                else {
                    ChineseWords cw = new ChineseWords();
                    cw.add(w);
                    times2Words.put(count, cw);
                }
            }
        }
        
        
        ArrayList<Integer> sortedTimes = new ArrayList<>(repeatTimes);
        Collections.sort(sortedTimes);
        Collections.reverse(sortedTimes);
        
        ArrayList<String> lines = new ArrayList<>();
        for (Integer times : sortedTimes) {
            ChineseWords cw = times2Words.get(times);
            
            if (cw != null) {
                Integer wordscount = cw.getSize();
                for (int i = 0; i < wordscount; i++) {
                    String line = cw.getAt(i) + ":" + times.toString();
                    lines.add(line);
                }
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
