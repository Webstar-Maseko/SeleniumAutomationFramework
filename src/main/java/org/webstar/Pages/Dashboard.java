package org.webstar.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

import java.util.List;

public class Dashboard extends CommonFunctions {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //======>Locators
    @FindBy(xpath = "//p[.='Automation Practice']")
    private WebElement header;

    @FindBy(css = ".card-body")
    private List<WebElement> products;

    By addToCartBtn = By.xpath("//button[contains(text(), ' Add To Cart')]");

    @FindBy(id = "toast-container")
    private WebElement toast;

    @FindBy(xpath = "//button[contains(.,'Cart ')]")
    private WebElement cartBtn;

    //=======>interactions
    public boolean verifyDashboard() {
        return waitForElement(header);
    }

    public WebElement getProduct(String productName) {

        WebElement product;
        if (waitForElements(products)) {
            product = products.stream().filter(item -> item.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);

        } else {
            product = null;
        }
        return product;

    }

    public Boolean clickAddToCart(String productName) {
        WebElement element = getProduct(productName).findElement(addToCartBtn);
        click(element, "Add To Cart");
        if(waitForElement(toast))
            return waitForInvisibilityOfElement(toast);
        else{
            return false;
        }

    }

    public Cart clickCart(){
        click(cartBtn,"Cart");
        return new Cart(driver);
    }

}
