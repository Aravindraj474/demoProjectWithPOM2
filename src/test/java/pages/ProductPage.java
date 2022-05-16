package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    By addToCartButton = By.xpath("//*[text()='Add to cart']");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver,10);
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
