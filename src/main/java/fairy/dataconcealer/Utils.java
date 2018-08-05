package fairy.dataconcealer;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> readLines(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + path.toString(), e);
        }
    }

    public static Path findInClasspath(String filename) {
        URL url = Utils.class.getClassLoader().getResource(filename);
        if (url == null) {
            throw new RuntimeException(String.format("File %s not found", filename));
        }
        String absolutePath = url.getPath();
        return Paths.get(absolutePath);
    }

}
