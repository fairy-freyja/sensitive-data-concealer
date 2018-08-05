package fairy.dataconcealer.dao;

import fairy.dataconcealer.Utils;

import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FSRegexRulesReader implements RulesReader<String> {
    private Path path;

    public FSRegexRulesReader(String filename) {
        this.path = Utils.findInClasspath(filename);
    }

    @Override
    public List<String> getRules() {
        return Utils.readLines(path).collect(toList());
    }
}
