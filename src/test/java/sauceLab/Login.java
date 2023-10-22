package sauceLab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public void successLogin(){
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply Chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginpageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
        Assert.assertEquals(loginpageAssert,"Swag Labs");

        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click login
        driver.findElement(By.xpath(" //input[contains(@id,'login-button')]")).click();

        //assert dashboard page
        String dashboardAssert = driver.findElement(By.xpath("//span[contains(@class,'title')]")).getText();
        Assert.assertEquals(dashboardAssert,"Products");

        //quit
        driver.close();


    }

    @Test
    public void failedLoginUsername(){
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply Chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginpageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
        Assert.assertEquals(loginpageAssert,"Swag Labs");

        //input email
        driver.findElement(By.id("user-name")).sendKeys("abc123");

        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click login
        driver.findElement(By.xpath(" //input[contains(@id,'login-button')]")).click();

        //assert error message
        String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
        Assert.assertEquals(errorMessageAssert,"Epic sadface: Username and password do not match any user in this service");

        //quit
        driver.close();

    }

    @Test
    public void failedLoginPassword(){
        WebDriver driver;
        String baseUrl = "https://saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply Chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginpageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
        Assert.assertEquals(loginpageAssert,"Swag Labs");

        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //input password
        driver.findElement(By.id("password")).sendKeys("abc123");

        //click login
        driver.findElement(By.xpath(" //input[contains(@id,'login-button')]")).click();

        //assert error message
        String errorMessageAssert = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
        Assert.assertEquals(errorMessageAssert,"Epic sadface: Username and password do not match any user in this service");

        //quit
        driver.close();

    }



}
