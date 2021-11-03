package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    //Creating a field for a web element locator
    private By zalogujSieLink = By.linkText("Zaloguj się");
    private By greetingMessage = By.className("hello");
    private By notClickedSearchBar = By.xpath("/html/body/div[2]/header/div[2]/div[3]/form");
    private By searchBar = By.xpath("/html/body/div[2]/header/div[2]/div[3]/form/div[1]/div[2]/input");
    private By addToCartButton = By.xpath("//*[@id=\"box_mainproducts\"]/div[2]/div/div[1]/div/div[3]/form/fieldset/button/span");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //This method allows our test to interact with the link
    public LoginPage clickZalogujSie(){
        driver.findElement(zalogujSieLink).click();
        return new LoginPage(driver);
    }

    //This method allows verifying if the user is logged correctly
    public String getGreeting(){
        return driver.findElement(greetingMessage).getText();
    }

    public SearchResultsPage enterSearchedItem(){

        FluentWait wait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(notClickedSearchBar)));

        driver.findElement(notClickedSearchBar).click();
        driver.findElement(searchBar).sendKeys("ekotuptusie auto");
        driver.findElement(searchBar).sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }

    public CartPage addToCart(){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(addToCartButton)));
        driver.findElement(addToCartButton).click();
        return new CartPage(driver);
    }




}
