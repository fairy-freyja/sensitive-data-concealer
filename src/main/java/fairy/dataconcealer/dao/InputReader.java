package fairy.dataconcealer.dao;

import java.util.stream.Stream;

public interface InputReader<T> {

    Stream<T> read();
}
