package main;

import entity.SimpleArray;
import factory.impl.SimpleArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.impl.StringToIntParser;
import reader.impl.CustomReader;
import service.SortingServices;
import service.impl.SimpleArrayServices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntUnaryOperator;

public class Main {
    static final Logger logger = LogManager.getLogger();
    static final String FILE_SRC = "src\\main\\resources\\data.txt";


    public static void main(String[] args) {
        CustomReader reader = new CustomReader();
        List<String> readerResult = reader.ReadFromFile(FILE_SRC);
        StringToIntParser parser = new StringToIntParser();
        List<Integer> parserResult = parser.Parse(readerResult);

        SimpleArrayFactory factory = new SimpleArrayFactory();
        SimpleArray arr2 = factory.GetSimpleArray(10, 15, 25, 4, 1, 455, -3, -100);
        SimpleArray arr = factory.GetSimpleArray(parserResult);
        logger.info(arr2.equals(arr));

        SimpleArrayServices services = new SimpleArrayServices();
        Optional<Double> result = services.FindAverage(arr);
        result.ifPresent(logger::info);
        IntUnaryOperator testFunction = d -> {
            if (d < 0) {
                return -d;
            }
            return d * 2;
        };
        int[] replacingResult = services.ReplaceByCondition(arr, testFunction);
        logger.info(Arrays.toString(replacingResult));
        logger.info(arr.toString());

        SortingServices sorting = new service.impl.SortingServices();
        int[] sortingResult = sorting.SelectionSort(arr);
        logger.info(Arrays.toString(sortingResult));
    }
}