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

        String fileType = null;
        if (fileType == null) {
            fileType = checkFileType(fileName);
        }

        Path inputFilePath = findInClasspath(fileName);

        InputReader<String> reader = new FSInputReader(inputFilePath);

        System.out.println(inputFilePath.toString());
        System.out.println(inputFilePath.getParent().toString());
        Path outputPath = inputFilePath.getParent().resolveSibling("out.txt");
        OutputWriter<String> writer = new FSLinesOutputWriter(outputPath);

        Stream<String> inputData = reader.read();

        Concealer<String> concealer = ConcealerFactory.createRegExHashConcealer("regexpRules.txt");
        Stream<String> outStream = inputData.map(concealer::conceal);

        writer.write(outStream);
//        System.out.println(String.join("\n", outStream.collect(toList())));

    }

    private static String checkFileType(String fileName) {
        String[] pew = fileName.split("\\.");
        return pew[pew.length - 1];
    }
}
