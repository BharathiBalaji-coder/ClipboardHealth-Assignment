package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends TestBase {

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement resultsPage;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOut;

    @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
    WebElement accountsAndListsMenu;

    @FindBy(xpath = "//span[normalize-space()='2,68,311']")
    WebElement clickSecondHighestPrice;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    WebElement clickDropDown;
    @FindBy(xpath = "//a[@id='s-result-sort-select_2']")
    WebElement sortSamsungResults;
    @FindBy(xpath = "//*[@id='feature-bullets']/h1")
    WebElement aboutThisItem;

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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(clickDropDown)).click();
        System.out.println("DropDown label is clicked successfully");
        sortSamsungResults.click();
        System.out.println("Price:High to Low is clicked successfully");
        Thread.sleep(5000);
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']"));
        int size = price.size();
        System.out.println("Size of list = " + size);

        ArrayList<String> prices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            prices.add((price.get(i).getText()));
            System.out.println("samsung TV price results:" + price.get(i).getText());

        }

//        Collections.sort(prices, Collections.reverseOrder());
        for (String tvPrice : prices) {
            System.out.println("Samsung results sorted with price High to Low:" + tvPrice);
        }
        System.out.println("Second highest price item :\n" + prices.get(1));
    }

    public void clickSecondHighestPrice() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");
        clickSecondHighestPrice.click();
    }

    public void aboutThisItemValidation() throws InterruptedException {
        Thread.sleep(7000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());
        //switch to parent window
        driver.switchTo().window(tabs2.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        Thread.sleep(7000);
        boolean value = aboutThisItem.isDisplayed();
        System.out.println(value);
    }

    public void signOut() {
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(accountsAndListsMenu).build().perform();
        signOut.click();
    }

}