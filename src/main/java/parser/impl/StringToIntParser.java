package parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.impl.IntegerValidator;

import java.util.ArrayList;
import java.util.List;

public class StringToIntParser implements parser.StringToIntParser {
    static final Logger logger = LogManager.getLogger();
    static final String LINE_SPLITTER = "[\\s, \\,]";

    public List<Integer> Parse(List<String> input) {
        if(input.size() == 0) {
            logger.warn("Zero elements in array");
            return new ArrayList<Integer>();
        }
        IntegerValidator validator = new IntegerValidator();
        ArrayList<Integer> output = new ArrayList<>(1);

        for(String line:input) {
            String[] splattedLine = line.split(LINE_SPLITTER);
            for(String elem: splattedLine) {
                if(validator.Validate(elem)) {
                    int stringValue = Integer.parseInt(elem);
                    output.add(stringValue);
                }
            }
        }
        return output;
    }
}
