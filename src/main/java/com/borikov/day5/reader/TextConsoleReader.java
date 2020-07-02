package com.borikov.day5.reader;

import com.borikov.day5.console.TextPrint;

import java.io.InputStream;
import java.util.Scanner;

public class TextConsoleReader {
    public String readText(InputStream input) {
        Scanner scanner = new Scanner(input);
        TextPrint textPrint = new TextPrint();
        textPrint.printEnterText();
        String text = scanner.nextLine();
        return text;
    }
}
