package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    //This i marked as procted so that test classes who inherit from this
    // will have access to this homepage
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
        //Telling Selenium where the driver is on the drive
        System.setProperty("webdriver.chrome.driver", "C:/Users/nogad/IdeaProjects/tuptusie/src/main/resources/chromedriver.exe");

        //Instantiating the driver for Chrome
        driver = new ChromeDriver();

        //Loading the page we want to test
        driver.get("https://www.fiorino.eu/");

        //We're instantiation the HomePage and passing it the driver
        //We're providing a handle in our test layer to our application
        homePage = new HomePage(driver);

//        homePage.closeMailerModal();

        //Maximizing the window
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        //getting the title of the web application
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        //Quitting the browser
        driver.quit();
    }
}
