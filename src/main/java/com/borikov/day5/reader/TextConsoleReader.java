package com.borikov.day5.reader;

import com.borikov.day5.console.TextPrint;
import com.borikov.day5.exception.IncorrectDataException;

import java.io.InputStream;
import java.util.Scanner;

public class TextConsoleReader {
    public String readText(InputStream input) throws IncorrectDataException {
        if (input == null) {
            throw new IncorrectDataException();
        }
        Scanner scanner = new Scanner(input);
        TextPrint textPrint = new TextPrint();
        textPrint.printEnterText();
        String text = scanner.nextLine();
        return text;
    }
}
