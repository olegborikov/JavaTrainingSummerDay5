package test.borikov.day5.parser;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.parser.StringParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StringParserTest {
    StringParser stringParser;

    @BeforeClass
    public void setUp() {
        stringParser = new StringParser();
    }

    @AfterClass
    public void tearDown() {
        stringParser = null;
    }

    @Test
    public void testParseListToString() {
    }

    @DataProvider(name = "parseParagraphListToWordListPositiveData")
    public Object[][] createParseParagraphListToWordListPositiveData() {
        List<String> data1 = new ArrayList<>();
        data1.add("Hello, world");
        data1.add("Привет   мир!");
        data1.add("      ");
        data1.add("   Пока1. Пока2!   Пока...   ");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        List<String> data2 = new ArrayList<String>();
        data2.add("NONE,,,,,,,.....OF");
        data2.add(" Hello ");
        List<String> expected2 = new ArrayList<>();
        expected2.add("NONE");
        expected2.add("OF");
        expected2.add("Hello");
        List<String> data3 = new ArrayList<>();
        data3.add("ктонибудь");
        data3.add("NONE,,,,,,,.....OF\n");
        data3.add(" Hello ");
        List<String> expected3 = new ArrayList<>();
        expected3.add("ктонибудь");
        expected3.add("NONE");
        expected3.add("OF");
        expected3.add("Hello");
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordListPositiveData")
    public void parseParagraphListToWordListPositiveTest(List<String> data, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphListToWordList(data);
            System.out.println(actual);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseParagraphListToWordListNegativeData")
    public Object[][] createParseParagraphListToWordListNegativeData() {
        List<String> data1 = new ArrayList<>();
        data1.add("Hello, world");
        data1.add("Привет   мир!");
        data1.add("   Пока. Пока!   Пока...   ");
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        List<String> data2 = new ArrayList<>();
        data2.add("NONE,,,,,,,.....OF");
        data2.add(" Hello ");
        List<String> expected2 = new ArrayList<>();
        expected2.add("NONE");
        expected2.add("OF1");
        List<String> data3 = new ArrayList<>();
        data3.add("NONE,,,,,,,.....OF\n");
        data3.add(" Hello ");
        List<String> expected3 = new ArrayList<>();
        expected3.add("NONE");
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphListToWordListNegativeData")
    public void parseParagraphListToWordListNegativeTest(List<String> data, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphListToWordList(data);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseExceptionData")
    public Object[][] createParseParagraphListToWordListExceptionData() {
        List<String> data = new ArrayList<>();
        return new Object[][]{
                {null},
                {data}
        };
    }

    @Test(dataProvider = "parseExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void parseParagraphsListToWordsListExceptionTest(List<String> data) throws IncorrectDataException {
        stringParser.parseParagraphListToWordList(data);
    }

    @DataProvider(name = "parseListToStringPositiveData")
    public Object[][] createParseListToStringPositiveData() {
        List<String> data1 = new ArrayList<>();
        data1.add("Hello, world");
        data1.add("Привет   мир!");
        data1.add("      ");
        data1.add("   Пока1. Пока2!   Пока...   ");
        String expected1 = "Hello, world Привет   мир!           Пока1. Пока2!   Пока...   ";
        List<String> data2 = new ArrayList<>();
        data2.add("Hello");
        data2.add("мир!");
        String expected2 = "Hello мир!";
        List<String> data3 = new ArrayList<>();
        data3.add("2");
        data3.add("3!");
        data3.add("1");
        data3.add("vb ");
        String expected3 = "2 3! 1 vb ";
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseListToStringPositiveData")
    public void parseListToStringPositiveTest(List<String> data, String expected) {
        try {
            String actual = stringParser.parseListToString(data);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseListToStringNegativeData")
    public Object[][] createParseListToStringNegativeData() {
        List<String> data1 = new ArrayList<>();
        data1.add("—Hello,! world");
        data1.add("Привет   мир!");
        data1.add("      ");
        data1.add("   Пока1. Пока2!   Пока...   ");
        String expected1 = "Hello, world Привет   мир!            Пока1. Пока2!   Пока...   ";
        List<String> data2 = new ArrayList<>();
        data2.add("Hello");
        String expected2 = "Hello мир!";
        List<String> data3 = new ArrayList<>();
        data3.add("2");
        data3.add("3!");
        data3.add("1");
        data3.add("vb ");
        String expected3 = "2 3! 1 vb";
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseListToStringNegativeData")
    public void parseListToStringNegativeTest(List<String> data, String expected) {
        try {
            String actual = stringParser.parseListToString(data);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @Test(dataProvider = "parseExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void parseListToStringExceptionTest(List<String> data) throws IncorrectDataException {
        stringParser.parseListToString(data);
    }
}
