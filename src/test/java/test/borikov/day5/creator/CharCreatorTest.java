package test.borikov.day5.creator;

import com.borikov.day5.creator.CharCreator;
import com.borikov.day5.exception.IncorrectDataException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider(name = "createCharArrayTextPositiveData")
    public Object[][] createCreateCharArrayTextPositiveData() {
        char[] defaultDataText = {'—', ' ', 'Я', ' ', 'т', 'а', 'к', ' ',
                'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н', ' ', 'п', 'р', 'е',
                'л', 'е', 'с', 'т', 'я', 'м', 'и', ' ', 'у', 'м', 'а', ' ',
                'и', ' ', 'о', 'б', 'р', 'а', 'з', 'о', 'в', 'а', 'н', 'и',
                'я', ' ', 'о', 'б', 'щ', 'е', 'с', 'т', 'в', 'а', ',', ' ',
                'в', ' ', 'о', 'с', 'о', 'б', 'е', 'н', 'н', 'о', 'с', 'т',
                'и', ' ', 'ж', 'е', 'н', 'с', 'к', 'о', 'г', 'о', '.', ' ',
                'А', 'н', 'н', 'а', ' ', 'П', 'а', 'в', 'л', 'о', 'в', 'н',
                'а', ' ', 'д', 'л', 'я', ' ', 'у', 'д', 'о', 'б', 'с', 'т',
                'в', 'а', ' ', 'н', 'а', 'б', 'л', 'ю', 'д', 'е', 'н', 'и',
                'я', ' ', 'п', 'р', 'и', 'с', 'о', 'е', 'д', 'и', 'н', 'и',
                'л', 'а', ' ', 'и', 'х', ' ', 'к', ' ', 'о', 'б', 'щ', 'е',
                'м', 'у', ' ', 'к', 'р', 'у', 'ж', 'к', 'у', '.', ' ', 'В',
                ' ', 'э', 'т', 'о', ' ', 'в', 'р', 'е', 'м', 'я', ' ', 'в',
                ' ', 'г', 'о', 'с', 'т', 'и', 'н', 'у', 'ю', ' ', 'в', 'о',
                'ш', 'л', 'о', ' ', 'к', 'а', 'к', 'о', 'е', '-', 'т', 'о',
                ' ', 'н', 'о', 'в', 'о', 'е', ' ', 'л', 'и', 'ц', 'о', '.',
                ' ', 'H', 'e', 'r', 'e', ' ', 'y', 'o', 'u', ' ', 'c', 'a',
                'n', ' ', 'f', 'i', 'n', 'd', ' ', 'a', 'c', 't', 'i', 'v',
                'i', 't', 'i', 'e', 's', ' ', 't', 'o', ' ', 'p', 'r', 'a',
                'c', 't', 'i', 's', 'e', ' ', 'y', 'o', 'u', 'r', ' ', 'r',
                'e', 'a', 'd', 'i', 'n', 'g', ' ', 's', 'k', 'i', 'l', 'l', 's', '.'};
        char[] validDataText = {'—', ' ', 'Я', ' ', 'к', 'а', 'к', '-', 'т',
                'о', ' ', 'о', 'ч', 'а', 'р', 'о', '3', 'в', 'а', 'н', ' ',
                'п', 'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и', ',', ',',
                ' ', 'у', 'м', 'а', ' ', 'и', ' ', 'о', 'б', 'р', 'а', 'з',
                'о', 'в', 'а', 'н', 'и', 'я', ' ', 'о', 'б', 'щ', '2', 'е',
                'с', 'т', 'в', 'а', '.', ' ', ' ', ' ', 'H', 'e', 'r', 'e',
                ' ', 'y', 'o', 'u', ' ', 'c', 'a', 'n', ' ', 'f', 'i', 'n',
                'd', ' ', 'a', 'c', 't', 'i', 'v', 'i', 't', 'i', 'e', 's',
                ' ', 't', 'o', ' ', 'p', 'r', 'a', 'c', 't', 'i', 's', 'e',
                ' ', 'y', 'o', 'u', 'r', ' ', 'r', 'e', 'a', 'd', 'i', 'n',
                'g', ' ', 's', '3', 'k', 'i', 'l', 'l', 's', '.', ' ', 'R',
                'e', 'a', 'd', 'i', 'n', 'g', ' ', 'w', 'i', 'l', 'l', ' ',
                'h', 'e', 'l', 'p', ' ', 'y', 'o', 'u', ' ', 't', 'o', ' ',
                'i', 'm', 'p', '3', '-', 'r', 'o', 'v', 'e', ' ', ' ', ' ',
                't', 'h', 'e', ' ', 'l', 'a', 'n', 'g', 'u', 'a', 'g', 'e',
                ' ', 'a', 'n', 'd', ' ', '-', 'b', 'u', 'i', 'l', 'd', ' ',
                'y', 'o', 'u', 'r', ' ', 'v', 'o', 'c', 'a', '6', 'b', 'u',
                'l', 'a', 'r', 'y', '.'};
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createCharArrayTextPositiveData")
    public void createCharArrayTextPositiveTest(String file, char[] expected) {
        try {
            char[] actual = charCreator.createCharArrayText(file);
            for (int i = 0; i < actual.length; i++) {
                System.out.print("'" + actual[i] + "', ");
            }
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createCharArrayTextNegativeData")
    public Object[][] createCreateCharArrayTextNegativeData() {
        char[] defaultDataText = {'—', ' ', 'Я', ' ', 'т', 'а', 'к',
                ' ', 'о', 'ч', 'а', 'р', 'о', 'в', 'а', 'н', ' ', 'п',
                'р', 'е', 'л', 'е', 'с', 'т', 'я', 'м', 'и', ' ', 'у',
                'м', 'а', ' ', 'и', ' ', 'о', 'б', 'р', 'а', 'з', 'о',
                'в', 'а', 'н', 'и', 'я', ' ', 'о', 'б', 'щ', 'е', 'с',
                'т', 'в', 'а', ',', ' ', 'в', ' ', 'о', 'с', 'о', 'б',
                'е', 'н', 'н', 'о', 'с', 'т', 'и', ' ', 'ж', 'е', 'н',
                'с', 'к', 'о', 'г', 'о', '.', ' ', 'А', 'н', 'н', 'а',
                ' ', 'П', 'а', 'в', 'л', 'о', 'в', 'н', 'а', ' ', 'д',
                'т', 'и', 'н', 'i', 'n', 'g', ' ', 's', 'k', 'i', 'l',
                'l', 's', '.'};
        char[] validDataText = {};
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createCharArrayTextNegativeData")
    public void createCharArrayTextNegativeTest(String file, char[] expected) {
        try {
            char[] actual = charCreator.createCharArrayText(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createCharArrayExceptionData")
    public Object[][] createCreateStringTextExceptionData() {
        return new Object[][]{
                {null},
                {"input/invalidData.txt"},
        };
    }

    @Test(dataProvider = "createCharArrayExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createCharArrayTextExceptionTest(String file)
            throws IncorrectDataException {
        charCreator.createCharArrayText(file);
    }

    @DataProvider(name = "createWordListTextPositiveData")
    public Object[][] createCreateWordListTextPositiveData() {
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
        defaultDataText.add(new char[]{'А', 'н', 'н', 'а'});
        defaultDataText.add(new char[]{'П', 'а', 'в', 'л', 'о', 'в', 'н', 'а'});
        defaultDataText.add(new char[]{'д', 'л', 'я'});
        defaultDataText.add(new char[]{'у', 'д', 'о', 'б', 'с', 'т', 'в', 'а'});
        defaultDataText.add(new char[]{'н', 'а', 'б', 'л', 'ю', 'д', 'е',
                'н', 'и', 'я'});
        defaultDataText.add(new char[]{'п', 'р', 'и', 'с', 'о', 'е', 'д',
                'и', 'н', 'и', 'л', 'а'});
        defaultDataText.add(new char[]{'и', 'х'});
        defaultDataText.add(new char[]{'к'});
        defaultDataText.add(new char[]{'о', 'б', 'щ', 'е', 'м', 'у'});
        defaultDataText.add(new char[]{'к', 'р', 'у', 'ж', 'к', 'у'});
        defaultDataText.add(new char[]{'В'});
        defaultDataText.add(new char[]{'э', 'т', 'о'});
        defaultDataText.add(new char[]{'в', 'р', 'е', 'м', 'я'});
        defaultDataText.add(new char[]{'в'});
        defaultDataText.add(new char[]{'г', 'о', 'с', 'т', 'и', 'н', 'у', 'ю'});
        defaultDataText.add(new char[]{'в', 'о', 'ш', 'л', 'о'});
        defaultDataText.add(new char[]{'к', 'а', 'к', 'о', 'е'});
        defaultDataText.add(new char[]{'т', 'о'});
        defaultDataText.add(new char[]{'н', 'о', 'в', 'о', 'е'});
        defaultDataText.add(new char[]{'л', 'и', 'ц', 'о'});
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
        validDataText.add(new char[]{'H', 'e', 'r', 'e'});
        validDataText.add(new char[]{'y', 'o', 'u'});
        validDataText.add(new char[]{'c', 'a', 'n'});
        validDataText.add(new char[]{'f', 'i', 'n', 'd'});
        validDataText.add(new char[]{'a', 'c', 't', 'i', 'v', 'i', 't', 'i',
                'e', 's'});
        validDataText.add(new char[]{'t', 'o'});
        validDataText.add(new char[]{'p', 'r', 'a', 'c', 't', 'i', 's', 'e'});
        validDataText.add(new char[]{'y', 'o', 'u', 'r'});
        validDataText.add(new char[]{'r', 'e', 'a', 'd', 'i', 'n', 'g'});
        validDataText.add(new char[]{'s', '3', 'k', 'i', 'l', 'l', 's'});
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

    @Test(dataProvider = "createWordListTextPositiveData")
    public void createWordListTextPositiveTest(String file, List<char[]> expected) {
        try {
            List<char[]> actual = charCreator.createWordListText(file);
            boolean result = equalsListCharArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextNegativeData")
    public Object[][] createCreateWordListTextNegativeData() {
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

    @Test(dataProvider = "createWordListTextNegativeData")
    public void createWordListTextNegativeTest(String file, List<char[]> expected) {
        try {
            List<char[]> actual = charCreator.createWordListText(file);
            boolean result = equalsListCharArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(dataProvider = "createCharArrayExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createWordListTextExceptionTest(String file)
            throws IncorrectDataException {
        charCreator.createCharArrayText(file);
    }

    private boolean equalsListCharArray(
            List<char[]> firstCharList, List<char[]> secondCharList) {
        boolean result = true;
        if (firstCharList == null || secondCharList == null
                || firstCharList.size() != secondCharList.size()) {
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
