package reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReaderImpl implements reader.CustomReader {
    static final Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String src) {
        try {
            if (src == null) {
                logger.error("Null parameter");
                return new ArrayList<>(0);
            }
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource(src);
            if (resource != null) {
                return Files.lines(Paths.get(resource.toURI())).collect(Collectors.toList());
            } else {
                logger.error("Null parameter");
                return new ArrayList<>(0);
            }
        } catch (IOException | URISyntaxException e) {
            logger.error(e);
            return new ArrayList<>(0);
        }
    }
}
