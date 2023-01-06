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
        PageFactory.initElements(driver,this);

    }

    //======>Locators
    @FindBy(xpath = "//h1[.='My Cart']")
    private WebElement cartHeader;

    @FindBy(xpath = "//button[.='Checkout']")
    private WebElement checkoutBtn;

    @FindBy(css = ".cartSection > h3")
    private List<WebElement> cartItems;


    //=======>interactions
    public Boolean verifyCart(){
        return waitForElement(cartHeader);
    }

    public Checkout clickCheckout(){
        click(checkoutBtn,"Checkout");
        return new Checkout(driver);

    }

    public Boolean verifyCartItems(String productName){
        Boolean cartItemPresent = false;
        if(waitForElements(cartItems)) {
            cartItemPresent = cartItems.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        }
        return  cartItemPresent;

    }

}
