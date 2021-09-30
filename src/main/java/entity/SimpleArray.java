package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleArray {
    private ArrayList<Double> array;

    public ArrayList<Double> getArray() {
        return array;
    }

    public void setArray(ArrayList<Double> array) {
        this.array = array;
    }

    public SimpleArray() {
        array = new ArrayList<>(1);
    }

    public SimpleArray(List<Double> list) {
        array = new ArrayList<>(1);
        array = (ArrayList<Double>)list;
    }

    public SimpleArray(Double... numbers) {
        array = new ArrayList<>(numbers.length);
        for(Double number: numbers) {
            array.add(number);
        }
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "array=" + array +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArray)) return false;
        SimpleArray that = (SimpleArray) o;
        if (that.array.size() != array.size()) return false;
        for (int i = 0; i < array.size(); i++) {
            if(that.array.get(i)!=array.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int HASH = 4;
        int result = 0;
        for(Double number: array) {
            result+=number*HASH;
        }
        return result;
    }
}
