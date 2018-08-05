package fairy.dataconcealer.dao;

import java.nio.file.Path;
import java.util.stream.Stream;

public class FSLinesOutputWriter implements OutputWriter<String> {

    private Path path;

    public FSLinesOutputWriter(Path path) {
        this.path = path;
    }

    @Override
    public void write(Stream<String> output) {

    }
}
