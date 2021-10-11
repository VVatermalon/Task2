package reader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reader.impl.CustomReaderImpl;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ReaderTest {

    @DataProvider
    public Object[][] readerInput() {
        return new Object[][]{
                {"dataTest.txt", new String[]{"-15 16 27 р43   76 101", "2о -1 0 0 4"}},
                {"emptyTest.txt", new String[0]},
                {"emptyyyyTest.txt", new String[0]},
                {null , new String[0]}
        };
    }

    @Test(dataProvider = "readerInput")
    public void readFromFileTest(String src, String[] expectedArray) {
        CustomReaderImpl reader = new CustomReaderImpl();
        List<String> actual = reader.readFromFile(src);
        List<String> expected = Arrays.asList(expectedArray);
        assertEquals(actual, expected);
    }
}