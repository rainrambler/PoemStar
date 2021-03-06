package poemstar.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import org.pmw.tinylog.Logger;

/**
 *
 * @author xinway
 */
public class WordMatcher {

    public void addWord(String wordStr) {
        if (wordStr.isEmpty()) {
            Logger.info("PoenWords.addWord: parameter is empty!");
            return;
        }
        allWords_.add(wordStr);
    }

    public void addWords(Collection<String> arr) {
        allWords_.addAll(arr);
    }

    public ArrayList<String> split2(String verse) {
        ArrayList<String> arr = new ArrayList<>();

        String partString = verse;
        while (partString.length() > 0) {
            if (partString.length() == 1) {
                // Can not matched
                arr.add(partString.substring(0, 1));
                partString = partString.substring(1);
                continue;
            }
            String firstPart = partString.substring(0, 2);
            
            if (allWords_.contains(firstPart)) {
                // Matched as a word
                String longerWord = findLongerWord(firstPart);

                if (!longerWord.equals(firstPart)) {
                    String resultWord = firstPart;
                    if (partString.startsWith(longerWord)) {
                        resultWord = longerWord; // Can match the longer word                        
                    } else {
                        // Not match the longer word
                    }

                    arr.add(resultWord);
                    partString = partString.substring(resultWord.length());
                }
                else {
                    arr.add(firstPart);
                    partString = partString.substring(firstPart.length());
                }
            }
            else {
                // Can not matched
                arr.add(partString.substring(0, 1));
                partString = partString.substring(1);
            }            
        }
        return arr;
    }

    public String findLongerWord(String oneWord) {
        if (word2Longer_.containsKey(oneWord)) {
            return word2Longer_.get(oneWord);
        } else {
            return oneWord;
        }
    }

    public void finishAddWord() {
        for (String s : allWords_) {
            for (String s2 : allWords_) {
                if (!s.equals(s2) && (s2.contains(s))) {
                    word2Longer_.put(s, s2);
                }
            }
        }
    }

    public boolean findWord(String s) {
        return allWords_.contains(s);
    }

    HashMap<String, String> word2Longer_ = new HashMap<>();
    HashSet<String> allWords_ = new HashSet<>();
}
