package main;

import entity.SimpleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.SimpleArrayServices;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SimpleArray arr = new SimpleArray(3., 54.5, 35., -4.);
        SimpleArrayServices services = new SimpleArrayServices();
        Function<Double, Double> testFunction = d -> {
            if (d < 0) {
                return -d;
            }
            return d * 0.5;
        };
        services.ReplaceByCondition(arr, testFunction);
        logger.info(arr.toString());
    }
}