package Examples;

import config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

import static org.openqa.selenium.By.className;

public class AmazonAutomation {
    private SeleniumConfig config;
    private WebDriver driver;
    private String url = "http://www.amazon.com/";
    //amazon.com will be loaded in google chrome

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }
    public AmazonAutomation() {
        config = new SeleniumConfig();
        driver = config.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //Google Chrome window will be maximized
    }

    public void goToLoginPage(){
        Actions action = new Actions(driver);
        WebElement signinElement = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(signinElement).build().perform();
        signinElement.click();
        //Login page will be loaded.
    }

    public void typeMail(){
        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("hadijunk7@gmail.com");
        driver.findElement(By.id("continue")).click();
        //Email address will be written on the screen and password page will be loaded.
    }

    public void typePassword(){
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("tHBkKkEgZ8m4eqY");
        driver.findElement(By.id("signInSubmit")).click();
        //Login will be performed and mainpage will be displayed.
    }

    public void performSearch(){
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.clear();
        searchbox.sendKeys("samsung");
        driver.findElement(className("nav-input")).click();
        //"samsung" will be typed in search box and search button will be clicked.
    }

    public boolean checkSearchResult() {
        try {
            driver.findElement(By.className("s-item-container"));
        } catch (NoSuchElementException e) {
            WebElement no_result_item = driver.findElement(By.id("noResultsTitle"));
            System.out.println(no_result_item.getText());
            return false;
        }
        return true;
        //This code confirms that the results for the word "samsung" are displayed,
        //if another word is entered other than this word, the code will give an error warning.
    }

    public void goToSecondPage(){
        driver.findElement(By.id("pagnNextString")).click();
        //"2nd page will be opened among the search results.
    }

    public void clickThirdItem(){
        driver.findElement(By.cssSelector("#result_18 > div > div > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div:nth-child(1) > a > h2")).click();
        //3rd item will be selected in this 2nd page.
    }

    public void addToList() {
        driver.findElement(By.id("add-to-wishlist-button-submit")).click();
        //"The item will be added to wishlist and a pop-up window will be opened.
    }

    public void goWishList() {
        driver.findElement(By.id("WLHUC_result_listName")).click();
        //Wishlist window will be opened.
    }

    public void delete() {
        driver.findElement(By.name("submit.deleteItem")).click();
        //The item on the wishlist will be deleted.
        //It will be written to "deleted" on screen to confirm that the item is deleted.
    }

}
