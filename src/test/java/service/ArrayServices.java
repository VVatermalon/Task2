package service;

import entity.SimpleArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.SimpleArrayServicesImpl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServices extends Assert {
    final SimpleArrayServicesImpl SERVICES = new SimpleArrayServicesImpl();
    @DataProvider
    public Object[][] maxInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), OptionalInt.of(501)},
                {new SimpleArray(), OptionalInt.empty()}
        };
    }
    @DataProvider
    public Object[][] averageInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), OptionalDouble.of(59.833333333333336)},
                {new SimpleArray(), OptionalDouble.empty()}
        };
    }
    @DataProvider
    public Object[][] negativeInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), 3},
                {new SimpleArray(), 0}
        };
    }

    @Test(dataProvider = "maxInput")
    public void findMaxTest(SimpleArray array, OptionalInt expected) {
        OptionalInt actual = SERVICES.findMax(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxInput")
    public void findMaxStreamTest(SimpleArray array, OptionalInt expected) {
        OptionalInt actual = SERVICES.findMaxStream(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "averageInput")
    public void findAverageTest(SimpleArray array, OptionalDouble expected) {
        OptionalDouble actual = SERVICES.findAverage(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "averageInput")
    public void findAverageBothTest(SimpleArray array, OptionalDouble expected) {
        OptionalDouble actual = SERVICES.findAverage(array);
        OptionalDouble actualStream = SERVICES.findAverageStream(array);
        assertEquals(actual, actualStream);
    }

    @Test(dataProvider = "negativeInput")
    public void findNegativeTest(SimpleArray array, int expected) {
        int actual = SERVICES.findNegativeCount(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "negativeInput")
    public void findNegativeBothTest(SimpleArray array, int expected) {
        int actual = SERVICES.findNegativeCount(array);
        int actualStream = SERVICES.findNegativeCountStream(array);
        assertEquals(actual, actualStream);
    }
}
