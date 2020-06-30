package com.borikov.day5.creator;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.CharParser;

import java.util.List;

public class CharCreator {
    public List<char[]> createWordCharArrayText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        StringCreator stringCreator = new StringCreator();
        List<String> stringWordText = stringCreator.createWordListText(file);
        CharParser charParser = new CharParser();
        List<char[]> wordText = charParser.parseStringListToCharArrayList(stringWordText);
        return wordText;
    }

    public char[] createCharArrayText(String file) throws IncorrectDataException {
        if (file == null) {
            throw new IncorrectDataException();
        }
        StringCreator stringCreator = new StringCreator();
        String stringText = stringCreator.createStringText(file);
        char[] text = stringText.toCharArray();
        return text;
    }
}
