package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultsPage extends TestBase {

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement resultsPage;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOut;

    @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
    WebElement accountsAndListsMenu;

    @FindBy(xpath = "//span[normalize-space()='84,999']")
    WebElement clickSecondHighestPrice;

    // Initializing the Page Objects:
    public ResultsPage() {
        PageFactory.initElements(driver, this);

    }

    public void validateResultsPageTitle() throws InterruptedException {
        Thread.sleep(5000);
        String actualPageTitle = resultsPage.getText();
        String expectedPageTitle = "RESULTS";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    public void sortSamsungResultsPriceInDescendingOrder() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']"));
        int size = price.size();
        System.out.println("Size of list = " + size);
        List<String> prices = new ArrayList<>();
        for (WebElement priceValue : price) {
            prices.add(priceValue.getText());
            System.out.println("samsung TV price results:" + priceValue.getText());
        }

        Collections.sort(prices, Collections.reverseOrder());
        for (String tvPrice : prices) {
            System.out.println("Sort the Samsung results with price High to Low:" + tvPrice);
        }
        System.out.println("Second highest price item :\n" + prices.get(1));
    }

    public void clickSecondHighestPrice() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");
        clickSecondHighestPrice.click();
        String actual = clickSecondHighestPrice.getText();
        System.out.println(actual);
        String expected = "84,999";
        Assert.assertEquals(expected, actual);
    }

    public void signOut() {
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(accountsAndListsMenu).build().perform();
        signOut.click();
    }

}