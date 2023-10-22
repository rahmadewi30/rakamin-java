package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("SauceLab login page")
    public void sauce_lab_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String loginPageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input valid username")
    public void input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input valid password")
    public void input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click Login button")
    public void click_login_button() {
        driver.findElement(By.xpath(" //input[contains(@id,'login-button')]")).click();
    }

    @Then("Dashboard page shown")
    public void dashboard_page_shown() {
        String dashboardAssert = driver.findElement(By.xpath("//div[contains(@class,'app_logo')]")).getText();
        Assert.assertEquals(dashboardAssert,"Swag Labs");
        driver.close();
    }

    @When("input invalid username")
    public void input_invalid_username() {
        driver.findElement(By.id("user-name")).sendKeys("abc123");

    }

    @Then("Error message shown")
    public void error_message_shown() {
        String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
        Assert.assertEquals(errorMessageAssert,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @And("input invalid password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("abc123");
    }

    @When("input locked username")
    public void inputLockedUsername() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("locked out message shown")
    public void lockedOutMessageShown() {
        String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
        Assert.assertEquals(errorMessageAssert,"Epic sadface: Sorry, this user has been locked out.");
        driver.close();
    }

    @When("input (.*) as username$")
    public void input_standard_user_as_username(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("input (.*) as password$")
    public void input_secret_sauce_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("verify (.*) login result$")
    public void verify_success_login_result(String status) {
        if (status.equals("locked")) {
            String errorMessageAssert = driver.findElement(By.xpath("//h3[contains(@data-test,'error')]")).getText();
            Assert.assertEquals(errorMessageAssert, "Epic sadface: Sorry, this user has been locked out.");
        } else if (status.equals("failed")) {
            String errorMessageAssert = driver.findElement(By.xpath("//h3[contains(@data-test,'error')]")).getText();
            Assert.assertEquals(errorMessageAssert, "Epic sadface: Username and password do not match any user in this service");
        } else {
            String dashboardAssert = driver.findElement(By.xpath("//span[contains(@class,'title')]")).getText();
            Assert.assertEquals(dashboardAssert, "Products");
        }
    driver.close();
    }
}

