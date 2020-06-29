package com.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextDataReader {
    private static final String DEFAULT_FILE = "input/defaultData.txt";

    public List<String> readText(String file) throws IncorrectDataException {
        Path path = Paths.get(DEFAULT_FILE);
        if (file != null) {
            path = Paths.get(file);
            if (Files.notExists(path)) {
                path = Paths.get(DEFAULT_FILE);
            }
        }
        try {
            List<String> data = Files.readAllLines(path);
            if (data.isEmpty()) {
                throw new IncorrectDataException("incorrect file");
            }
            return data;
        } catch (IOException e) {
            throw new IncorrectDataException("incorrect file");
        }
    }
}
