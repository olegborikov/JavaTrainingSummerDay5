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

    @DataProvider(name = "parseParagraphsListToWordsListPositiveData")
    public Object[][] createParseParagraphsListToWordsListPositiveData() {
        List<String> data1 = new ArrayList<String>();
        data1.add("Hello, world");
        data1.add("Привет   мир!");
        data1.add("      ");
        data1.add("   Пока1. Пока2!   Пока...   ");
        List<String> expected1 = new ArrayList<String>();
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
        List<String> expected2 = new ArrayList<String>();
        expected2.add("NONE");
        expected2.add("OF");
        expected2.add("Hello");
        List<String> data3 = new ArrayList<String>();
        data3.add("NONE,,,,,,,.....OF\n");
        data3.add(" Hello ");
        List<String> expected3 = new ArrayList<String>();
        expected3.add("NONE");
        expected3.add("OF");
        expected3.add("Hello");
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphsListToWordsListPositiveData")
    public void parseParagraphsListToWordsListPositiveTest(List<String> data, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphsListToWordsList(data);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseParagraphsListToWordsListNegativeData")
    public Object[][] createParseParagraphsListToWordsListNegativeData() {
        List<String> data1 = new ArrayList<String>();
        data1.add("Hello, world");
        data1.add("Привет   мир!");
        data1.add("   Пока. Пока!   Пока...   ");
        List<String> expected1 = new ArrayList<String>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока");
        expected1.add("Пока");
        List<String> data2 = new ArrayList<String>();
        data2.add("NONE,,,,,,,.....OF");
        data2.add(" Hello ");
        List<String> expected2 = new ArrayList<String>();
        expected2.add("NONE");
        expected2.add("OF1");
        expected2.add("Hello");
        List<String> data3 = new ArrayList<String>();
        data3.add("NONE,,,,,,,.....OF\n");
        data3.add(" Hello ");
        List<String> expected3 = new ArrayList<String>();
        expected3.add("NONE");
        return new Object[][]{
                {data1, expected1},
                {data2, expected2},
                {data3, expected3},
        };
    }

    @Test(dataProvider = "parseParagraphsListToWordsListNegativeData")
    public void parseParagraphsListToWordsListNegativeTest(List<String> data, List<String> expected) {
        try {
            List<String> actual = stringParser.parseParagraphsListToWordsList(data);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }

    @DataProvider(name = "parseParagraphsListToWordsListExceptionData")
    public Object[][] createParseParagraphsListToWordsListExceptionData() {
        List<String> data = new ArrayList<String>();
        return new Object[][]{
                {null},
                {data}
        };
    }

    @Test(dataProvider = "parseParagraphsListToWordsListExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void parseParagraphsListToWordsListExceptionTest(List<String> data) throws IncorrectDataException {
         stringParser.parseParagraphsListToWordsList(data);
    }

    @Test
    public void parseListToStringTest(){
        try {
            List<String> data1 = new ArrayList<String>();
            data1.add("Hello, world");
            data1.add("Привет   мир!");
            data1.add("   Пока. Пока!   Пока...   ");
            String data = stringParser.parseListToString(data1);
            System.out.println(data);
        } catch (IncorrectDataException e) {
            fail("incorrect data");
        }
    }
}
