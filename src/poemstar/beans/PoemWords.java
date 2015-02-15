package poemstar.beans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pmw.tinylog.Logger;
import poemstar.algorithm.WordMatcher;
import poemstar.fileio.SplitResultWriter;

/**
 * All words founded in Chinese poems
 *
 * @author xinway
 */
public class PoemWords {

    public void addWords(Collection<String> arr) {
        matcher_.addWords(arr);
        matcher_.finishAddWord();
    }

    public void addWord(String wordStr) {
        matcher_.addWord(wordStr);
    }
    
    public void finishAddWord() {
        matcher_.finishAddWord();
    }

    private void addMatchedWord(String wordStr) {
        if (wordStr.isEmpty()) {
            Logger.warn("PoenWords.addMatchedWord: parameter is empty!");
            return;
        }
        
        if (matchedWords.containsKey(wordStr)) {
            Integer count = matchedWords.get(wordStr);
            count++;
            matchedWords.put(wordStr, count);
        }
        else {
            matchedWords.put(wordStr, 1);
        }
    }

    private void addMatchedWord(String verse, String wordStr) {
        if (wordStr.isEmpty()) {
            Logger.warn("PoenWords.addMatchedWord2: parameter is empty!");
            return;
        }
        
        addWordtoVerse(verse, wordStr);
        
        if (matchedWords.containsKey(wordStr)) {
            Integer count = matchedWords.get(wordStr);
            count++;
            matchedWords.put(wordStr, count);
        }
        else {
            matchedWords.put(wordStr, 1);
        }
    }
    
    private void addWordtoVerse(String verse, String wordStr) {
        if (wordStr.isEmpty() || verse.isEmpty()) {
            Logger.warn("PoenWords.addWordtoVerse: parameter is empty!");
            return;
        }
        
        if (matchedVerses.containsKey(wordStr)) {
            Verses v = matchedVerses.get(wordStr);
            v.addVerse(verse);
        }
        else {
            Verses v = new Verses();
            matchedVerses.put(wordStr, v);
        }
    }
    
    /**
     * Find a word in the collection
     * @param s word to find
     * @return true if founded
     */
    public boolean findWord(String s) {
        return matcher_.findWord(s);
    }

    /**
     * Parse a sentence of a poem
     * @param s a sentence of a poem
     * @return Parse success or failed
     */
    public boolean parseSentence2(String s) {
        if ((s == null) || (s.isEmpty())) {
            Logger.warn("PoenWords.parseSentence: parameter is empty!");
            return false;
        }
        
        parseResult = "";
        
        ArrayList<String> allChildren = matcher_.split2(s);
        for (String oneWord : allChildren) {
            parseResult += oneWord + "-";
            
            if (oneWord.length() >  1) {
                addMatchedWord(s, oneWord);
            }
        }
        
        if (parseResult.length() > 0) {
            parseResult = parseResult.substring(0, parseResult.length() - 1); // Remove last - 
        }
        logParsedSentence();        
        return true;
    }
    
    public String getParsedSentence() {
        return parseResult;
    }
    
    public void addPoemDelimeter() {
        writer_.addSentence("----------");
    }
    
    private void logParsedSentence() {
        if (parseResult.length() <= 1) {
            return;
        }
        writer_.addSentence(parseResult);
        
        int count = StringUtils.countMatches(parseResult, "-");
        if (count >= (parseResult.length() / 2)) {
            // Char '-' existed too much, means the sentense is not parsed correctly
            //parseResult = parseResult.substring(0, parseResult.length() - 1); // Remove last - 
            writer_.addUnmatchedSentence(parseResult);
        }
        else {
            
        }
    }

    /**
     * Save matched results (word to count) to file
     * @param filename File name to save
     */
    public void savetoFile(String filename) {
        if (matchedWords.isEmpty()) {
            return;
        }

        try {
            ArrayList<String> lines = new ArrayList<>();
            File f = new File(filename);
            for (String key : matchedWords.keySet()) {
                String line = key + ":" + matchedWords.get(key);
                lines.add(line);
            }
            FileUtils.writeLines(f, lines);
        } catch (IOException ex) {
            Logger.error(ex);
        }
    }
    
    /**
     * Save matched words to file
     * @param filename File name to save
     */
    public void saveWordstoFile(String filename) {
        if (matchedWords.isEmpty()) {
            return;
        }

        try {
            ArrayList<String> lines = new ArrayList<>();
            File f = new File(filename);
            for (String key : matchedWords.keySet()) {
                lines.add(key);
            }
            FileUtils.writeLines(f, lines);
        } catch (IOException ex) {
            Logger.error(ex);
        }
    }
    
    /**
     * Save word to verses to file
     * @param filename File name to save
     */
    public void saveVersestoFile(String filename) {
        if (matchedVerses.isEmpty()) {
            return;
        }

        try {
            ArrayList<String> lines = new ArrayList<>();
            File f = new File(filename);
            for (String key : matchedVerses.keySet()) {
                lines.add("---------------------");
                lines.add(key + ":");
                
                Verses v = matchedVerses.get(key);
                int count = v.getCount();
                for (int i = 0; i < count; i++) {
                    lines.add(v.getAt(i));
                }
            }
            FileUtils.writeLines(f, lines);
        } catch (IOException ex) {
            Logger.error(ex);
        }
    }
    
    public void saveSplitResults() {
        writer_.writeLogFiles();
    }
    
    /**
     * Get all matched count
     * @return All matched count 
     */
    public int getMatchedCount() {
        return matchedWords.size();
    }
    
    HashMap<String, Verses> matchedVerses = new HashMap<>();
    
    HashMap<String, Integer> matchedWords = new HashMap<>();
    String parseResult = "";
    
    SplitResultWriter writer_ = new SplitResultWriter();
    WordMatcher matcher_ = new WordMatcher();
}
