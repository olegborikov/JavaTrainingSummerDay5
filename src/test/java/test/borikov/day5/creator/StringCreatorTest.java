package test.borikov.day5.creator;

import com.borikov.day5.creator.StringCreator;
import com.borikov.day5.exception.IncorrectDataException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider(name = "createStringTextPositiveData")
    public Object[][] createCreateStringTextPositiveData() {
        String defaultDataText = "— Я так очарован прелестями ума и образования общества, в особенности женского. " +
                "Анна Павловна для удобства наблюдения присоединила их к общему кружку. " +
                "В это время в гостиную вошло какое-то новое лицо. " +
                "Here you can find activities to practise your reading skills.";
        String validDataText = "— Я как-то очаро3ван прелестями,, ума и образования общ2ества. " +
                "  Here you can find activities to practise your reading s3kills. " +
                "Reading will help you to imp3-rove   the language and -build your voca6bulary.";
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createStringTextPositiveData")
    public void createStringTextPositiveTest(String file, String expected) {
        try {
            String actual = stringCreator.createStringText(file);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createStringTextNegativeData")
    public Object[][] createCreateStringTextNegativeData() {
        String defaultDataText = "— Я так очарован прелестями ума и образования общества, в особенности женского.";
        String validDataText = "— Я как-то очаро3ван прелестями,, ума и образования общ2ества." +
                "  Here you can find activities to practise your reading s3kills." +
                "Reading will help you to imp3-rove   the language and -build your voca6bulary";
        return new Object[][]{
                {"qwerty.txt", defaultDataText},
                {"input/validData.txt", validDataText}
        };
    }

    @Test(dataProvider = "createStringTextNegativeData")
    public void createStringTextNegativeTest(String file, String expected) {
        try {
            String actual = stringCreator.createStringText(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createStringExceptionData")
    public Object[][] createCreateStringTextExceptionData() {
        return new Object[][]{
                {null},
                {"input/invalidData.txt"},
        };
    }

    @Test(dataProvider = "createStringExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createStringTextExceptionTest(String file) throws IncorrectDataException {
        stringCreator.createStringText(file);
    }

    @DataProvider(name = "createWordListTextPositiveData")
    public Object[][] createCreateWordListTextPositiveData() {
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
        defaultDataText.add("Анна");
        defaultDataText.add("Павловна");
        defaultDataText.add("для");
        defaultDataText.add("удобства");
        defaultDataText.add("наблюдения");
        defaultDataText.add("присоединила");
        defaultDataText.add("их");
        defaultDataText.add("к");
        defaultDataText.add("общему");
        defaultDataText.add("кружку");
        defaultDataText.add("В");
        defaultDataText.add("это");
        defaultDataText.add("время");
        defaultDataText.add("в");
        defaultDataText.add("гостиную");
        defaultDataText.add("вошло");
        defaultDataText.add("какое");
        defaultDataText.add("то");
        defaultDataText.add("новое");
        defaultDataText.add("лицо");
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
        validDataText.add("Here");
        validDataText.add("you");
        validDataText.add("can");
        validDataText.add("find");
        validDataText.add("activities");
        validDataText.add("to");
        validDataText.add("practise");
        validDataText.add("your");
        validDataText.add("reading");
        validDataText.add("s3kills");
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

    @Test(dataProvider = "createWordListTextPositiveData")
    public void createWordListTextPositiveTest(String file, List<String> expected) {
        try {
            List<String> actual = stringCreator.createWordListText(file);
            assertEquals(actual, expected);

        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @DataProvider(name = "createWordListTextNegativeData")
    public Object[][] createCreateWordListTextNegativea() {
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

    @Test(dataProvider = "createWordListTextNegativeData")
    public void createWordListTextNegativeTest(String file, List<String> expected) {
        try {
            List<String> actual = stringCreator.createWordListText(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("incorrect input");
        }
    }

    @Test(dataProvider = "createStringExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createWordListTextExceptionTest(String file) throws IncorrectDataException {
        stringCreator.createWordListText(file);
    }
}
