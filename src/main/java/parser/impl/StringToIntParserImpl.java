package parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.impl.IntegerValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class StringToIntParserImpl implements parser.StringToIntParser {
    static final Logger logger = LogManager.getLogger();
    static final String LINE_SPLITTER = "[\\s, \\,]";

    public List<Integer> parse(List<String> input) {
        if(input.size() == 0) {
            logger.warn("Zero elements in array");
            return new ArrayList<>();
        }
        IntegerValidatorImpl validator = new IntegerValidatorImpl();
        ArrayList<Integer> output = new ArrayList<>(1);

        for(String line:input) {
            String[] splattedLine = line.trim().split(LINE_SPLITTER);
            for(String elem: splattedLine) {
                if(validator.validate(elem)) {
                    int stringValue = Integer.parseInt(elem);
                    output.add(stringValue);
                }
            }
        }
        return output;
    }
}
