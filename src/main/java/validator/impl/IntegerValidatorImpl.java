package validator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidatorImpl implements validator.IntegerValidator {
    static final String REGEX_INTEGER = "^([+-]?\\d+)$";

    public boolean validate(String input) {
        Pattern pattern = Pattern.compile(REGEX_INTEGER);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
