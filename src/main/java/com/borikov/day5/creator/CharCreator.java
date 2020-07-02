package com.borikov.day5.creator;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.CharParser;
import com.borikov.day5.reader.TextConsoleReader;
import com.borikov.day5.reader.TextFileReader;

import java.io.InputStream;
import java.util.List;

public class CharCreator {
    public List<char[]> createWordListTextFile(String fileName)
            throws IncorrectDataException {
        if (fileName == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.readText(fileName);
        CharParser charParser = new CharParser();
        List<char[]> wordText = charParser.parseTextToWordCharList(text);
        return wordText;
    }

    public List<char[]> createWordListTextConsole(InputStream input)
            throws IncorrectDataException {
        if (input == null) {
            throw new IncorrectDataException();
        }
        TextConsoleReader textConsoleReader = new TextConsoleReader();
        String text = textConsoleReader.readText(input);
        CharParser charParser = new CharParser();
        List<char[]> wordText = charParser.parseTextToWordCharList(text);
        return wordText;
    }
}
