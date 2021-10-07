package service;

import entity.SimpleArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.SortingServicesImpl;

public class SortingTest extends Assert {
    final SortingServicesImpl SERVICES = new SortingServicesImpl();
    @DataProvider
    public Object[][] SortingInput() {
        return new Object[][] {
                {new SimpleArray(10, -100, -50, 501, 0, -2), new int[] {-100, -50, -2, 0, 10, 501}}
        };
    }

    @Test(dataProvider = "SortingInput")
    public void SelectionSortTest(SimpleArray array, int[] expected) {
        int[] actual = SERVICES.SelectionSort(array);
        assertEquals(actual, expected);
    }
}
