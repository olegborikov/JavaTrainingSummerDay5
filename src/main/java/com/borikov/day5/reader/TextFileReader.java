package com.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader {
    private static final String LINE_BREAK = "\n";
    private static final String DEFAULT_FILE = "input/defaultData.txt";

    public String readText(String fileName) throws IncorrectDataException {
        Path path;
        if (fileName != null && Files.exists(Paths.get(fileName))) {
            path = Paths.get(fileName);
        } else {
            path = Paths.get(DEFAULT_FILE);
        }
        try {
            List<String> paragraphText = Files.readAllLines(path);
            String text = String.join(LINE_BREAK, paragraphText);
            return text;
        } catch (IOException e) {
            throw new IncorrectDataException("incorrect file", e);
        }
    }
}
