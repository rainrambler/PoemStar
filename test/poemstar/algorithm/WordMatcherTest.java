
package poemstar.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xinway
 */
public class WordMatcherTest {
    
    public WordMatcherTest() {
    }

    /**
     * Test of split method, of class WordMatcher.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        String verse = "稻花香里说丰年";
        WordMatcher instance = new WordMatcher();
        instance.addWord("稻花");
        instance.addWord("稻花香");
        instance.addWord("丰年");
        instance.finishAddWord();
        
        ArrayList<String> result = instance.split2(verse);
        assertEquals("稻花香", result.get(0));
        assertEquals("里", result.get(1));
        assertEquals("说", result.get(2));
        assertEquals("丰年", result.get(3));
    }

    /**
     * Test of findLongerWord method, of class WordMatcher.
     */
    @Test
    public void testFindLongerWord() {
        System.out.println("findLongerWord");
        String oneWord = "";
        WordMatcher instance = new WordMatcher();
        String expResult = "";
        String result = instance.findLongerWord(oneWord);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
