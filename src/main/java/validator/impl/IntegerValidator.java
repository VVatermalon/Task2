package validator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidator implements validator.IntegerValidator {
    final static String REGEX_INTEGER = "^([+-]?\\d+)$";

    public boolean Validate(String input) {
        Pattern pattern = Pattern.compile(REGEX_INTEGER);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
