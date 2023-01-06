package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

import java.util.List;

public class Cart extends CommonFunctions {
    WebDriver driver;
    public Cart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()=\"Shopping Cart\"]")
    private WebElement cartHeader;

    @FindBy(tagName = "article")
    private List<WebElement> cartItems;

    public Boolean verifyCart(){
        return waitForElement(cartHeader);
    }

    public int getCartLength(){
        return cartItems.size();
    }
}
