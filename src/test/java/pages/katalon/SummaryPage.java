package pages.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    By facilityDetails = By.id("facility");

    public SummaryPage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,10);
    }

    public String getFacility(){
        return driver.findElement(facilityDetails).getText();
    }
}
