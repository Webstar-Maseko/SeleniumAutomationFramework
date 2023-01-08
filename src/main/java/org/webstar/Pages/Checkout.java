package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class Checkout extends CommonFunctions {
    WebDriver driver;
    public Checkout(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //======>Locators
    @FindBy(css = ".payment > .payment__title")
    private WebElement checkoutHeader;

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement countryInput;

    @FindBy(css = ".btnn")
    private WebElement placeOrderBtn;

    @FindBy(css = ".hero-primary")
    private WebElement orderConfirmation;

    @FindBy(css = ".ta-item")
    private WebElement searchResults;


    //=======>interactions

    public Boolean verifyCheckout(){
        return waitForElement(checkoutHeader);
    }

    public void sendCountry(String country){
        fill(countryInput,"Country", country);
        if (waitForElement(searchResults)) {
            click(searchResults, "Search Resluts");
        }


    }

    public void clickPlaceOrder(){
        click(placeOrderBtn,"Place Order");
    }

    public Boolean verifyOrderplaced(){
        return waitForElement(orderConfirmation);
    }





}
