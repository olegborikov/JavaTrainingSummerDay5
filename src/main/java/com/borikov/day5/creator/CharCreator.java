package com.borikov.day5.creator;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.CharParser;
import com.borikov.day5.reader.TextFileReader;

import java.util.List;

public class CharCreator {
    private static final String SPACE = " ";

    public char[] createCharArrayText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        List<String> paragraphText = textFileReader.readText(file);
        if (paragraphText.isEmpty()) {
            throw new IncorrectDataException();
        }
        CharParser charParser = new CharParser();
        char[] text = charParser.parseListToCharArray(paragraphText);
        return text;
    }

    public List<char[]> createWordListText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        List<String> paragraphText = textFileReader.readText(file);
        if (paragraphText.isEmpty()) {
            throw new IncorrectDataException();
        }
        CharParser charParser = new CharParser();
        List<char[]> wordText = charParser.parseParagraphListToWordCharList(paragraphText);
        return wordText;
    }
}
