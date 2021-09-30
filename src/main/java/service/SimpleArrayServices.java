package service;

import entity.SimpleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class SimpleArrayServices {
    final Logger logger = LogManager.getLogger();

    public double FindMax(SimpleArray array) throws IndexOutOfBoundsException {
        if(array.getArray().size()==0) {
            throw new IndexOutOfBoundsException();
        }
        double result = array.getArray().get(0);
        for(Double val: array.getArray()) {
            if(result<val) {
                result = val;
            }
        }
        return result;
    }

    public double FindAverage(SimpleArray array) throws IndexOutOfBoundsException {
        if(array.getArray().size()==0) {
            throw new IndexOutOfBoundsException();
        }
        int arrSize = array.getArray().size();
        double sum = 0;
        for (Double val : array.getArray()) {
            sum += val;
        }
        return sum / arrSize;
    }

    public double FindSum(SimpleArray array) throws IndexOutOfBoundsException {
        if(array.getArray().size()==0) {
            throw new IndexOutOfBoundsException();
        }
        double sum = 0;
        for (Double val : array.getArray()) {
            sum += val;
        }
        return sum;
    }

    public double FindNegativeCount(SimpleArray array) throws IndexOutOfBoundsException {
        if(array.getArray().size()==0) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        for (Double val : array.getArray()) {
            if(val<0) {
                count++;
            }
        }
        return count;
    }

    public void ReplaceByCondition(SimpleArray array, Function<Double, Double> func) {
        if (array.getArray().size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        List<Double> resultList = array.getArray().stream().map(func).collect(Collectors.toList());
        array.setArray((ArrayList<Double>) resultList);
    }
}
