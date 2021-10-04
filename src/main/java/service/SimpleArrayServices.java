package service;

import entity.SimpleArray;

import java.util.Optional;
import java.util.function.IntUnaryOperator;

public interface SimpleArrayServices {
    Optional<Integer> FindMax(SimpleArray array);
    Optional<Double> FindAverage(SimpleArray array);
    Optional<Integer> FindSum(SimpleArray array);
    Optional<Integer> FindNegativeCount(SimpleArray array);
    int[] ReplaceByCondition(SimpleArray array, IntUnaryOperator func);
}
