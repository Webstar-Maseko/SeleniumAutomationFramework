package org.webstar.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.webstar.Base.BaseTest;

public class LandingPageTest extends BaseTest {

    @Test(priority = 1)
    public void navigateToLandingPage() {
        try {
            landingPage.getTitle();
            Assert.assertTrue(landingPage.verifyLogo());

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(dataProvider = "getData", priority = 2)
    public void doSearch(String item) {
        try {
            landingPage.doSearch(item);
            Assert.assertTrue(landingPage.getSearchResults().contains(item));
            landingPage.clickAddToCart();

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(priority = 3)
    public void validateCart() {
        try {
            cart = landingPage.clickCart();
            Assert.assertTrue(cart.verifyCart());
            Assert.assertEquals(cart.getCartLength(), 2);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Playstation 5"},
                {"S22 Ultra"}
        };
    }
}
