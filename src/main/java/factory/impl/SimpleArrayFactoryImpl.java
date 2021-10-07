package factory.impl;

import entity.SimpleArray;
import factory.SimpleFactory;

import java.util.List;

public class SimpleArrayFactoryImpl implements SimpleFactory {
    public SimpleArray GetSimpleArray(int... array) {
        return new SimpleArray(array);
    }

    public SimpleArray GetSimpleArray(List<Integer> array) {
        if(array!=null) {
            int size = array.size();
            int[] intArray = new int[size];
            for(int i = 0; i<size; i++) {
                intArray[i] = array.get(i);
            }
            return new SimpleArray(intArray);
        }
        else {
            return new SimpleArray();
        }
    }
}
