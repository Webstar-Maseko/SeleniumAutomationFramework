package org.webstar.Factory.Interactions;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.webstar.ExtentReport.ExtentTestManager.getTest;
public class CommonFunctions {
    WebDriver driver;
    WebDriverWait wait;

    JavascriptExecutor js;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));


            js.executeScript("arguments[0].click()", element);
            getTest().log(Status.PASS,"Element was clicked on");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Boolean waitForElement(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;


        }catch (Exception ex){
            ex.printStackTrace();
            return  false;
        }
    }

    public void goToElement(WebElement element) {
        try {

            js.executeScript("arguments[0].scrollIntoView(true)", element);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
