package fairy.dataconcealer.dao;

import java.util.stream.Stream;

public interface OutputWriter<T> {

    void write(Stream<T> output);

}
