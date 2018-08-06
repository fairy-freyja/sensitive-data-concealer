package fairy.dataconcealer;

import fairy.dataconcealer.concealer.Concealer;
import fairy.dataconcealer.concealer.ConcealerFactory;
import fairy.dataconcealer.dao.*;

import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static fairy.dataconcealer.Utils.findInClasspath;

public class Main {
    public static void main(String[] args) {
//        String fileName =  args[0];
        String fileName = "testInput.txt";

        Path inputFilePath = findInClasspath(fileName);

        InputReader<String> reader = new FSInputReader(inputFilePath);

        Stream<String> inputData = reader.read();

        RulesReader<Pattern> rulesReader = new FSRegexRulesReader("regexpRules.txt");

        Concealer<String> concealer = ConcealerFactory.createRegExHashConcealer(rulesReader);
        Stream<String> outStream = inputData.map(concealer::conceal);

        Path outputPath = inputFilePath.getParent().resolveSibling("out.txt");
        OutputWriter<String> writer = new FSLinesOutputWriter(outputPath);

        writer.write(outStream);
    }
}
