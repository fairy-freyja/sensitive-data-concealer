package fairy.dataconcealer.dao;

import fairy.dataconcealer.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FSLinesOutputWriterTest {
    private static final String testFileName = "testOutFile.txt";
    private static final String[] testData = {"123456",
            "qwerty"};

    @Test
    public void testWrite(){
        FSLinesOutputWriter writer = new FSLinesOutputWriter(Utils.findInClasspath(testFileName));
        Stream<String> outStream = Stream.of(testData);
        writer.write(outStream);

        FSInputReader reader = new FSInputReader(Utils.findInClasspath(testFileName));
        String[] results = reader.read().collect(Collectors.toList()).toArray(new String[0]);
        Assert.assertArrayEquals(testData, results);
    }

}
