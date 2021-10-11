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
    public Object[][] parserInput() {
        return new Object[][] {
                {new String[]{"10", "-00", "o10", "3j"}, new Integer[]{10, 0}},
                {new String[0], new Integer[0]},
        };
    }

    @Test(dataProvider = "parserInput")
    public void parsingTest(String[] input, Integer[] expected) {
        List<String> inputList = Arrays.asList(input);
        List<Integer> outputList = PARSER.parse(inputList);
        Integer[] actual = outputList.toArray(new Integer[0]);
        assertEquals(actual, expected);
    }
}
