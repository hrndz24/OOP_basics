package com.buyash.reader;

import com.buyash.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioRecordReader {

    private String filePath;
    private static Logger logger = LogManager.getLogger();

    public AudioRecordReader(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readAllLines() throws ReaderException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
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
