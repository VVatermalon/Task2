package service;

import entity.SimpleArray;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;

public interface SimpleArrayServices {
    OptionalInt FindMax(SimpleArray array);
    OptionalInt FindMaxStream(SimpleArray array);
    OptionalInt FindMin(SimpleArray array);
    OptionalInt FindMinStream(SimpleArray array);
    OptionalDouble FindAverage(SimpleArray array);
    OptionalDouble FindAverageStream(SimpleArray array);
    OptionalInt FindSum(SimpleArray array);
    OptionalInt FindSumStream(SimpleArray array);
    int FindNegativeCount(SimpleArray array);
    int FindNegativeCountStream(SimpleArray array);
    int FindPositiveCount(SimpleArray array);
    int FindPositiveCountStream(SimpleArray array);
    int[] ReplaceByCondition(SimpleArray array, IntUnaryOperator func);
}
