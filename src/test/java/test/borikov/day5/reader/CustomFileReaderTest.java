package test.borikov.day5.reader;

import com.borikov.day5.exception.IncorrectDataException;
import com.borikov.day5.reader.TextDataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomFileReaderTest {
    TextDataReader textDataReader;

    @BeforeClass
    public void setUp() {
        textDataReader = new TextDataReader();
    }

    @AfterClass
    public void tearDown() {
        textDataReader = null;
    }

    @DataProvider(name = "readTextPositiveData")
    public Object[][] createReadTextPositiveData() {
        List<String> validDataText = new ArrayList<String>();
        validDataText.add("— Я как-то очаро3ван прелестями,, ума и образования общ2ества.");
        validDataText.add("Here you can find activities to practise your reading skills.");
        validDataText.add("Reading will help you to imp3rove your understanding of the language and build your vocabulary.");
        List<String> defaultDataText = new ArrayList<String>();
        defaultDataText.add("— Я так очарован прелестями ума и образования общества, в особенности женского, в которое я имел счастье быть принят, что не успел еще подумать о климате, — сказал он.");
        defaultDataText.add("Не выпуская уже аббата и Пьера, Анна Павловна для удобства наблюдения присоединила их к общему кружку.");
        defaultDataText.add("В это время в гостиную вошло новое лицо. Новое лицо это был молодой князь Андрей Болконский, муж маленькой княгини. Князь Болконский был небольшого роста, весьма красивый молодой человек с определенными и сухими чертами. ");
        return new Object[][]{
                {"input/validData.txt", validDataText},
                {null, defaultDataText},
                {"input/qwerty.txt", defaultDataText},
        };
    }

    @Test(dataProvider = "readTextPositiveData")
    public void readTextPositiveTest(String file, List<String> expected) {
        try {
            List<String> actual = textDataReader.readText(file);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "readTextNegativeData")
    public Object[][] createReadTextNegativeData() {
        List<String> validDataText = new ArrayList<>();
        validDataText.add("— Я как-то очаро3ван прелестями,, ума и образования общ2ества.");
        List<String> defaultDataText = new ArrayList<>();
        defaultDataText.add("— Я так очарован прелестями ума и образования общества, в особенности женского, в которое я имел счастье быть принят, что не успел еще подумать о климате, — сказал он.");
        defaultDataText.add("Не выпуская уже аббата и Пьера, Анна Павловна для удобства наблюдения присоединила их к общему кружку.");
        return new Object[][]{
                {"input/validData.txt", validDataText},
                {null, defaultDataText},
                {"input/qwerty.txt", defaultDataText},
        };
    }

    @Test(dataProvider = "readTextNegativeData")
    public void readTextNegativeTest(String file, List<String> expected) {
        try {
            List<String> actual = textDataReader.readText(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void readTextExceptionTest() throws IncorrectDataException {
        String file = "input/invalidData.txt";
        textDataReader.readText(file);
    }
}
