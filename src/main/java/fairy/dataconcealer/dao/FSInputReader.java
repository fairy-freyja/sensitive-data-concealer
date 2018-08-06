package fairy.dataconcealer.dao;

import java.nio.file.Path;
import java.util.stream.Stream;

import static fairy.dataconcealer.Utils.readLines;

public class FSInputReader implements InputReader<String> {

    private Path path;

    public FSInputReader(Path path) {
        this.path = path;
    }

    @Override
    public Stream<String> read() {
        return readLines(path);
    }
}
