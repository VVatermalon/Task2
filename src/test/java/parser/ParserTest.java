package parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.impl.StringToIntParserImpl;

import java.util.Arrays;
import java.util.List;

public class ParserTest extends Assert {
    final StringToIntParserImpl PARSER = new StringToIntParserImpl();

    @DataProvider
    public Object[][] ParserInput() {
        return new Object[][] {
                {new String[]{"10", "-00", "o10", "3j"}, new Integer[]{10, 0}},
                {new String[0], new Integer[0]},
        };
    }

    @Test(dataProvider = "ParserInput")
    public void ParsingTest(String[] input, Integer[] expected) {
        List<String> inputList = Arrays.asList(input);
        List<Integer> outputList = PARSER.Parse(inputList);
        Integer[] actual = outputList.toArray(new Integer[0]);
        assertEquals(actual, expected);
    }
}
