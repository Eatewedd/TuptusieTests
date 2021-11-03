package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private By shoeName = By.cssSelector("#box_productfull > " +
            "div.innerbox.product-main-box > div.maininfo.row >" +
            " div > div:nth-child(2) > div.availability.row > div > " +
            "div.shipping-costs > a > span");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getShoeName() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(shoeName)));
        return driver.findElement(shoeName).getText();

    }
}
