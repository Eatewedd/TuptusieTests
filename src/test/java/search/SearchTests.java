package search;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.testng.Assert.assertEquals;

public class SearchTests extends BaseTests {

    @Test
    public void testSuccessfulSearch(){
        SearchResultsPage searchResultsPage = homePage.enterSearchedItem();
        assertEquals(searchResultsPage.getProductName(),
                "ekoTuptusie APLIKACJA wywrotka (auto)",
                "Product not found");
    }
}
