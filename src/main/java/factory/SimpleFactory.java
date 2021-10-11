package factory;

import entity.SimpleArray;

import java.util.List;

public interface SimpleFactory {
    SimpleArray createSimpleArray(int... array);
    SimpleArray createSimpleArray(List<Integer> array);
}
