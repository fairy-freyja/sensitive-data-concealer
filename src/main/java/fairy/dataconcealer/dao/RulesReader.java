package fairy.dataconcealer.dao;

import java.util.List;

public interface RulesReader<T> {

    List<T> getRules();
}
