package org.webstar.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.webstar.Factory.BrowserConfig.BrowserSetup;
import org.webstar.Pages.Cart;
import org.webstar.Pages.Checkout;
import org.webstar.Pages.Dashboard;
import org.webstar.Pages.Login;
import org.webstar.Utilities.ReadProperties;

import java.util.Properties;

public class BaseTest {

    BrowserSetup setup;
    protected WebDriver driver;
    protected Login login;
    protected Dashboard dashboard;
    protected Cart cart;
    protected Checkout checkout;

    protected Properties prop;

    protected String productName;

    @Parameters({"url","browser"})
    @BeforeTest
    protected void setupTest(String url,@Optional String browser) {
        try {
            prop = new ReadProperties().init_Prop();

            if(browser !=null)
                prop.setProperty("browser",browser);

            setup = new BrowserSetup();
            setup.setupBrowser(prop.getProperty("browser"));
            driver = setup.getDriver();
            driver.get("https://rahulshettyacademy.com/client");
            driver.manage().window().maximize();

            productName =prop.getProperty("product");

            //Page objects
            login = new Login(driver);

            //Login

            //


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    @AfterTest
    protected void tearDown() {
        try{
            driver.quit();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public WebDriver getDriver(){
        return driver;
    }
}
