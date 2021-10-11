package main;

import entity.SimpleArray;
import factory.impl.SimpleArrayFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.impl.StringToIntParserImpl;
import reader.impl.CustomReaderImpl;
import service.SortingServices;
import service.impl.SimpleArrayServicesImpl;
import service.impl.SortingServicesImpl;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.IntUnaryOperator;

public class Main {
    static final Logger logger = LogManager.getLogger();
    static final String FILE_SRC = "data.txt";


    public static void main(String[] args) {
        CustomReaderImpl reader = new CustomReaderImpl();
        List<String> readerResult = reader.readFromFile(FILE_SRC);
        StringToIntParserImpl parser = new StringToIntParserImpl();
        List<Integer> parserResult = parser.parse(readerResult);

        SimpleArrayFactoryImpl factory = new SimpleArrayFactoryImpl();
        SimpleArray arr2 = factory.createSimpleArray(10, 15, 25, 4, 1, 455, -3, -100);
        SimpleArray arr = factory.createSimpleArray(parserResult);
        logger.info(arr2.equals(arr));

        SimpleArrayServicesImpl services = new SimpleArrayServicesImpl();
        OptionalDouble result = services.findAverage(arr);
        result.ifPresent(logger::info);
        IntUnaryOperator testFunction = d -> {
            if (d < 0) {
                return -d;
            }
            return d * 2;
        };
        int[] replacingResult = services.replaceByCondition(arr, testFunction);
        logger.info(Arrays.toString(replacingResult));
        logger.info(arr.toString());

        SortingServices sorting = new SortingServicesImpl();
        int[] sortingResult = sorting.selectionSort(arr);
        logger.info(Arrays.toString(sortingResult));
    }
}