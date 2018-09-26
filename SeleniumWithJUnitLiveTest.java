import Examples.AmazonAutomation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class SeleniumWithJUnitLiveTest {
    private static AmazonAutomation automation;
    private String MainPageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    private String LoginPageTitle = "Amazon Sign In";

    @BeforeClass
    public static void setUp() {
        automation = new AmazonAutomation();
    }

    @AfterClass
    public static void tearDown() {
        //AmazonAutomation.closeWindow();
    }

    @Test
    public void whenAmazonIsLoadedTitleMustBeSatisfied() {
        String actualTitle = automation.getTitle();
        assertNotNull(actualTitle);
        assertEquals(MainPageTitle, actualTitle);
    }

    @Test
    public void loginTest() {
        String actualTitle = LoginPageTitle;
        assertNotNull(actualTitle);
        assertEquals(LoginPageTitle, actualTitle);

        automation.goToLoginPage();
        automation.typeMail();
        automation.typePassword();
        automation.performSearch();
        Boolean hasResult = automation.checkSearchResult();
        if(hasResult == true) {
            automation.goToSecondPage();
            automation.clickThirdItem();
            automation.addToList();
            automation.goWishList();
            automation.delete();
            //    seleniumExample.closeWindow();
        }
    }
}
