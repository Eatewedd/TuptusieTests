package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailInput = By.id("mail_input_long");
    private By passInput = By.id("pass_input_long");
    private By zalogujSieButton = By.cssSelector("#box_login > div.innerbox > div > form > fieldset > button > span");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passInput).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(zalogujSieButton).click();
        return new HomePage(driver);
    }

}
