package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SimpleArray {
    final Logger logger = LogManager.getLogger();
    private int[] array;

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        if (array != null) {
            this.array = Arrays.copyOf(array, array.length);
        }
        else {
            logger.warn("Null pointer");
        }
    }

    public SimpleArray(int... array) {
        if (array != null) {
            this.array = Arrays.copyOf(array, array.length);
        }
        else {
            this.array = new int[0];
            logger.warn("Null pointer");
        }
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArray)) return false;
        SimpleArray that = (SimpleArray) o;
        if (that.getArray().length != this.getArray().length) return false;
        for (int i = 0; i < this.array.length; i++) {
            if(that.getArray()[i]!=this.getArray()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int HASH = 4;
        int result = 0;
        for(int number: array) {
            result+=number*HASH;
        }
        return result;
    }
}
