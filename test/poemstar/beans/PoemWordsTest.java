
package poemstar.beans;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xinway
 */
public class PoemWordsTest {
    
    public PoemWordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addWords method, of class PoemWords.
     */
    @Test
    public void testAddWords() {
        System.out.println("addWords");
        Collection<String> arr = null;
        PoemWords instance = new PoemWords();
        instance.addWords(arr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWord method, of class PoemWords.
     */
    @Test
    public void testAddWord() {
        System.out.println("addWord");
        PoemWords instance = new PoemWords();
        instance.addWord("明月");
        instance.addWord("愁心");

        String s = "我寄愁心与明月";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(2, instance.getMatchedCount());
    }
    
    /**
     * Test of addWord method, of class PoemWords.
     */
    @Test
    public void testAddWord2() {
        System.out.println("addWord2");
        PoemWords instance = new PoemWords();
        instance.addWord("稻花");
        instance.addWord("稻花香");
        instance.addWord("丰年");

        String s = "稻花香里说丰年";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(3, instance.getMatchedCount());
    }

    /**
     * Test of addWord method, of class PoemWords.
     */
    @Test
    public void testAddWord3() {
        System.out.println("addWord2");
        PoemWords instance = new PoemWords();
        instance.addWord("黄河");

        String s = "黄河入海流";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(1, instance.getMatchedCount());
        assertEquals("黄河-入-海-流", instance.getParsedSentence());
    }

    @Test
    public void testparseSentence4() {
        System.out.println("testparseSentence4");
        PoemWords instance = new PoemWords();
        instance.addWord("青山");
        instance.addWord("明月");
        instance.addWord("不曾");
        
        String s = "青山明月不曾空";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(3, instance.getMatchedCount());
        assertEquals("青山-明月-不曾-空", instance.getParsedSentence());
    }
    
    @Test
    public void testparseSentence5() {
        System.out.println("testparseSentence5");
        PoemWords instance = new PoemWords();
        instance.addWord("青山");
        instance.addWord("明月");

        String s = "身无彩凤双飞翼";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(0, instance.getMatchedCount());
        assertEquals("身-无-彩-凤-双-飞-翼", instance.getParsedSentence());
    }
    
    @Test
    public void testparseSentence6() {
        System.out.println("testparseSentence5");
        PoemWords instance = new PoemWords();
        instance.addWord("桃花");
        instance.addWord("依旧");
        instance.addWord("春风");

        String s = "桃花依旧笑春风";
        boolean res = instance.parseSentence(s);
        assertTrue(res);
        assertEquals(3, instance.getMatchedCount());
        assertEquals("桃花-依旧-笑-春风", instance.getParsedSentence());
    }
    
    @Test
    public void testLastChar() {
        String s = "abcdefg";
        String trimLast = s.substring(s.length() - 1);
        assertEquals(trimLast, "g");
    }
    
    @Test
    public void testParseSentence() {
        System.out.println("parseSentence");
        String s = "";
        PoemWords instance = new PoemWords();
        boolean expResult = false;
        boolean result = instance.parseSentence(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savetoFile method, of class PoemWords.
     */
    @Test
    public void testSavetoFile() {
        System.out.println("savetoFile");
        String filename = "";
        PoemWords instance = new PoemWords();
        instance.savetoFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}