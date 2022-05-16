package pages.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    By facilitySelect = By.name("facility");
    By readmissionCheckbox = By.id("chk_hospotal_readmission");
    By healthCareProgramNoneRadioButton = By.id("radio_program_none");
    By visitDateTextbox = By.id("txt_visit_date");
    By commentTextBox = By.id("txt_comment");
    By bookAppointmentButton = By.id("btn-book-appointment");

    public Homepage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver,10);
    }

    public void selectFacility(String value){
        Select s = new Select(driver.findElement(facilitySelect));
        s.selectByValue(value);
    }

    public void clickReadmissionCheckbox(){
        driver.findElement(readmissionCheckbox).click();
    }

    public void clickHealthCareProgramRadio(){
        driver.findElement(healthCareProgramNoneRadioButton).click();
    }

    public void enterVisitDate(String date){
        driver.findElement(visitDateTextbox).sendKeys(date);
    }

    public void enterComment(String comment){
        driver.findElement(commentTextBox).sendKeys(comment);
    }

    public void clickBookAppointment(){
        driver.findElement(bookAppointmentButton).click();
    }
}

