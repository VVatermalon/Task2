package reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReader implements reader.CustomReader {
    final Logger logger = LogManager.getLogger();
    public List<String> ReadFromFile(String src) {
        try {
            if (src != null) {
                return Files.lines(Paths.get(src)).collect(Collectors.toList());
            } else {
                logger.error("Null parameter");
                return new ArrayList<String>(0);
            }
        }
        catch(IOException e) {
            logger.error(e);
            return new ArrayList<>(0);
        }
    }
}
