package fairy.dataconcealer.dao;

import org.junit.Assert;
import org.junit.Test;

public class FSRegexRulesReaderTest {

    private static final String testFileName = "regexpRules.txt";

    @Test
    public void testGetRules() {
        FSRegexRulesReader reader = new FSRegexRulesReader(testFileName);
        String readedRule = reader.getRules().get(0).toString();
        String expectedPattern = "\\d*";
        Assert.assertEquals(expectedPattern, readedRule);
    }

    @Test(expected = RuntimeException.class)
    public void testNoFile() {
        FSRegexRulesReader reader = new FSRegexRulesReader("noSuchFile.txt");
        reader.getRules();
    }
}
