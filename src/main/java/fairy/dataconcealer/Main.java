package fairy.dataconcealer;

import fairy.dataconcealer.concealer.Concealer;
import fairy.dataconcealer.concealer.ConcealerFactory;
import fairy.dataconcealer.dao.FSInputReader;
import fairy.dataconcealer.dao.FSLinesOutputWriter;
import fairy.dataconcealer.dao.InputReader;
import fairy.dataconcealer.dao.OutputWriter;

import java.nio.file.Path;
import java.util.stream.Stream;

import static fairy.dataconcealer.Utils.findInClasspath;

public class Main {
    public static void main(String[] args) {
//        String fileName =  args[0];
        String fileName = "testInput.txt";

        Path inputFilePath = findInClasspath(fileName);

        InputReader<String> reader = new FSInputReader(inputFilePath);

        Stream<String> inputData = reader.read();

        Concealer<String> concealer = ConcealerFactory.createRegExHashConcealer("regexpRules.txt");
        Stream<String> outStream = inputData.map(concealer::conceal);

        Path outputPath = inputFilePath.getParent().resolveSibling("out.txt");
        OutputWriter<String> writer = new FSLinesOutputWriter(outputPath);

        writer.write(outStream);
    }
}
