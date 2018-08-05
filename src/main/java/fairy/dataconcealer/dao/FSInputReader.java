package fairy.dataconcealer.dao;

import java.nio.file.Path;
import java.util.stream.Stream;

import static fairy.dataconcealer.Utils.findInClasspath;
import static fairy.dataconcealer.Utils.readLines;

public class FSInputReader implements InputReader<String> {


    @Override
    public Stream<String> read(Path path) {
        return readLines(path);
    }
}
