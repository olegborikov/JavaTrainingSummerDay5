package test.borikov.day5.creator;

import com.borikov.day5.creator.CharCreator;
import com.borikov.day5.exception.IncorrectDataException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CharCreatorTest {
    CharCreator charCreator;

    @BeforeTest
    public void setUp() {
        charCreator = new CharCreator();
    }

    @AfterTest
    public void tearDown() {
        charCreator = null;
    }

    @DataProvider(name = "createWordListTextFilePositiveData")
    public Object[][] createCreateWordListTextFilePositiveData() {
        List<char[]> defaultDataText = new ArrayList<>();
        defaultDataText.add(new char[]{'Я'});
        defaultDataText.add(new char[]{'т', 'а', 'к'});
        defaultDataText.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        defaultDataText.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т',
                'я', 'м', 'и'});
        defaultDataText.add(new char[]{'у', 'м', 'а'});
        defaultDataText.add(new char[]{'и'});
        defaultDataText.add(new char[]{'о', 'б', 'р', 'а', 'з', 'о', 'в',
                'а', 'н', 'и', 'я'});
        defaultDataText.add(new char[]{'о', 'б', 'щ', 'е', 'с', 'т', 'в', 'а'});
        defaultDataText.add(new char[]{'в'});
        defaultDataText.add(new char[]{'о', 'с', 'о', 'б', 'е', 'н', 'н',
                'о', 'с', 'т', 'и'});
        defaultDataText.add(new char[]{'ж', 'е', 'н', 'с', 'к', 'о', 'г', 'о'});
        defaultDataText.add(new char[]{'H', 'e', 'r', 'e'});
        defaultDataText.add(new char[]{'y', 'o', 'u'});
        defaultDataText.add(new char[]{'c', 'a', 'n'});
        defaultDataText.add(new char[]{'f', 'i', 'n', 'd'});
        defaultDataText.add(new char[]{'a', 'c', 't', 'i', 'v', 'i', 't', 'i',
                'e', 's'});
        defaultDataText.add(new char[]{'t', 'o'});
        defaultDataText.add(new char[]{'p', 'r', 'a', 'c', 't', 'i', 's', 'e'});
        defaultDataText.add(new char[]{'y', 'o', 'u', 'r'});
        defaultDataText.add(new char[]{'r', 'e', 'a', 'd', 'i', 'n', 'g'});
        defaultDataText.add(new char[]{'s', 'k', 'i', 'l', 'l', 's'});
        List<char[]> validDataText = new ArrayList<>();
        validDataText.add(new char[]{'Я'});
        validDataText.add(new char[]{'к', 'а', 'к'});
        validDataText.add(new char[]{'т', 'о'});
        validDataText.add(new char[]{'о', 'ч', 'а', 'р', 'о', '3', 'в', 'а', 'н'});
        validDataText.add(new char[]{'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я',
                'м', 'и'});
        validDataText.add(new char[]{'у', 'м', 'а'});
        validDataText.add(new char[]{'и'});
        validDataText.add(new char[]{'о', 'б', 'р', 'а', 'з', 'о', 'в', 'а',
                'н', 'и', 'я'});
        validDataText.add(new char[]{'о', 'б', 'щ', '2', 'е', 'с', 'т', 'в', 'а'});
        validDataText.add(new char[]{'R', 'e', 'a', 'd', 'i', 'n', 'g'});
        validDataText.add(new char[]{'w', 'i', 'l', 'l'});
        validDataText.add(new char[]{'h', 'e', 'l', 'p'});
        validDataText.add(new char[]{'y', 'o', 'u'});
        validDataText.add(new char[]{'t', 'o'});
        validDataText.add(new char[]{'i', 'm', 'p', '3'});
        validDataText.add(new char[]{'r', 'o', 'v', 'e'});
        validDataText.add(new char[]{'t', 'h', 'e'});
        validDataText.add(new char[]{'l', 'a', 'n', 'g', 'u', 'a', 'g', 'e'});
        validDataText.add(new char[]{'a', 'n', 'd'});
        validDataText.add(new char[]{'b', 'u', 'i', 'l', 'd'});
        validDataText.add(new char[]{'y', 'o', 'u', 'r'});
        validDataText.add(new char[]{'v', 'o', 'c', 'a', '6', 'b', 'u', 'l',
                'a', 'r', 'y'});
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createWordListTextFilePositiveData")
    public void createWordListTextFilePositiveTest(String fileName,
                                                   List<char[]> expected) {
        try {
            List<char[]> actual = charCreator.createWordListTextFile(fileName);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextFileNegativeData")
    public Object[][] createCreateWordListTextFileNegativeData() {
        List<char[]> defaultDataText = new ArrayList<>();
        defaultDataText.add(new char[]{' '});
        defaultDataText.add(new char[]{'т', 'а', 'к'});
        defaultDataText.add(new char[]{'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н'});
        defaultDataText.add(new char[]{'у', 'м', 'а'});
        defaultDataText.add(new char[]{'и'});
        defaultDataText.add(new char[]{'о', 'б', 'р', 'а', 'з', 'о', 'и', 'я'});
        List<char[]> validDataText = new ArrayList<>();
        validDataText.add(new char[]{'Я'});
        validDataText.add(new char[]{'к', 'а', 'к'});
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createWordListTextFileNegativeData")
    public void createWordListTextFileNegativeTest(String fileName,
                                                   List<char[]> expected) {
        try {
            List<char[]> actual = charCreator.createWordListTextFile(fileName);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void createWordListTextExceptionTest()
            throws IncorrectDataException {
        String fileName = null;
        charCreator.createWordListTextFile(fileName);
    }

    @DataProvider(name = "createWordListTextConsolePositiveData")
    public Object[][] createCreateWordListTextConsolePositiveData() {
        String text1 = "Hello, world Привет   мир! Привет  " +
                " мир! ,.! Пока1. Пока2!   Пока...   ";
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        String text2 = "нет да \t\t!`~net,,,,da";
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'н', 'е', 'т'});
        expected2.add(new char[]{'д', 'а'});
        expected2.add(new char[]{'n', 'e', 't'});
        expected2.add(new char[]{'d', 'a'});
        String text3 = "###,  !#\t\t!`~,,,,";
        List<char[]> expected3 = new ArrayList<>();
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "createWordListTextConsolePositiveData")
    public void createWordListTextConsolePositiveTest(String data,
                                                      List<char[]> expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            List<char[]> actual = charCreator.createWordListTextConsole(inputData);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextConsoleNegativeData")
    public Object[][] createCreateWordListTextConsoleNegativeData() {
        String text1 = "Hello, world Привет   мир! \nПривет " +
                "  мир! ,.! Пока1. Пока2!   Пока...   ";
        List<char[]> expected1 = new ArrayList<>();
        expected1.add(new char[]{'H', 'e', 'l', 'l', 'o'});
        expected1.add(new char[]{'w', 'o', 'r', 'l', 'd'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', ' '});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'р', 'и', 'в', 'е', 'т'});
        expected1.add(new char[]{'м', 'и', 'р'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '1'});
        expected1.add(new char[]{'П', 'о', 'к', 'а', '2'});
        expected1.add(new char[]{'П', 'о', 'к', 'а'});
        String text2 = "нет да \n\n\n\n\t\t!`~net,,,,da";
        List<char[]> expected2 = new ArrayList<>();
        expected2.add(new char[]{'н', 'е', 'т'});
        expected2.add(new char[]{'д', 'а'});
        expected2.add(new char[]{'n', 'e', 't'});
        String text3 = "###,  !#\t\t!`~,,,,";
        List<char[]> expected3 = new ArrayList<>();
        expected3.add(new char[]{});
        return new Object[][]{
                {text1, expected1},
                {text2, expected2},
                {text3, expected3}
        };
    }

    @Test(dataProvider = "createWordListTextConsoleNegativeData")
    public void createWordListTextConsoleNegativeTest(String data,
                                                      List<char[]> expected) {
        try {
            InputStream inputData = new ByteArrayInputStream(data.getBytes());
            List<char[]> actual = charCreator.createWordListTextConsole(inputData);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void createWordListTextConsoleExceptionTesxt()
            throws IncorrectDataException {
        InputStream inputData = null;
        charCreator.createWordListTextConsole(inputData);
    }

    private boolean equalsListCharArray(List<char[]> firstCharList,
                                        List<char[]> secondCharList) {
        boolean result = true;
        if (firstCharList == null || secondCharList == null
                | firstCharList.size() != secondCharList.size()) {
            result = false;
        } else {
            for (int i = 0; i < firstCharList.size(); i++) {
                if (!result) {
                    break;
                }
                if (firstCharList.get(i).length != secondCharList.get(i).length) {
                    result = false;
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
