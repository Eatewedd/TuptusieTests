package addToCart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTests {

    @Test
    public void testAddingToCart() {
        CartPage cartPage = homePage.addToCart();
        assertEquals(cartPage.getShoeName(),
                "sprawdź formy dostawy",
                "Incorrect message");
    }

}
