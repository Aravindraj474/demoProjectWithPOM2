package pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    WebDriver driver;
    By placeOrderButton = By.xpath("//*[text()='Place Order']");
    By name = By.id("name");

    public Cart(WebDriver driver){
        this.driver = driver;
    }

    public void clickPlaceOrder(){
        driver.findElement(placeOrderButton).click();
    }

    public void enterFormData(){
        driver.findElement(name).sendKeys("aravind");
        driver.findElement(By.id("country")).sendKeys("india");
        driver.findElement(By.id("city")).sendKeys("djdno");
        driver.findElement(By.id("card")).sendKeys("789-49287-293");
        driver.findElement(By.id("month")).sendKeys("June");
        driver.findElement(By.id("year")).sendKeys("2022");
        driver.findElement(By.xpath("//*[text()='Purchase']")).click();
//        String message = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']//parent::div//p")).getText();
        String message = driver.findElement(By.xpath("//*[contains(@class,'sweet-alert')]//p")).getText();
        System.out.println(message.split("\\n")[0]);
    }
}
