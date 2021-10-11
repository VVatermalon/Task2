package service;

import entity.SimpleArray;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;

public interface SimpleArrayServices {
    OptionalInt findMax(SimpleArray array);
    OptionalInt findMaxStream(SimpleArray array);
    OptionalInt findMin(SimpleArray array);
    OptionalInt findMinStream(SimpleArray array);
    OptionalDouble findAverage(SimpleArray array);
    OptionalDouble findAverageStream(SimpleArray array);
    OptionalInt findSum(SimpleArray array);
    OptionalInt findSumStream(SimpleArray array);
    int findNegativeCount(SimpleArray array);
    int findNegativeCountStream(SimpleArray array);
    int findPositiveCount(SimpleArray array);
    int findPositiveCountStream(SimpleArray array);
    int[] replaceByCondition(SimpleArray array, IntUnaryOperator func);
}
