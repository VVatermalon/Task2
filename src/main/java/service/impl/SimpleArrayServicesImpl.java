package service.impl;

import entity.SimpleArray;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.*;
import java.util.stream.IntStream;

public class SimpleArrayServicesImpl implements service.SimpleArrayServices {

    public OptionalInt FindMax(SimpleArray array) {
        if (array.getArray().length == 0) {
            return OptionalInt.empty();
        }
        int result = array.getArray()[0];
        for (int val : array.getArray()) {
            if (result < val) {
                result = val;
            }
        }
        return OptionalInt.of(result);
    }

    public OptionalInt FindMaxStream(SimpleArray array) {
        return Arrays.stream(array.getArray()).max();
    }

    public OptionalInt FindMin(SimpleArray array) {
        if (array.getArray().length == 0) {
            return OptionalInt.empty();
        }
        int result = array.getArray()[0];
        for (int val : array.getArray()) {
            if (result > val) {
                result = val;
            }
        }
        return OptionalInt.of(result);
    }

    public OptionalInt FindMinStream(SimpleArray array) {
        return Arrays.stream(array.getArray()).min();
    }

    public OptionalDouble FindAverage(SimpleArray array) {
        if (array.getArray().length == 0) {
            return OptionalDouble.empty();
        }
        double arrayLength = array.getArray().length;
        int sum = 0;
        for (int val : array.getArray()) {
            sum += val;
        }
        return OptionalDouble.of(sum / arrayLength);
    }

    public OptionalDouble FindAverageStream(SimpleArray array) {
        return Arrays.stream(array.getArray()).average();
    }

    public OptionalInt FindSum(SimpleArray array) {
        if (array.getArray().length == 0) {
            return OptionalInt.empty();
        }
        int sum = 0;
        for (int val : array.getArray()) {
            sum += val;
        }
        return OptionalInt.of(sum);
    }

    public OptionalInt FindSumStream(SimpleArray array) {
        if (array.getArray().length == 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(Arrays.stream(array.getArray()).sum());
    }

    public int FindNegativeCount(SimpleArray array) {
        int count = 0;
        for (int val : array.getArray()) {
            if (val < 0) {
                count++;
            }
        }
        return count;
    }

    public int FindNegativeCountStream(SimpleArray array) {
        return (int) Arrays.stream(array.getArray()).filter(i -> i < 0).count();
    }

    public int FindPositiveCount(SimpleArray array) {
        int count = 0;
        for (int val : array.getArray()) {
            if (val > 0) {
                count++;
            }
        }
        return count;
    }

    public int FindPositiveCountStream(SimpleArray array) {
        return (int) Arrays.stream(array.getArray()).filter(i -> i > 0).count();
    }

    public int[] ReplaceByCondition(SimpleArray array, IntUnaryOperator func) {
        if (array.getArray().length == 0) {
            return new int[0];
        }
        IntStream stream = Arrays.stream(array.getArray());
        int[] result = stream.map(func).toArray();
        return result;
    }
}
