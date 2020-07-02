package com.borikov.day5.creator;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.StringParser;
import com.borikov.day5.reader.TextFileReader;

import java.util.List;

public class StringCreator {
    private static final String SPACE = " ";

    public String createStringText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        List<String> paragraphText = textFileReader.readText(file);
        if (paragraphText.isEmpty()) {
            throw new IncorrectDataException();
        }
        String text = String.join(SPACE, paragraphText);
        return text;
    }

    public List<String> createWordListText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        TextFileReader textFileReader = new TextFileReader();
        List<String> paragraphText = textFileReader.readText(file);
        if (paragraphText.isEmpty()) {
            throw new IncorrectDataException();
        }
        StringParser stringParser = new StringParser();
        List<String> wordText = stringParser.parseParagraphListToWordList(paragraphText);
        return wordText;
    }
}
