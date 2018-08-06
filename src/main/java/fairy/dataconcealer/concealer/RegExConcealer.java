package fairy.dataconcealer.concealer;

import java.util.List;
import java.util.regex.Pattern;

class RegExConcealer implements Concealer<String> {

    private List<Pattern> rules;
    private Encoder encoder;

    RegExConcealer(List<Pattern> rules, Encoder encoder) {
        this.rules = rules;
        this.encoder = encoder;
    }

    @Override
    public String conceal(String objectToConceal) {
        for (Pattern rule : rules) {
            if (rule.matcher(objectToConceal).matches()) {
                // TODO: only replace the matching part of expression
                return encoder.encode(objectToConceal);
            }
        }
        return objectToConceal;
    }
}
