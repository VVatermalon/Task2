package service;

import entity.SimpleArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.SimpleArrayServices;

import java.util.Optional;

public class ArrayServices extends Assert {
    final SimpleArrayServices SERVICES = new SimpleArrayServices();
    @DataProvider
    public Object[][] ServiceInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), Optional.of(501)},
                {new SimpleArray(), Optional.empty()}
        };
    }

    @Test(dataProvider = "ServiceInput")
    public void FindMaxTest(SimpleArray array, Optional<Integer> expected) {
        Optional<Integer> actual = SERVICES.FindMax(array);
        assertEquals(actual, expected);
    }
}
