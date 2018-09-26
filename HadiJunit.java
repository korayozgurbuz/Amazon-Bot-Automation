import Hadi.DevPanelAutomation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class HadiJunit {
    private static DevPanelAutomation automation;
    private String LoginPageTitle = "Oturum Aç | Hadi Oyna BackOffice";

    @BeforeClass
    public static void setUp() {
        automation = new DevPanelAutomation();
    }

    @AfterClass
    public static void tearDown() {
    }

//    @Test
//    public void whenAmazonIsLoadedTitleMustBeSatisfied() {
//        String actualTitle = automation.getTitle();
//        assertNotNull(actualTitle);
//        assertEquals(MainPageTitle, actualTitle);
//    }

    @Test
    public void loginTest() {
//        String actualTitle = LoginPageTitle;
//        assertNotNull(actualTitle);
//        assertEquals(LoginPageTitle, actualTitle);
//
      //  automation.goToLoginPage();
        automation.performLogin();
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
