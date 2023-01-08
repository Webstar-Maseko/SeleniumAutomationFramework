package org.webstar.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class Login extends CommonFunctions {
    WebDriver driver;

    public Login(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //======>Locators
    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "userPassword" )
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginBtn;

    //=======>interactions

    public void fillLoginCred(String useremail,String pswd){
        fill(email,"Email",useremail);
        fill(password,"Password",pswd);
    }

    public Dashboard clickLogin(){
        click(loginBtn,"Login");
        return new Dashboard(driver);
    }
}
