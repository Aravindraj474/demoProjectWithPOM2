package pages.katalon;

import com.sun.corba.se.spi.orb.StringPair;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    By usernameTextBox = By.id("txt-username");
    By passwordTextBox = By.id("txt-password");
    By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver,10);
    }

    public void enterUserNamePassword(String username, String password){
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
        webDriverWait.until(ExpectedConditions.titleIs("CURA Healthcare Service"));
//        Assert.assertEquals("CURA Healthcare Service",driver.getTitle(),"Expected title is not returned");
    }
}
