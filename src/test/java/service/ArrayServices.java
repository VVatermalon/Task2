package service;

import entity.SimpleArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.SimpleArrayServicesImpl;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServices extends Assert {
    final SimpleArrayServicesImpl SERVICES = new SimpleArrayServicesImpl();
    @DataProvider
    public Object[][] MaxInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), OptionalInt.of(501)},
                {new SimpleArray(), OptionalInt.empty()}
        };
    }
    @DataProvider
    public Object[][] AverageInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), OptionalDouble.of(59.833333333333336)},
                {new SimpleArray(), OptionalDouble.empty()}
        };
    }
    @DataProvider
    public Object[][] NegativeInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), 3},
                {new SimpleArray(), 0}
        };
    }

    @Test(dataProvider = "MaxInput")
    public void FindMaxTest(SimpleArray array, OptionalInt expected) {
        OptionalInt actual = SERVICES.FindMax(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "MaxInput")
    public void FindMaxStreamTest(SimpleArray array, OptionalInt expected) {
        OptionalInt actual = SERVICES.FindMaxStream(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "AverageInput")
    public void FindAverageTest(SimpleArray array, OptionalDouble expected) {
        OptionalDouble actual = SERVICES.FindAverage(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "AverageInput")
    public void FindAverageBothTest(SimpleArray array, OptionalDouble expected) {
        OptionalDouble actual = SERVICES.FindAverage(array);
        OptionalDouble actualStream = SERVICES.FindAverageStream(array);
        assertEquals(actual, actualStream);
    }

    @Test(dataProvider = "NegativeInput")
    public void FindNegativeTest(SimpleArray array, int expected) {
        int actual = SERVICES.FindNegativeCount(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "NegativeInput")
    public void FindNegativeBothTest(SimpleArray array, int expected) {
        int actual = SERVICES.FindNegativeCount(array);
        int actualStream = SERVICES.FindNegativeCountStream(array);
        assertEquals(actual, actualStream);
    }
}
