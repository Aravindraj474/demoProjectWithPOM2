package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    WebDriver driver;
    WebDriverWait webDriverWait;

//    @FindBy(how = How.ID,using = "login2")
//    WebElement loginLink;
    By loginLink = By.id("login2");
    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    String selectProductByName = "//*[@id=\"tbodyid\"]/div//*[text()='{productName}']";
    By cartLink = By.xpath("//*[text()='Cart']");


    public Homepage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver,10);
//        PageFactory.initElements(driver,this);
    }

    public void clickCartLink(){
        driver.findElement(cartLink).click();
    }

    public void clickLoginAndEnterValues(String username, String password){
        driver.findElement(loginLink).click();
//        loginLink.click();
        driver.findElement(loginUsername).sendKeys(username);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Welcome eqaadmin2']"))));
    }

    public void setSelectProductByName(String name){
        By productWebElement = By.xpath(selectProductByName.replace("{productName}",name));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(productWebElement))).click();
    }
}
