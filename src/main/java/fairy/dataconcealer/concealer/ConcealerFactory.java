package fairy.dataconcealer.concealer;

import fairy.dataconcealer.dao.RulesReader;

import java.util.regex.Pattern;

public class ConcealerFactory {

    public static Concealer<String> createRegExXConcealer(RulesReader<Pattern> rulesReader, int numberOfX) {
        Encoder encoder = new XEncoder(numberOfX);
        return new RegExConcealer(rulesReader.getRules(), encoder);
    }

    public static Concealer<String> createRegExHashConcealer(RulesReader<Pattern> rulesReader) {
        Encoder encoder = new HashEncoder();
        return new RegExConcealer(rulesReader.getRules(), encoder);
    }
}
