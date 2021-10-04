package factory;

import entity.SimpleArray;

import java.util.List;

public interface SimpleFactory {
    public SimpleArray GetSimpleArray(int... array);
    SimpleArray GetSimpleArray(List<Integer> array);
}
