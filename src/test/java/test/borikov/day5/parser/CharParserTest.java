package test.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.CharParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CharParserTest {
    CharParser charParser;

    @BeforeClass
    public void setUp() {
        charParser = new CharParser();
    }

    @AfterClass
    public void tearDown() {
        charParser = null;
    }

    @DataProvider(name = "parseParagraphListToWordCharListPositiveData")
    public Object[][] createParseParagraphListToWordCharListPositiveData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        paragraphText1.add("      ");
        paragraphText1.add("   Пока1. Пока2!   Пока...   ");
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        List<String> paragraphText2 = new ArrayList<>();
        paragraphText2.add("NONE,,,,,,,.....OF");
        paragraphText2.add(" Hello ");
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'N', 'O', 'N', 'E'});
        expected2.add(new char[]{'O', 'F'});
        ;
        expected2.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("ктонибудь");
        paragraphText3.add("NONE,,,,,,,.....OF\n");
        paragraphText3.add(" Hello ");
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'к', 'т', 'о', 'н', 'и', 'б', 'у', 'д', 'ь'});
        expected3.add(new char[]{'N', 'O', 'N', 'E'});
        expected3.add(new char[]{'O', 'F'});
        expected3.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordCharListPositiveData")
    public void parseParagraphListToWordCharListPositiveTest(List<String> paragraphText, List<char[]> expected) {
        try {
            List<char[]> actual = charParser.parseParagraphListToWordCharList(paragraphText);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseParagraphListToWordCharLisNegativeData")
    public Object[][] createParseParagraphListToWordCharListNegativeData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        paragraphText1.add("      ");
        paragraphText1.add("   Пока1. Пока2!   Пока...   ");
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', ' ', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        List<String> paragraphText2 = new ArrayList<>();
        paragraphText2.add("NONE,,,,,,,.....OF");
        paragraphText2.add(" Hello ");
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'N', 'O', 'N', 'E', ' '});
        expected2.add(new char[]{'O', 'F'});
        ;
        expected2.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("ктонибудь");
        paragraphText3.add("NONE,,,,,,,.....OF\n");
        paragraphText3.add(" Hello ");
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{'к', 'т', 'о', 'н', 'и', 'б', 'у', 'д', 'ь'});
        expected3.add(new char[]{'N', 'O', 'N', 'E'});
        expected3.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordCharLisNegativeData")
    public void parseParagraphListToWordCharListNegativeTest(List<String> paragraphText, List<char[]> expected) {
        try {
            List<char[]> actual = charParser.parseParagraphListToWordCharList(paragraphText);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void parseParagraphListToWordCharListExceptionTest() throws IncorrectDataException {
        List<String> paragraphText = null;
        charParser.parseParagraphListToWordCharList(paragraphText);
    }


    @DataProvider(name = "parseListToCharArrayPositiveData")
    public Object[][] createParseListToCharArrayPositiveData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        char[] expected1 = new char[]{'H', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'П', 'р', 'и', 'в', 'е', 'т', ' ', ' ', ' ', 'м', 'и', 'р', '!'};
        List<String> paragraphText2 = new ArrayList<>();
        paragraphText2.add("NONE,,..OF");
        paragraphText2.add(" Hello ");
        char[] expected2 = new char[]{'N', 'O', 'N', 'E', ',', ',', '.', '.', 'O', 'F', ' ', ' ', 'H', 'e', 'l', 'l', 'o', ' '};
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("ктонибудь");
        paragraphText3.add("");
        paragraphText3.add("   ");
        char[] expected3 = new char[]{'к', 'т', 'о', 'н', 'и', 'б', 'у', 'д', 'ь', ' ', ' ', ' ', ' ', ' '};
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseListToCharArrayPositiveData")
    public void parseListToCharArrayPositiveTest(List<String> paragraphText, char[] expected) {
        try {
            char[] actual = charParser.parseListToCharArray(paragraphText);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseListToCharArrayNegativeData")
    public Object[][] createParseListToCharArrayNegativeData() {
        List<String> paragraphText1 = new ArrayList<>();
        paragraphText1.add("Hello, world");
        paragraphText1.add("Привет   мир!");
        char[] expected1 = new char[]{'H', 'e', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'П', 'р', 'и', 'в', 'е', 'т', ' ', ' ', ' ', 'м', 'и', 'р', '!'};
        List<String> paragraphText2 = new ArrayList<>();
        paragraphText2.add("NONE,,..OF");
        paragraphText2.add(" Hello ");
        char[] expected2 = new char[]{'N', 'O', 'N', 'E', ',', ',', '.', '.', 'O', 'F', 'b', ' ', 'H', 'e', 'l', 'l', 'o', ' '};
        List<String> paragraphText3 = new ArrayList<>();
        paragraphText3.add("ктонибудь");
        paragraphText3.add("");
        paragraphText3.add("   ");
        char[] expected3 = new char[]{'к', 'т', 'о', 'н', 'и', 'б', 'у', 'д', 'ь',  ' ', ' ', ' ', ' '};
        return new Object[][]{
                {paragraphText1, expected1},
                {paragraphText2, expected2},
                {paragraphText3, expected3},
        };
    }

    @Test(dataProvider = "parseListToCharArrayNegativeData")
    public void parseListToCharArrayNegativeTest(List<String> paragraphText, char[] expected) {
        try {
            char[] actual = charParser.parseListToCharArray(paragraphText);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void parseListToCharArrayExceptionTest() throws IncorrectDataException {
        List<String> paragraphText = null;
        charParser.parseListToCharArray(paragraphText);
    }

    private boolean equalsListCharArray(List<char[]> firstCharList, List<char[]> secondCharList) {
        boolean result = true;
        if (firstCharList == null || secondCharList == null || firstCharList.size() != secondCharList.size()) {
            result = false;
        } else {
            for (int i = 0; i < firstCharList.size(); i++) {
                if (firstCharList.get(i).length != secondCharList.get(i).length) {
                    result = false;
                    break;
                } else {
                    for (int j = 0; j < firstCharList.get(i).length; j++) {
                        if (firstCharList.get(i)[j] != secondCharList.get(i)[j]) {
                            result = false;
                            break;
                        }
                    }
                }

            }
        }
        return result;
    }
}
