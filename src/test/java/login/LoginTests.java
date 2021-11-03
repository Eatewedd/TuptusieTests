package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfullLogin(){
        //We use the homePage object we inherited, call a method from it
        // and assign it to a new object form the LoginPage
        LoginPage loginPage = homePage.clickZalogujSie();
        loginPage.setEmail("cojeszczepowiesz@gmail.com");
        loginPage.setPassword("automaty123");
        HomePage homePage = loginPage.clickLoginButton();
        assertEquals(homePage.getGreeting(),
                "Witaj cojeszczepowiesz@gmail.com",
                "Incorrect greeting message");
    }
}
