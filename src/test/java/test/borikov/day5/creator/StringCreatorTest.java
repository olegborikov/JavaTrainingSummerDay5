package test.borikov.day5.creator;

import com.borikov.day5.creator.StringCreator;
import com.borikov.day5.exception.IncorrectDataException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StringCreatorTest {
    StringCreator stringCreator;

    @BeforeClass
    public void setUp() {
        stringCreator = new StringCreator();
    }

    @AfterClass
    public void tearDown() {
        stringCreator = null;
    }

    @DataProvider(name = "createWordListTextFilePositiveData")
    public Object[][] createCreateWordListTextFilePositiveData() {
        List<String> defaultDataText = new ArrayList<>();
        defaultDataText.add("Я");
        defaultDataText.add("так");
        defaultDataText.add("очарован");
        defaultDataText.add("прелестями");
        defaultDataText.add("ума");
        defaultDataText.add("и");
        defaultDataText.add("образования");
        defaultDataText.add("общества");
        defaultDataText.add("в");
        defaultDataText.add("особенности");
        defaultDataText.add("женского");
        defaultDataText.add("Here");
        defaultDataText.add("you");
        defaultDataText.add("can");
        defaultDataText.add("find");
        defaultDataText.add("activities");
        defaultDataText.add("to");
        defaultDataText.add("practise");
        defaultDataText.add("your");
        defaultDataText.add("reading");
        defaultDataText.add("skills");
        List<String> validDataText = new ArrayList<>();
        validDataText.add("Я");
        validDataText.add("как");
        validDataText.add("то");
        validDataText.add("очаро3ван");
        validDataText.add("прелестями");
        validDataText.add("ума");
        validDataText.add("и");
        validDataText.add("образования");
        validDataText.add("общ2ества");
        validDataText.add("Reading");
        validDataText.add("will");
        validDataText.add("help");
        validDataText.add("you");
        validDataText.add("to");
        validDataText.add("imp3");
        validDataText.add("rove");
        validDataText.add("the");
        validDataText.add("language");
        validDataText.add("and");
        validDataText.add("build");
        validDataText.add("your");
        validDataText.add("voca6bulary");
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createWordListTextFilePositiveData")
    public void createWordListTextFilePositiveTest(String fileName,
                                                   List<String> expected) {
        try {
            List<String> actual = stringCreator.createWordListTextFile(fileName);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextFileNegativeData")
    public Object[][] createCreateWordListTextFileNegativeData() {
        List<String> defaultDataText = new ArrayList<>();
        defaultDataText.add("Я");
        defaultDataText.add("так");
        defaultDataText.add("очарован");
        defaultDataText.add("find");
        defaultDataText.add("activities");
        defaultDataText.add("to");
        defaultDataText.add("practise");
        defaultDataText.add("your");
        defaultDataText.add("reading");
        defaultDataText.add("skills");
        List<String> validDataText = new ArrayList<>();
        validDataText.add("Я");
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createWordListTextFileNegativeData")
    public void createWordListTextFileNegativeTest(String fileName,
                                                   List<String> expected) {
        try {
            List<String> actual = stringCreator.createWordListTextFile(fileName);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void createWordListTextExceptionTest()
            throws IncorrectDataException {
        String fileName = null;
        stringCreator.createWordListTextFile(fileName);
    }

    @DataProvider(name = "createWordListTextConsolePositiveData")
    public Object[][] createCreateWordListTextConsolePositiveData() {
        String text1 = "Hello, world Привет   мир! Привет  " +
                " мир! ,.! Пока1. Пока2!   Пока...   ";
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        String text2 = "нет да \t\t!`~net,,,,da";
        List<String> expected2 = new ArrayList<>();
        expected2.add("нет");
        expected2.add("да");
        expected2.add("net");
        expected2.add("da");
        String text3 = "###,  !#\t\t!`~,,,,";
        List<String> expected3 = new ArrayList<>();
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "createWordListTextConsolePositiveData")
    public void createWordListTextConsolePositiveTest(String data,
                                                      List<String> expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            List<String> actual = stringCreator.createWordListTextConsole(inputData);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextConsoleNegativeData")
    public Object[][] createCreateWordListTextConsoleNegativeData() {
        String text1 = "Hello, world Привет   мир! Привет  " +
                " мир! ,.! Пока1. Пока2!   Пока...   ";
        List<String> expected1 = new ArrayList<>();
        expected1.add("Hello");
        expected1.add("world");
        expected1.add("Привет");
        expected1.add("мир");
        expected1.add("Пока1");
        expected1.add("Пока2");
        expected1.add("Пока");
        String text2 = "нет да \t\t!`~net,,,,da";
        List<String> expected2 = new ArrayList<>();
        expected2.add("нет");
        expected2.add("да");
        expected2.add("net");
        expected2.add(" ");
        String text3 = "###,  !#\t\t!`~,,,,";
        List<String> expected3 = new ArrayList<>();
        expected3.add(" ");
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "createWordListTextConsoleNegativeData")
    public void createWordListTextConsoleNegativeTest(String data,
                                                      List<String> expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            List<String> actual = stringCreator.createWordListTextConsole(inputData);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void createWordListTextConsoleExceptionTest()
            throws IncorrectDataException {
        InputStream inputData = null;
        stringCreator.createWordListTextConsole(inputData);
    }
}
