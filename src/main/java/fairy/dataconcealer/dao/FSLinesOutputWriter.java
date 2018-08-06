package fairy.dataconcealer.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FSLinesOutputWriter implements OutputWriter<String> {

    private Path path;

    public FSLinesOutputWriter(Path path) {
        this.path = path;
    }

    @Override
    public void write(Stream<String> output) {
        try {
            Files.write(path, (Iterable<String>) output::iterator);
        } catch (IOException e) {
            throw new RuntimeException("Failed write to file " + path.toString(), e);
        }
    }
}
