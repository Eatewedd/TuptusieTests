package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    private WebDriver driver;
    private By productName = By.cssSelector("#box_mainproducts > div.innerbox > div.products.viewphot.s-row > div:nth-child(1) > div > a.prodname.f-row > span");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
