package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ResultsPage extends TestBase {

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement resultsPage;

    // Initializing the Page Objects:
    public ResultsPage() {
        PageFactory.initElements(driver, this);

    }

    public void sortSamsungResultsPrice() throws InterruptedException {
        Thread.sleep(5000);

        String actualPageTitle = resultsPage.getText();
        String expectedPageTitle = "RESULTS";
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        Thread.sleep(5000);


    }
}
