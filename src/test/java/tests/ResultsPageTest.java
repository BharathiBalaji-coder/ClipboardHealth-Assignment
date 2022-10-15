package tests;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ResultsPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.TestUtil.takeScreenshotAtEndOfTest;


public class ResultsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    


    public ResultsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.clickOnAccountsMenu();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.clickOnHamburgerMenu();
        homePage.selectAppliancesMenu();
        homePage.selectTelevisionsMenu();
        homePage.filterSamsungBrand();
        homePage.ClickSamsungBrand();
    }

    @Test(priority = 1)
    public void validateSamsungResultsPrice() throws InterruptedException, IOException {
        //resultsPage.sortSamsungResultsPrice();
        Thread.sleep(5000);
        WebElement resultsPage = driver.findElement(By.xpath("//span[text()='RESULTS']"));
        String actualPageTitle = resultsPage.getText();
        String expectedPageTitle = "RESULTS";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        takeScreenshotAtEndOfTest();

        Thread.sleep(5000);
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']"));
        int size = price.size();
        System.out.println("Size of list = " + size);
        List<String> prices = new ArrayList<>();
        for (WebElement e : price) {
            prices.add(e.getText());
            System.out.println("samsung TV price results:" + e.getText());
        }
        Collections.sort(prices, Collections.reverseOrder());
        for (String tvPrice : prices) {
            System.out.println("Sort the Samsung results with price High to Low:" + tvPrice);
        }
        System.out.println("Second highest price item :\n" + prices.get(1));
        Thread.sleep(4000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");
        takeScreenshotAtEndOfTest();
        Thread.sleep(4000);
        WebElement clickPrice = driver.findElement(By.xpath("//span[normalize-space()='84,999']"));
        clickPrice.click();
        WebElement productTitle = driver.findElement(By.xpath("//span[normalize-space()='84,999']"));
        String actual = productTitle.getText();
        System.out.println(actual);
        String expected = "84,999";
        Assert.assertEquals(expected, actual);
        takeScreenshotAtEndOfTest();
    }

    @Test(priority = 2)
    public void logOut() {
        WebElement accounts1 = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(accounts1).build().perform();
        WebElement signOut = driver.findElement(By.xpath("//span[normalize-space()='Sign Out']"));
        signOut.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
