package sauceLab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginDDT {
    WebDriver driver;

    @When("input <username> as username$")
    public void input_username_as_username(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("input <password> as password$")
    public void input_password_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("verify <status> login result$")
    public void verify_status_login_result(String status){
        if(status.equals("success")){
            String dashboardAssert = driver.findElement(By.xpath("//span[contains(@class,'title')]")).getText();
            Assert.assertEquals(dashboardAssert,"Products");
        } else {
            String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
            Assert.assertEquals(errorMessageAssert,"Epic sadface: Username and password do not match any user in this service");
        }
        driver.quit();
    }
}
