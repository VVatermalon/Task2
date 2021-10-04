package service.impl;

import entity.SimpleArray;
import exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleArrayServices implements service.SimpleArrayServices {
    final Logger logger = LogManager.getLogger();

    public Optional<Integer> FindMax(SimpleArray array) {
        if (array.getArray().length == 0) {
            logger.warn("Zero elements in array");
            return Optional.empty();
        }
        int result = array.getArray()[0];
        for (int val : array.getArray()) {
            if (result < val) {
                result = val;
            }
        }
        return Optional.of(result);
    }

    public Optional<Double> FindAverage(SimpleArray array) {
        if (array.getArray().length == 0) {
            logger.warn("Zero elements in array");
            return Optional.empty();
        }
        double arrayLength = array.getArray().length;
        int sum = 0;
        for (int val : array.getArray()) {
            sum += val;
        }
        return Optional.of(sum / arrayLength);
    }

    public Optional<Integer> FindSum(SimpleArray array) {
        if (array.getArray().length == 0) {
            logger.warn("Zero elements in array");
            return Optional.empty();
        }
        int sum = 0;
        for (int val : array.getArray()) {
            sum += val;
        }
        return Optional.of(sum);
    }

    public Optional<Integer> FindNegativeCount(SimpleArray array) {
        if (array.getArray().length == 0) {
            logger.warn("Zero elements in array");
            return Optional.empty();
        }
        int count = 0;
        for (int val : array.getArray()) {
            if (val < 0) {
                count++;
            }
        }
        return Optional.of(count);
    }

    public int[] ReplaceByCondition(SimpleArray array, IntUnaryOperator func) {
        if (array.getArray().length == 0) {
            logger.warn("Zero elements in array");
            return new int[0];
        }
        IntStream stream = Arrays.stream(array.getArray());
        int[] result = stream.map(func).toArray();
        return result;
    }
}
