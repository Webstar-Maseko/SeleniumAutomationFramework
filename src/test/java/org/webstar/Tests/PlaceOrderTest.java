package org.webstar.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.webstar.Base.BaseTest;

public class PlaceOrderTest extends BaseTest {


    @Test(priority = 1, description = "Add product to cart")
    public void add_Product_cart() {
        try {
            login.fillLoginCred(prop.getProperty("email"),prop.getProperty("password") );
            dashboard = login.clickLogin();
            Assert.assertTrue(dashboard.verifyDashboard());
            Assert.assertTrue(dashboard.clickAddToCart(productName));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(dependsOnMethods = {"add_Product_cart"}, priority = 2, description = "Verify product on cart")
    public void view_Product_onCart() {
        try {
            cart = dashboard.clickCart();
            cart.verifyCart();
            Assert.assertTrue(cart.verifyCartItems(productName));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(dependsOnMethods = {"view_Product_onCart"}, priority = 3, description = "Checkout product")
    public void checkout() {
        try {
            checkout = cart.clickCheckout();
            Assert.assertTrue(checkout.verifyCheckout());
            checkout.sendCountry("South Africa");
            checkout.clickPlaceOrder();

            Assert.assertTrue(checkout.verifyOrderplaced());

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }
}
