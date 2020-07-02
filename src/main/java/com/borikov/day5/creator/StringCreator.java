package com.borikov.day5.creator;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.StringParser;
import com.borikov.day5.reader.TextConsoleReader;
import com.borikov.day5.reader.TextFileReader;

import java.io.InputStream;
import java.util.List;

public class StringCreator {
    public List<String> createWordListTextFile(String fileName)
            throws IncorrectDataException {
        if (fileName == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.readText(fileName);
        StringParser stringParser = new StringParser();
        List<String> wordText = stringParser.parseTextToWordList(text);
        return wordText;
    }

    public List<String> createWordListTextConsole(InputStream input)
            throws IncorrectDataException {
        if (input == null) {
            throw new IncorrectDataException();
        }
        TextConsoleReader textConsoleReader = new TextConsoleReader();
        String text = textConsoleReader.readText(input);
        StringParser stringParser = new StringParser();
        List<String> wordText = stringParser.parseTextToWordList(text);
        return wordText;
    }
}
