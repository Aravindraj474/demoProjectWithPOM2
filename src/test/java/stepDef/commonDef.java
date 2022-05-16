package stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Cart;
import pages.Homepage;
import pages.ProductPage;
import pages.katalon.LoginPage;
import pages.katalon.SummaryPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class commonDef {

    WebDriver driver;
    Response res;
    Scenario scenario;

    @Before
    public void provideScenarios(Scenario scenario){
        this.scenario = scenario;
    }

    @Before("@selenium")
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver","src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After("@selenium")
    public void driverClose() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File img = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("target/"+scenario.getName() +"/screen.png");
        FileUtils.copyFile(img,dest);
        driver.quit();
    }

    @Given("step def is created")
    public void stepDefIsCreated(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Given("login to page")
    public void login(){
        Homepage homepage = new Homepage(driver);
        homepage.clickLoginAndEnterValues("eqaadmin2","eqaadmin2");

        homepage.setSelectProductByName("Samsung galaxy s6");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        homepage.clickCartLink();
        Cart cart = new Cart(driver);
        cart.clickPlaceOrder();
        cart.enterFormData();
        System.out.println("success");
    }

    @Given("get method for (.*) is called$")
    public void getMethodForUrlIsCalled(String url) {
        System.out.println(url);
        res= RestAssured.given().log().all().baseUri(url).get();
//        List<String> data = res.getBody().jsonPath().getList("name");
//        for(int i=0;i<data.size();i++){
//            if (data.get(i).equals("University of Witwatersrand")){
//                System.out.println("state-province: "+ res.getBody().jsonPath().getString("state-province["+i+"]"));
//                break;
//            }
//        }
//        System.out.println(res.getBody().jsonPath().getString("bpi.GBP.rate"));
    }


    @Given("^open url (.*)$")
    public void openUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @And("^login to katalon page$")
    public void loginToKatalonPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserNamePassword("John Doe","ThisIsNotAPassword");
        pages.katalon.Homepage homepage = new pages.katalon.Homepage(driver);
        homepage.selectFacility("Hongkong CURA Healthcare Center");
        homepage.clickReadmissionCheckbox();
        homepage.clickHealthCareProgramRadio();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        homepage.enterVisitDate(sdf.format(d));
        homepage.enterComment("we are booking for general checkup");
        homepage.clickBookAppointment();
        SummaryPage summaryPage = new SummaryPage(driver);
        System.out.println("Booked facility: "+ summaryPage.getFacility());
    }

    @Then("^retrieve (.*) from response$")
    public void retrieveAnyFromResponse(String path) {
        System.out.println(res.getBody().jsonPath().getString(path));
    }
}
