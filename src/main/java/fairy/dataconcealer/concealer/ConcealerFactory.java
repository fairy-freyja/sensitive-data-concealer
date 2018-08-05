package fairy.dataconcealer.concealer;

import fairy.dataconcealer.dao.FSRegexRulesReader;
import fairy.dataconcealer.dao.RulesReader;

public class ConcealerFactory {

    public static Concealer<String> createRegExXConcealer(String rulePath, int numberOfX){
        RulesReader<String> rulesReader = new FSRegexRulesReader(rulePath);
        Encoder encoder = new XEncoder(numberOfX);
        return new RegExConcealer(rulesReader.getRules(), encoder);
    }

    public static Concealer<String> createRegExHashConcealer(String rulePath){
        RulesReader<String> rulesReader = new FSRegexRulesReader(rulePath);
        Encoder encoder = new HashEncoder();
        return new RegExConcealer(rulesReader.getRules(), encoder);
    }
}
