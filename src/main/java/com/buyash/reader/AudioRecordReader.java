package com.buyash.reader;

import com.buyash.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AudioRecordReader {

    private String filePath;
    private static Logger logger = LogManager.getLogger();

    public AudioRecordReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readAllLines() throws ReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filePath);
        if (url == null) {
            logger.warn("No file with such name found");
            throw new ReaderException("No file with such name found");
        }
        File file = new File(url.getPath());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> stringRecords = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringRecords.add(line);
            }
            return stringRecords;
        } catch (IOException e) {
            logger.warn(e);
            throw new ReaderException(e);
        }
    }

}
