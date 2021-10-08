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
        List<String> readerResult = reader.ReadFromFile(FILE_SRC);
        StringToIntParserImpl parser = new StringToIntParserImpl();
        List<Integer> parserResult = parser.Parse(readerResult);

        SimpleArrayFactoryImpl factory = new SimpleArrayFactoryImpl();
        SimpleArray arr2 = factory.GetSimpleArray(10, 15, 25, 4, 1, 455, -3, -100);
        SimpleArray arr = factory.GetSimpleArray(parserResult);
        logger.info(arr2.equals(arr));

        SimpleArrayServicesImpl services = new SimpleArrayServicesImpl();
        OptionalDouble result = services.FindAverage(arr);
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

        SortingServices sorting = new SortingServicesImpl();
        int[] sortingResult = sorting.SelectionSort(arr);
        logger.info(Arrays.toString(sortingResult));
    }
}