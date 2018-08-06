package fairy.dataconcealer.dao;

import fairy.dataconcealer.Utils;

import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class FSRegexRulesReader implements RulesReader<Pattern> {
    private Path path;

    public FSRegexRulesReader(String filename) {
        this.path = Utils.findInClasspath(filename);
    }

    @Override
    public List<Pattern> getRules() {
        return Utils.readLines(path).map(Pattern::compile).collect(toList());
    }
}
