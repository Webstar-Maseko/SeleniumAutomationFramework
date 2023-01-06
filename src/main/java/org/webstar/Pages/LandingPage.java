package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class LandingPage extends CommonFunctions {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[alt='Takealot']")
    private WebElement logo;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = ".search-btn")
    private WebElement searchBtn;

    @FindBy(xpath = "//h3[@class='category-widget-module_title_2--iz']")
    private WebElement searchResults;

    @FindBy(css = ".search-count")
    private WebElement searchCount;

    @FindBy(xpath = "(//button[text()='Add to Cart'])[1]")
    private WebElement addToCartBtn;

    @FindBy(css = ".badge-button")
    private WebElement cartBtn;


    public void doSearch(String item) {
        searchBox.clear();
        searchBox.sendKeys(item);
        click(searchBtn);

    }

    public Boolean validateSearch() {
        return searchResults.isDisplayed();
    }

    public Boolean verifyLogo() {
        return logo.isDisplayed();
    }

    public String getSearchResults() {
        if(waitForElement(searchCount))
            return searchCount.getText();
        else
            return "";
    }

    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public void clickAddToCart() {
        click(addToCartBtn);

    }

    public Cart clickCart() {
        click(cartBtn);
        return new Cart(driver);
    }
}
