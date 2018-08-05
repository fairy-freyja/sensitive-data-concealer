package fairy.dataconcealer.dao;

import fairy.dataconcealer.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FSInputReaderTest {

    private static final String testFileName = "testInputFile.txt";
    private static final String[] testData = {"123456",
            "qwerty",
            "ololo",
            "pew-pew@gmail.com",
            "pewpew@fairy.com"};

    @Test
    public void testRead(){
        FSInputReader reader = new FSInputReader();
        String[] results = reader.read(Utils.findInClasspath(testFileName)).collect(Collectors.toList()).toArray(new String[0]);
        Assert.assertArrayEquals(testData, results);
    }

    @Test(expected = RuntimeException.class)
    public void testNoFile(){
        FSInputReader reader = new FSInputReader();
        reader.read(Utils.findInClasspath("noSuchFile.txt"));
    }

}
