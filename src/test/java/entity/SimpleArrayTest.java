package entity;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SimpleArrayTest extends Assert {
    final int[] INPUT_ARRAY = new int[]{-10, 15, 20};

    @Test()
    public void constructorTest() {
        SimpleArray simpleArray = new SimpleArray(INPUT_ARRAY);
        assertTrue(Arrays.equals(simpleArray.getArray(), INPUT_ARRAY));
    }

    @Test
    public void differentObjectsTest() {
        SimpleArray simpleArray = new SimpleArray(INPUT_ARRAY);
        assertFalse(simpleArray.getArray().equals(INPUT_ARRAY));
    }
}
