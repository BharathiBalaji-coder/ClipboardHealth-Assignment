package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
    WebElement hamburgerMenu;

    @FindBy(xpath = "//div[normalize-space()='TV, Appliances, Electronics']")
    WebElement TVApplicancesMenu;

    @FindBy(xpath = "//a[normalize-space()='Televisions']")
    WebElement Televisions;

    @FindBy(xpath = "//span[normalize-space()='Brands']")
    WebElement Brands;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
    WebElement Samsung;

    // Initializing the Page Objects:
    public HomePage() {

        PageFactory.initElements(driver, this);

    }

    public void clickOnHamburgerMenu() throws InterruptedException {
        hamburgerMenu.click();
        Thread.sleep(1000);
    }

    public void selectAppliancesMenu() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(5000);
        TVApplicancesMenu.click();
        Thread.sleep(5000);
    }

    public void selectTelevisionsMenu() {
        Televisions.click();
    }

    public void filterSamsungBrand() throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(5000);
        boolean value = Brands.isDisplayed();
        System.out.println(value);
    }

    public void ClickSamsungBrand() throws InterruptedException {
        Thread.sleep(5000);
        Samsung.click();
    }

}
